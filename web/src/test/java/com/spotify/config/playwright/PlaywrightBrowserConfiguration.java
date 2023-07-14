package com.spotify.config.playwright;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/playwright_browser_configuration.properties",
        "system:properties"
})
public interface PlaywrightBrowserConfiguration extends Config {

    @Key("chromiumBrowserVersion")
    String chromiumBrowserVersion();

    @Key("firefoxBrowserVersion")
    String firefoxBrowserVersion();

    @Key("webkitBrowserVersion")
    String webkitBrowserVersion();

    @Key("moonUrl")
    String moonUrl();

    @Key("playwrightTimeout")
    double playwrightTimeout();
}
