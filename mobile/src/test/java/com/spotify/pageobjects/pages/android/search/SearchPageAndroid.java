package com.spotify.pageobjects.pages.android.search;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.search.SearchPage;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        String targetResourceIdFirst = "com.spotify.music:id/title";
        String targetResourceIdSecond = "com.spotify.music:id/header_title";
        String titleFirst = ConfigProviderMobile.getMobileAppLocaleConfig().searchPageTitleTextFirst();
        String titleSecond = ConfigProviderMobile.getMobileAppLocaleConfig().searchPageTitleTextSecond();

        try {
            return getDriver().findElement(AppiumBy.androidUIAutomator(
                    String.format(
                            "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                            targetResourceIdFirst, titleFirst)));
        } catch (NoSuchElementException e) {
            return getDriver().findElement(AppiumBy.androidUIAutomator(
                    String.format(
                            "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                            targetResourceIdSecond, titleSecond)));
        }
    }

    private WebElement getScanSpotifyCodeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.spotify.music:id/camera_button\").description(\"" + ConfigProviderMobile.getMobileAppLocaleConfig().scanSpotifyCodeButtonText() + "\")"));
    }

    private WebElement getSearchField() {
        return androidElementActions.getElementById("com.spotify.music:id/find_search_field");
    }
}
