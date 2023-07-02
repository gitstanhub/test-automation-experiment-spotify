package com.spotify.android.pageobjects.pages;

import com.spotify.android.utils.assertions.ElementChecks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private final AndroidDriver driver;
    private final ElementChecks elementChecks;
    private final  WebDriverWait wait;

    public SearchPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.elementChecks = new ElementChecks(driver, wait);
    }

    public SearchPage verifySearchPageIsOpened() {
        elementChecks.assertElementIsVisible(getSearchPageTitle());
        return this;
    }

    public SearchPage tapGlobalSearchField() {
        getSearchField().click();
        return this;
    }

    private WebElement getSearchPageTitle() {
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='Search']"));
    }

    private WebElement getScanSpotifyCodeButton() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/camera_button\").description(\"Scan Spotify code\")"));
    }

    private WebElement getSearchField() {
        return driver.findElement(By.id("com.spotify.music:id/find_search_field"));
    }
}
