package com.gmail.dmitryzin.rudata.rudatadb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.dmitryzin.rudata.rudatadb.entity.RequiredSecurity;
import com.gmail.dmitryzin.rudata.rudatadb.repository.RequiredSecurityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class RuDataRequiredSecurityService implements RequiredSecurityService{
    private final RequiredSecurityRepository requiredSecurityRepository;
    private final ObjectMapper objectMapper;
    @Override
    public Optional<List<RequiredSecurity>> getRequiredSecurity(String isin){
        return requiredSecurityRepository.getByIsin(isin);
    }

    @Override
    public RequiredSecurity addRequiredSecurity(RequiredSecurity requiredSecurity) {
        try{
            List<RequiredSecurity> isinList = new ArrayList<>();
            isinList.add(requiredSecurity);
            requiredSecurityRepository.saveRequiredSecurityFromDto(objectMapper.writeValueAsString(isinList));
        } catch (JsonProcessingException e){
            log.error("Ошибка сериализации isin: " + requiredSecurity.toString());
            return null;
        }
        return requiredSecurity;
    }

    public boolean deleteRequiredSecurity(String isin){
        requiredSecurityRepository.deleteIsin(isin);
        return true;
    }
}
