package com.spotify.pageobjects.commons.android.navigation;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.navigation.Navigation;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static com.spotify.locators.commons.NavBarLocators.NAVIGATION_BAR;

@Slf4j
@Component
public class NavigationAndroid extends AppiumPageAndroid implements Navigation {

    public NavigationAndroid tapHomeButton() {
        getHomeButton().click();
        return this;
    }

    public NavigationAndroid tapSearchButton() {
        getSearchButton().click();
        return this;
    }

    public NavigationAndroid tapLibraryButton() {
        getLibraryButton().click();
        return this;
    }

    public NavigationAndroid tapPremiumButton() {
        getPremiumButton().click();
        return this;
    }

    public NavigationAndroid tapBackButton() {
        getBackButton().click();
        return this;
    }

    public NavigationAndroid tapCloseButton() {
        getCloseButton().click();
        return this;
    }

    private WebElement getNavBar() {
        return androidElementActions.getElementById(NAVIGATION_BAR);
    }

    private WebElement getHomeButton() {
        return androidElementActions.getElementById("com.spotify.music:id/home_tab");
    }

    private WebElement getSearchButton() {
        return androidElementActions.getElementById("com.spotify.music:id/search_tab");
    }

    private WebElement getLibraryButton() {
        return androidElementActions.getElementById("com.spotify.music:id/your_library_tab");
    }

    private WebElement getPremiumButton() {
        return androidElementActions.getElementById("com.spotify.music:id/premium_tab");
    }

    private WebElement getBackButton() {
        return androidElementActions.getElementById("com.spotify.music:id/back_button");
    }

    private WebElement getCloseButton() {
        return androidElementActions.getElementById("com.spotify.music:id/close_button");
    }
}
