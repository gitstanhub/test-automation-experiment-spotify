package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/web_app_auth.properties"
})
public interface WebAppAuthConfiguration extends Config {

    String username();
    String password();
}
