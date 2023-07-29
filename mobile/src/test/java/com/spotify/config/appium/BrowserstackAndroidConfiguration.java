package com.spotify.config.appium;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/browserstack_android_session.properties"
})
public interface BrowserstackAndroidConfiguration extends Config {

    String browserstackRemoteUrl();

    String browserstackProjectName();

    String browserstackTestRunName();

    boolean browserstackDebug();

    String browserstackBuildName();

    String browserstackAppUrl();
}
