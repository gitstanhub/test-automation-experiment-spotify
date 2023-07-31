package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${market}_web_app.properties",
        "classpath:configuration/de_web_app.properties"
})
public interface WebAppConfiguration extends Config {

    String baseUrl();
    String accountsUrl();
    String locale();
}
