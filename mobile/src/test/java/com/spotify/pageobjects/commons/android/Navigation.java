package com.spotify.pageobjects.commons.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.spotify.locators.commonslocators.NavBarLocators.NAVIGATION_BAR;

public class Navigation {

    private final AndroidDriver driver;

    public Navigation(AndroidDriver driver) {
        this.driver = driver;
    }

    public Navigation tapHomeButton() {
        getHomeButton().click();
        return this;
    }

    public Navigation tapSearchButton() {
        getSearchButton().click();
        return this;
    }

    public Navigation tapLibraryButton() {
        getLibraryButton().click();
        return this;
    }

    public Navigation tapPremiumButton() {
        getPremiumButton().click();
        return this;
    }

    public Navigation tapBackButton() {
        getBackButton().click();
        return this;
    }

    public Navigation tapCloseButton() {
        getCloseButton().click();
        return this;
    }

    private WebElement getNavBar() {
        return driver.findElement(By.id(NAVIGATION_BAR));
    }

    private WebElement getHomeButton() {
        return driver.findElement(By.id("com.spotify.music:id/home_tab"));
    }

    private WebElement getSearchButton() {
        return driver.findElement(By.id("com.spotify.music:id/search_tab"));
    }

    private WebElement getLibraryButton() {
        return driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
    }

    private WebElement getPremiumButton() {
        return driver.findElement(By.id("com.spotify.music:id/premium_tab"));
    }

    private WebElement getBackButton() {
        return driver.findElement(By.id("com.spotify.music:id/back_button"));
    }

    private WebElement getCloseButton() {
        return driver.findElement(By.id("com.spotify.music:id/close_button"));
    }
}
