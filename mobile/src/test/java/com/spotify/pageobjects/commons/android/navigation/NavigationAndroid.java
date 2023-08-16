package com.spotify.pageobjects.commons.android.navigation;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.navigation.Navigation;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static com.spotify.locators.commons.NavigationLocators.*;

@Slf4j
@Component
public class NavigationAndroid extends AppiumPageAndroid implements Navigation {

    @Step
    public NavigationAndroid tapHomeButton() {
        getHomeButton().click();
        return this;
    }

    @Step
    public NavigationAndroid tapSearchButton() {
        getSearchButton().click();
        return this;
    }

    @Step
    public NavigationAndroid tapLibraryButton() {
        getLibraryButton().click();
        return this;
    }

    @Step
    public NavigationAndroid tapPremiumButton() {
        getPremiumButton().click();
        return this;
    }

    @Step
    public NavigationAndroid tapBackButton() {
        getBackButton().click();
        return this;
    }

    @Step
    public NavigationAndroid tapCloseButton() {
        getCloseButton().click();
        return this;
    }

    private WebElement getNavBar() {
        return androidElementActions.getElementById(NAVIGATION_BAR);
    }

    private WebElement getHomeButton() {
        return androidElementActions.getElementById(HOME_BUTTON);
    }

    private WebElement getSearchButton() {
        return androidElementActions.getElementById(SEARCH_BUTTON);
    }

    private WebElement getLibraryButton() {
        return androidElementActions.getElementById(LIBRARY_BUTTON);
    }

    private WebElement getPremiumButton() {
        return androidElementActions.getElementById(PREMIUM_BUTTON);
    }

    private WebElement getBackButton() {
        return androidElementActions.getElementById(BACK_BUTTON);
    }

    private WebElement getCloseButton() {
        return androidElementActions.getElementById(CLOSE_BUTTON);
    }
}
