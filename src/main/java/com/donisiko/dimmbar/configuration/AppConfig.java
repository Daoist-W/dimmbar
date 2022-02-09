package com.donisiko.dimmbar.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean // this is so a new mapper specific to the context is returned when called
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
