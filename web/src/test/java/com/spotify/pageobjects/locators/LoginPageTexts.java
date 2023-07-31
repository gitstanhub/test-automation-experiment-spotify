package com.spotify.pageobjects.locators;

import com.spotify.config.ConfigProviderWeb;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class LoginPageTexts {

    @Getter
    private static String loggedInStateTitle = ConfigProviderWeb.getWebAppLocaleConfig().loggedInStateTitle();

    @Getter
    private static String loggedOutStateTitle = ConfigProviderWeb.getWebAppLocaleConfig().loggedOutStateTitle();
}
