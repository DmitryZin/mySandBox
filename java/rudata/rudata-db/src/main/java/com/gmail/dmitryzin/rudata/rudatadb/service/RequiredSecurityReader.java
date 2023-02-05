package com.gmail.dmitryzin.rudata.rudatadb.service;

import com.gmail.dmitryzin.rudata.rudatadb.entity.RequiredSecurity;

import java.util.List;
import java.util.Optional;

public interface RequiredSecurityReader {
    Optional<List<RequiredSecurity>> getRequiredSecurity(String isin);
}
