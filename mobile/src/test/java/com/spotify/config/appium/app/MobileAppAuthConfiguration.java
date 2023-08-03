package com.spotify.config.appium.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/mobile_app_auth.properties"
})
public interface MobileAppAuthConfiguration extends Config {

    String username();
    String password();
}
