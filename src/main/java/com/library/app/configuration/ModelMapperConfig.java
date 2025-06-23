package com.library.app.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean("model_mapper")
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
