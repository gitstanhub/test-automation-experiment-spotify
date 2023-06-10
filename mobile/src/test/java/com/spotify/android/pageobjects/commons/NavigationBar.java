package com.spotify.android.pageobjects.commons;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.spotify.android.locators.commonslocators.NavBarLocators.NAVIGATION_BAR;

public class NavigationBar {

    private final AndroidDriver driver;

    public NavigationBar(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getNavigationBar() {
        return driver.findElement(By.id(NAVIGATION_BAR));
    }
}
