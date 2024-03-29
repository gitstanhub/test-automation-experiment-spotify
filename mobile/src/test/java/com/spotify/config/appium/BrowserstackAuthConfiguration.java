package com.spotify.config.appium;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/browserstack_auth.properties"
})
public interface BrowserstackAuthConfiguration extends Config {

    @Key("browserstackUsername")
    String browserstackUsername();

    @Key("browserstackAccessToken")
    String browserstackAccessToken();
}
