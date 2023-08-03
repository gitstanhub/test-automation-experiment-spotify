package com.spotify.pageobjects.pages;

import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
public class HomePage extends PlaywrightPage {

    public HomePage openHomePage() {
        browserActions.navigateToUrl(ConfigProviderWeb.getWebAppConfiguration().baseUrl());
        return this;
    }
}
