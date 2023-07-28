package com.spotify.config.restassured;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/api_auth.properties"
})
public interface RestAssuredApiAuthConfiguration extends Config {

    String clientId();

    String clientSecret();
}
