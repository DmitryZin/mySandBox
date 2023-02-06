package com.gmail.dmitryzin.rudata.rudatadb.dto;

import lombok.Data;

@Data
public class Paginator {
    private final int pageNum;
    private final int pageCount;
}
