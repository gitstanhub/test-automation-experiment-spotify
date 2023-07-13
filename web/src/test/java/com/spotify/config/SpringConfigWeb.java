package com.spotify.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"config", "driver", "locators", "pageobjects", "utils"})
public class SpringConfigWeb {
}
