package com.felipe.models.Scraping;

import lombok.Data;

import java.lang.reflect.Field;

@Data
public class ScrapperElement {
    private String xpath;

    private String field;
}
