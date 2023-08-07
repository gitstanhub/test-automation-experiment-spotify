package com.spotify.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spotify.pageobjects", "com.spotify.utils", "com.spotify.config"})
public class SpringConfigMobile {
}
