package com.felipe.models;


import com.felipe.utils.PagingMethod;
import lombok.Data;

@Data
public class Site {
    private String url;
    private String gridElementClass;
    private String gridClass;
    private PagingMethod paging;
}
