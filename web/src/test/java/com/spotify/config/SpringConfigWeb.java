package com.spotify.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spotify.utils", "com.spotify.pageobjects.base", "com.spotify.pageobjects.commons", "com.spotify.pageobjects.pages"})
public class SpringConfigWeb {
}



//@ComponentScan(basePackages = {"config", "driver", "locators", "pageobjects", "utils", "tests"})
