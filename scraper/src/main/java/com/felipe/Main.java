package com.felipe;

import com.felipe.models.Site;
import com.felipe.tasks.ScrapingTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Site site = new Site();
        site.setUrl("https://www.continente.pt/mercearia/?start=0&srule=FOOD_Mercearia&pmin=0.01");
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new ScrapingTask(site));
    }
}