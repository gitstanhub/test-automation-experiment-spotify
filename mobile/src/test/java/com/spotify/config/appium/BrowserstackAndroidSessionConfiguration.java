package com.spotify.config.appium;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/browserstack_android_session.properties"
})
public interface BrowserstackAndroidSessionConfiguration extends Config {

    @Key("browserstackRemoteUrl")
    String browserstackRemoteUrl();

    @Key("browserstackProjectName")
    String browserstackProjectName();

    @Key("browserstackDebug")
    boolean browserstackDebug();

    @Key("browserstackBuildName")
    String browserstackBuildName();

    @Key("browserstackAppUrl")
    String browserstackAppUrl();
}
