package com.felipe.service;


import com.felipe.models.Scraping.ScrapperElement;
import com.felipe.models.Site;
import com.felipe.repository.GroceryRepository;
import com.felipe.tasks.ScrapingTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository repository;

    public void startNewScrape(Site site){
//        site.setUrl("https://www.continente.pt/mercearia/?start=0&srule=FOOD_Mercearia&pmin=0.01");
//        site.setGridElementClass("//div[@class=\"product\"]");
//        ScrapperElement element = new ScrapperElement();
//        element.setField("title");
//        element.setXpath("//a[contains(@class, \"col-tile--description\")]");
//        site.setListToMap(List.of(element));
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new ScrapingTask(site, repository));
    }
}
