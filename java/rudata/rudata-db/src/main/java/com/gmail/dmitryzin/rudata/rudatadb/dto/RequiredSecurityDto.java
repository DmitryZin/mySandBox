package com.gmail.dmitryzin.rudata.rudatadb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequiredSecurityDto {
    private final String isin;
    private final Boolean active;

}
