package com.spotify.pageobjects.pages.android.search;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.search.SearchPage;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Lazy
@Slf4j
public class SearchPageAndroid extends AppiumPageAndroid implements SearchPage {

    public SearchPageAndroid verifySearchPageIsOpened() {
        elementChecksMobile.assertElementIsVisible(getSearchPageTitle());
        return this;
    }

    public SearchPageAndroid tapGlobalSearchField() {
        getSearchField().click();
        return this;
    }

    private WebElement getSearchPageTitle() {
        return getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.spotify.music:id/title' and @text='Search']"));
    }

    private WebElement getScanSpotifyCodeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/camera_button\").description(\"Scan Spotify code\")"));
    }

    private WebElement getSearchField() {
        return getDriver().findElement(By.id("com.spotify.music:id/find_search_field"));
    }
}

//    private final AndroidDriver driver;
//    private final ElementChecks elementChecks;
//    private final  WebDriverWait wait;
//
//    public SearchPageAndroid(AndroidDriver driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//        this.elementChecks = new ElementChecks(driver, wait);
//    }
