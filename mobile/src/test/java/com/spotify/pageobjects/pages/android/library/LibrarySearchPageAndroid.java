package com.spotify.pageobjects.pages.android.library;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.library.LibrarySearchPage;
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
public class LibrarySearchPageAndroid extends AppiumPageAndroid implements LibrarySearchPage {

    public LibrarySearchPageAndroid searchLibraryFor(String searchQuery) {
        getLibrarySearchField().sendKeys(searchQuery);
        return this;
    }

    public LibrarySearchPageAndroid verifySearchResultIsAvailable(String expectedSearchResult, String searchResultType) {
        androidElementChecks.assertElementIsVisible(getSearchResult(expectedSearchResult, searchResultType));
        return this;
    }

    private WebElement getLibrarySearchField() {
        return androidElementActions.getElementById("com.spotify.music:id/edit_text");
    }

    private WebElement getSearchFieldClearButton() {
        return androidElementActions.getElementById("com.spotify.music:id/icon_clear_search");
    }

    private WebElement getEmptyViewTitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_title' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().emptyViewTitleText() + "']");
    }

    private WebElement getEmptyViewSubtitle() {
        return androidElementActions.getElementByXpath("//android.widget.TextView[@resource-id='com.spotify.music:id/search_empty_view_subtitle' and @text='" + ConfigProviderMobile.getMobileAppLocaleConfig().emptyViewSubtitleText() + "']");
    }

    private WebElement getSearchResult(String title, String subtitle) {
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 15);

        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(
                        "new UiSelector().description(\"%s\")",
                        contentDesc));
    }
}
