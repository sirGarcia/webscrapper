package com.felipe.models;


import com.felipe.models.Scraping.ScrapperElement;
import com.felipe.utils.PagingMethod;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@Data
public class Site {
    private String url;
    private String gridElementClass;
    private PagingMethod paging;
    private List<ScrapperElement> listToMap;
}
