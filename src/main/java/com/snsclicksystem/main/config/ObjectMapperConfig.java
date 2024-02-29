package com.snsclicksystem.main.config;

import com.snsclicksystem.main.util.modelmapper.ObjectMapper;
import com.snsclicksystem.main.util.modelmapper.ObjectMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper modelMapper() {
        return new ObjectMapperImpl();
    }
}
