package com.gmail.dmitryzin.rudata.rudatadb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;

import java.sql.Timestamp;

@Data
@Getter
@AllArgsConstructor
public class RequiredSecurity {
    @Id
    private Integer id;
    private Timestamp timestamp;
    private String isin;
    private Boolean active;
}
