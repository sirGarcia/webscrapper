package com.felipe.tasks;

import com.felipe.models.Site;
import com.felipe.models.grocery.GroceryProduct;
import com.felipe.repository.GroceryRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Slf4j
public class ScrapingTask implements Runnable{

    private final Site site;
    private final WebClient webClient = new WebClient();

    private final GroceryRepository repository;

    public ScrapingTask(Site site, GroceryRepository repository) {
        this.site = site;
        this.repository = repository;
    }

    @Override
    public void run() {
        System.out.println("started");
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage page = webClient.getPage(site.getUrl());
            List<HtmlElement> list = page.getByXPath(site.getGridElementClass());
            log.info("grid items size: {}", list.size());
            list.forEach(htmlElement -> {
                GroceryProduct product = new GroceryProduct();
                System.out.println(htmlElement.asXml());
                site.getListToMap().forEach(scrapperElement -> {
                    try {
                        HtmlElement innerElement = htmlElement.getFirstByXPath(scrapperElement.getXpath());
                        Field curField = product.getClass().getDeclaredField(scrapperElement.getField());
                        curField.setAccessible(true);
                        ReflectionUtils.setField(curField, product, innerElement.asNormalizedText());
                    } catch (NoSuchFieldException e) {
                        throw new RuntimeException(e);
                    }
                });
                System.out.println(product.toString());
                repository.save(product);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
