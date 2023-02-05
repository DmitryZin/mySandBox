package com.gmail.dmitryzin.rudata.rudatadb.controller;

import com.gmail.dmitryzin.rudata.rudatadb.converter.RequiredSecurityConverter;
import com.gmail.dmitryzin.rudata.rudatadb.dto.RequiredSecurityDto;
import com.gmail.dmitryzin.rudata.rudatadb.service.RequiredSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class RequiredSecurityController {
    private final RequiredSecurityService requiredSecurityService;
    @GetMapping("/required_security/{isin}")
    public List<RequiredSecurityDto> getRequiredSecurityDtoList(@PathVariable String isin){
        return RequiredSecurityConverter.convertRequiredSecurityList(requiredSecurityService.getRequiredSecurity(isin).orElseThrow());
    }

    @PostMapping("/required_security/add")
    @ResponseStatus(HttpStatus.CREATED)
    public RequiredSecurityDto addIsin(RequiredSecurityDto requiredSecurityDto){
        return RequiredSecurityConverter.convertRequiredSecurity(requiredSecurityService.addRequiredSecurity(RequiredSecurityConverter.convertRequiredSecurityDto(requiredSecurityDto)));
    }

    @DeleteMapping("/required_security/delete/{isin}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("isin") String isin){
        if(!requiredSecurityService.deleteRequiredSecurity(isin))
            return "Не удалось удалить";
        return "Успешно удалено";
    }
}
