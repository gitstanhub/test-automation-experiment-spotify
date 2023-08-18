package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${country}_web_app.properties",
        "classpath:configuration/uk_web_app.properties"
})
public interface WebAppConfiguration extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("accountsUrl")
    String accountsUrl();

    @Key("countryCode")
    String countryCode();

    @Key("localeCode")
    String localeCode();
}
