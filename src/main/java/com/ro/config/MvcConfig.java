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
        //DEFAULT
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error").setViewName("error");

        //LOGIN STRANA
        registry.addViewController("/login_page").setViewName("login_page");

        //KLIJENT - KOMPANIJA
        registry.addViewController("/k_pocetna").setViewName("k_pocetna");
        registry.addViewController("/k_student_profil").setViewName("k_student_profil");
        registry.addViewController("/k_kompanija_profil").setViewName("k_kompanija_profil");

        //KLIJENT - STUDENT
        registry.addViewController("/s_pocetna").setViewName("s_pocetna");
        registry.addViewController("/s_student_profil").setViewName("s_student_profil");
        registry.addViewController("/s_kompanija_profil").setViewName("s_kompanija_profil");
    }
}
