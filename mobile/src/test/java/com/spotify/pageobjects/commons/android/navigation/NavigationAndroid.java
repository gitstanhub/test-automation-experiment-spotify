package com.spotify.pageobjects.commons.android.navigation;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.navigation.Navigation;
import com.spotify.utils.assertions.ElementChecksMobile;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.spotify.driver.AppiumDriverHandler.getDriver;
import static com.spotify.locators.commonslocators.NavBarLocators.NAVIGATION_BAR;

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
        return getDriver().findElement(By.id(NAVIGATION_BAR));
    }

    private WebElement getHomeButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/home_tab"));
    }

    private WebElement getSearchButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/search_tab"));
    }

    private WebElement getLibraryButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/your_library_tab"));
    }

    private WebElement getPremiumButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/premium_tab"));
    }

    private WebElement getBackButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/back_button"));
    }

    private WebElement getCloseButton() {
        return getDriver().findElement(By.id("com.spotify.music:id/close_button"));
    }
}

//    private final AndroidDriver driver;
//
//    public NavigationAndroid(AndroidDriver driver) {
//        this.driver = driver;
//    }
