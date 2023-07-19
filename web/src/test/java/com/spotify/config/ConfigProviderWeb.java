package com.spotify.config;

import com.spotify.config.playwright.PlaywrightBrowserConfiguration;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProviderWeb {

    private static final PlaywrightBrowserConfiguration playwrightBrowserConfiguration = ConfigFactory.create(
                PlaywrightBrowserConfiguration.class, System.getProperties());

//    static {
//        playwrightBrowserConfiguration = ConfigFactory.create(
//                PlaywrightBrowserConfiguration.class, System.getProperties());
//    }

    public static PlaywrightBrowserConfiguration getPlaywrightBrowserConfiguration() {
        return playwrightBrowserConfiguration;
    }
}
