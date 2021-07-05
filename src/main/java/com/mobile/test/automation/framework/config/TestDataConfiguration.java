package com.mobile.test.automation.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Lazy
@Component
public class TestDataConfiguration
{
    @Bean
    public Faker faker()
    {
        return Faker.instance();
    }

}
