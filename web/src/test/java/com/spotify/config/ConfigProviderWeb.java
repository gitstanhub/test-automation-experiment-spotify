package com.spotify.config;

import com.spotify.config.playwright.PlaywrightBrowserConfiguration;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProviderWeb {

    @Getter
    private static final PlaywrightBrowserConfiguration playwrightBrowserConfiguration = ConfigFactory.create(
                PlaywrightBrowserConfiguration.class, System.getProperties());

//    public static PlaywrightBrowserConfiguration getPlaywrightBrowserConfiguration() {
//        return playwrightBrowserConfiguration;
//    }
}
