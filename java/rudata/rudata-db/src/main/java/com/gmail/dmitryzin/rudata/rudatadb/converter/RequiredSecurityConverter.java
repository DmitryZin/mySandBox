package com.gmail.dmitryzin.rudata.rudatadb.converter;

import com.gmail.dmitryzin.rudata.rudatadb.dto.RequiredSecurityDto;
import com.gmail.dmitryzin.rudata.rudatadb.entity.RequiredSecurity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequiredSecurityConverter {
    private RequiredSecurityConverter(){

    }
    public static RequiredSecurityDto convertRequiredSecurity(RequiredSecurity requiredSecurity){
        return new RequiredSecurityDto(requiredSecurity.getIsin(), requiredSecurity.getActive());
    }

    public static List<RequiredSecurityDto> convertRequiredSecurityList(List<RequiredSecurity> requiredSecurityList){
        List<RequiredSecurityDto> requiredSecurityDtoList = new ArrayList<>();
        for (RequiredSecurity requiredSecurity:requiredSecurityList) {
            requiredSecurityDtoList.add(convertRequiredSecurity(requiredSecurity));
        }
        return requiredSecurityDtoList;
    }

    public static RequiredSecurity convertRequiredSecurityDto(RequiredSecurityDto requiredSecurityDto){
        return new RequiredSecurity(null, null, requiredSecurityDto.getIsin(), requiredSecurityDto.getActive());
    }
}
