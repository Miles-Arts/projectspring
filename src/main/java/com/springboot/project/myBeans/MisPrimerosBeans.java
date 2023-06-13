package com.springboot.project.myBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MisPrimerosBeans {

    @Bean
    public MyBean crearMiBean () {

        return new MyBean();
    }

}
