package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${market}_web_app.properties",
        "classpath:configuration/uk_web_app.properties"
})
public interface WebAppConfiguration extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("accountsUrl")
    String accountsUrl();

    @Key("locale")
    String locale();
}
