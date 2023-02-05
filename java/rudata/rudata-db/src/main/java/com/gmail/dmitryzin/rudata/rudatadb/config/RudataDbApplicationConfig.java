package com.gmail.dmitryzin.rudata.rudatadb.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@RequiredArgsConstructor
public class RudataDbApplicationConfig {
    private final DataSourceProperties dataSourceProperties;
}
