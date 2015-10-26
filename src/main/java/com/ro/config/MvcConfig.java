package com.ro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ognjen on 23.10.15..
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/pocetna").setViewName("pocetna");
        registry.addViewController("/student").setViewName("student");
        registry.addViewController("/kompanija_profil").setViewName("kompanija_profil");
    }
}
