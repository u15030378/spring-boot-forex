package com.in28minutes.springboot.microservice.example.currencyconversion.configserver;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .ignoringAntMatchers("/encrypt/**")
                .ignoringAntMatchers("/decrypt/**");

        super.configure(http);
    }
}
