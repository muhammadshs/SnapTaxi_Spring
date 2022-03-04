package com.dwteam.config;

import com.dwteam.person.PersonLoginCon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class Config {
    @Bean
    @RequestScope
    public PersonLoginCon personLoginCon(){
        return new PersonLoginCon();
    }
}
