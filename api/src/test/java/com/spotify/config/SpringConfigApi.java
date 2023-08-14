package com.spotify.config;

import com.spotify.config.restassured.RestAssuredApiConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spotify.clients", "com.spotify.utils", "com.spotify.config"})
public class SpringConfigApi {
}
