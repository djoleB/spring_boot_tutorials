package com.georgedoestechstuff.rest.demo.name.config;

import com.georgedoestechstuff.rest.demo.name.mapper.NameMapper;
import com.georgedoestechstuff.rest.demo.name.dao.NameRepository;
import com.georgedoestechstuff.rest.demo.name.service.NameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameConfig {

    private final NameRepository nameRepository;

    public NameConfig(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Bean
    public NameService nameService() {
        return new NameService(nameRepository, nameMapper());
    }

    public NameMapper nameMapper() {
        return new NameMapper();
    }

}
