package com.spotify.config;

import com.spotify.config.restassured.RestAssuredApiConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spotify.clients"})
public class SpringConfigApi {

    @Bean
    public RestAssuredApiConfiguration restAssuredApiConfiguration() {
        return ConfigFactory.create(RestAssuredApiConfiguration.class, System.getProperties());
    }
}
