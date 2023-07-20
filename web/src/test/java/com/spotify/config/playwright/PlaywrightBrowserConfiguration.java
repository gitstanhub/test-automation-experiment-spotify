package com.spotify.config.playwright;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${env}.properties",
        "classpath:configuration/local.properties"
})
public interface PlaywrightBrowserConfiguration extends Config {

    @DefaultValue("chromium")
    String browser();

//    @Key("chromiumBrowserVersion")
    String chromiumBrowserVersion();

//    @Key("firefoxBrowserVersion")
    String firefoxBrowserVersion();

//    @Key("webkitBrowserVersion")
    String webkitBrowserVersion();

//    @Key("moonUrl")
    String moonUrl();

//    @Key("moonStatusUrl")
    String moonStatusUrl();

//    @Key("playwrightBrowserTimeout")
    double playwrightBrowserTimeout();

//    @Key("remoteEnabled")
    boolean remoteEnabled();

//    @Key("headlessEnabled")
    boolean headlessEnabled();

//    @Key("videoRecordingEnabled")
    boolean videoRecordingEnabled();
}
