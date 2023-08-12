package com.spotify.config.appium.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${market}_mobile_app.properties",
        "classpath:configuration/uk_mobile_app.properties"
})
public interface MobileAppConfiguration extends Config {

    @Key("country")
    String country();

    @Key("language")
    String language();

    @Key("locale")
    String locale();
}
