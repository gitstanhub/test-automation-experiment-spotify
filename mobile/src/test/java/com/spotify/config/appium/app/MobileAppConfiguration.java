package com.spotify.config.appium.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/mobile_app_auth.properties"
})
public interface MobileAppConfiguration extends Config {

    @Config.DefaultValue("DE")
    String market();
}
