package com.spotify.config.restassured;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${country}_api.properties",
        "classpath:configuration/de_api.properties",
})
public interface RestAssuredApiConfiguration extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("countryCode")
    String countryCode();

    @Key("marketCode")
    String marketCode();
}
