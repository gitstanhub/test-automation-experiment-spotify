package com.spotify.android.config.appium;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties"
})
public interface AppiumDriverConfiguration extends Config {


}
