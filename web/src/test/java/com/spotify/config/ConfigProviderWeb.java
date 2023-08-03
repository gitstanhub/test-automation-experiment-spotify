package com.spotify.config;

import com.spotify.config.app.WebAppAuthConfiguration;
import com.spotify.config.app.WebAppConfiguration;
import com.spotify.config.app.WebAppLocaleConfig;
import com.spotify.config.playwright.PlaywrightBrowserConfiguration;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProviderWeb {

    static {
        System.setProperty("owner.encoding", "UTF-8");
    }

    @Getter
    private static final PlaywrightBrowserConfiguration playwrightBrowserConfiguration = ConfigFactory.create(
                PlaywrightBrowserConfiguration.class, System.getProperties());

    @Getter
    private static final WebAppAuthConfiguration webAppAuthConfiguration = ConfigFactory.create(
            WebAppAuthConfiguration.class, System.getProperties());

    @Getter
    private static final WebAppConfiguration webAppConfiguration = ConfigFactory.create(
            WebAppConfiguration.class, System.getProperties());

    @Getter
    private static final WebAppLocaleConfig webAppLocaleConfig = ConfigFactory.create(
            WebAppLocaleConfig.class, System.getProperties());
}
