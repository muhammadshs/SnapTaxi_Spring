package com.dwteam.driver;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// باید اصلاح شود
@Configuration
public class DriverConfig {
    @Bean
    @Scope("request")
    public Long getId(Long id){
        Long l= id;
        return l ;
    }
}
