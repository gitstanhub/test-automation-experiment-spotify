package com.spotify.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/${market}_web_app_locale.properties",
        "classpath:configuration/de_web_app_locale.properties"
})
public interface WebAppLocaleConfig extends Config {

    //LoginPage
    String loggedInStateTitle();
    String loggedOutStateTitle();

    //LibraryPage
    String libraryPageTitle();
}
