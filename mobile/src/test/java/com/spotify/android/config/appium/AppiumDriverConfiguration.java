package com.spotify.android.config.appium;

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

    @DefaultValue("Pixel 4 XL")
    String deviceName();
}
