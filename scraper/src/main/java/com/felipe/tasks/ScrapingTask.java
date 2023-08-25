package com.felipe.tasks;

import com.felipe.models.Site;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


import java.io.IOException;
import java.util.List;

public class ScrapingTask implements Runnable{

    private final Site site;
    private final WebClient webClient = new WebClient();

    public ScrapingTask(Site site) {
        this.site = site;
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
    }

    @Override
    public void run() {
        System.out.println("started");
        try {
            HtmlPage page = webClient.getPage(site.getUrl());
            List<HtmlElement> list = page.getByXPath("//div[@class=\"product\"]");
            System.out.println("List size " + list.size());
            list.forEach(htmlElement -> {
                //List<HtmlElement> anchor = htmlElement.getByXPath("//div[contains(@class, \"ct-tile-body\")]");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println(htmlElement.asXml());
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
