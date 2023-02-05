package com.gmail.dmitryzin.rudata.rudatadb.service;

import com.gmail.dmitryzin.rudata.rudatadb.entity.RequiredSecurity;

public interface RequiredSecurityWriter {
    RequiredSecurity addRequiredSecurity(RequiredSecurity requiredSecurity);
    boolean deleteRequiredSecurity(String isin);
}
