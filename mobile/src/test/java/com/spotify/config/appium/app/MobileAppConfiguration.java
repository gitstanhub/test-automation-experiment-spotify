package com.spotify.config.appium.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${country}_mobile_app.properties",
        "classpath:configuration/uk_mobile_app.properties"
})
public interface MobileAppConfiguration extends Config {

    @Key("countryCode")
    String countryCode();

    @Key("languageCode")
    String languageCode();

    @Key("localeCode")
    String localeCode();
}
