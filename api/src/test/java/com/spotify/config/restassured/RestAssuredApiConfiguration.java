package com.spotify.config.restassured;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/api.properties"
})
public interface RestAssuredApiConfiguration extends Config {

    String baseUrl();

    @DefaultValue("DE")
    String market();
}
