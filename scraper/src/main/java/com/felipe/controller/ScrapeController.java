package com.felipe.controller;

import com.felipe.models.Scraping.ScrapperElement;
import com.felipe.models.Site;
import com.felipe.service.GroceryService;
import com.felipe.tasks.ScrapingTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/scrapper")
public class ScrapeController {

    @Autowired
    public GroceryService service;

    @RequestMapping("/start")
    public Boolean startScrapper(@RequestBody Site site){
        service.startNewScrape(site);
        return true;
    }
}
