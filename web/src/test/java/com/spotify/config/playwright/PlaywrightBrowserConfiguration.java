package com.spotify.config.playwright;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${environment}.properties",
        "classpath:configuration/local.properties"
})
public interface PlaywrightBrowserConfiguration extends Config {

    @DefaultValue("chromium")
    String browser();

    String chromiumBrowserVersion();

    String firefoxBrowserVersion();

    String webkitBrowserVersion();

    String moonUrl();

    String moonStatusUrl();

    double playwrightBrowserTimeout();

    boolean remoteEnabled();

    boolean headlessEnabled();

    boolean videoRecordingEnabled();
}
