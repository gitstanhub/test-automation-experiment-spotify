package com.spotify.config.appium;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties"
})
public interface AppiumDriverConfiguration extends Config {

    @DefaultValue("local")
    String environment();

    @DefaultValue("android")
    String platformName();

    @DefaultValue("pixel_4_xl")
    String deviceName();
}
