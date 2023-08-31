package com.felipe;

import com.felipe.models.Scraping.ScrapperElement;
import com.felipe.models.Site;
import com.felipe.models.grocery.GroceryProduct;
import com.felipe.repository.GroceryRepository;
import com.felipe.tasks.ScrapingTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * div/pwc-tile--price-secondary
 * 	span/pwc-m-unit -> unit
 * 	span/ct-price-value -> priceperunit
 *
 * div/pwc-tile--price-primary
 * 	span/ct-price-formatted -> price
 * 	span/pwc-m-unit -> unit
 *
 * div/col-tile--brand-wrapper
 * 	p/pwc-tile--quantity -> quantity
 * 	p/pwc-tile--brand -> brand
 */
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = GroceryRepository.class)
public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        SpringApplication.run(Main.class, args);

    }
}