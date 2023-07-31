package com.spotify.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spotify.utils", "com.spotify.pageobjects.base", "com.spotify.pageobjects.commons", "com.spotify.pageobjects.pages", "com.spotify.pageobjects.locators"})
public class SpringConfigWeb {
}
