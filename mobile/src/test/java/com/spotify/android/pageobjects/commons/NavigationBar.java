package com.spotify.android.pageobjects.commons;

import com.spotify.android.pageobjects.locators.CommonsLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.spotify.android.pageobjects.locators.CommonsLocators.NAVIGATION_BAR;

public class NavigationBar {

    private final AndroidDriver driver;

    public NavigationBar(AndroidDriver providedDriver) {
        this.driver = providedDriver;
    }

    public WebElement getNavigationBar() {
        return driver.findElement(By.id(NAVIGATION_BAR));
    }
}
