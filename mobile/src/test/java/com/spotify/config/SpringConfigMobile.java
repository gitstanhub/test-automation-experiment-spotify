package com.spotify.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spotify.pageobjects", "com.spotify.utils", "com.spotify.config"})

//@ComponentScan(basePackages = {"com.spotify.pageobjects.commons", "com.spotify.pageobjects.pages", "com.spotify.utils",
//        "com.spotify.utils.assertions",
//        "com.spotify.config",
//        "com.spotify.pageobjects.pages.android.library"})
public class SpringConfigMobile {
}
