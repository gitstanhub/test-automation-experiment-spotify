package com.spotify.pageobjects.pages.android.search;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.search.SearchPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.SearchPageLocators.*;

@Component
@Lazy
@Slf4j
public class SearchPageAndroid extends AppiumPageAndroid implements SearchPage {

    @Step
    public SearchPageAndroid verifySearchPageIsOpened() {
        androidElementChecks.assertElementIsVisible(getSearchPageTitle());
        return this;
    }

    @Step
    public SearchPageAndroid tapGlobalSearchField() {
        getSearchField().click();
        return this;
    }

    private WebElement getSearchPageTitle() {

        String titleFirst = ConfigProviderMobile.getMobileAppLocaleConfig().searchPageTitleTextFirst();
        String titleSecond = ConfigProviderMobile.getMobileAppLocaleConfig().searchPageTitleTextSecond();

        try {
            return androidElementActions.getElementByAndroidUiAutomator(
                    String.format(
                            SEARCH_PAGE_TITLE_UIAUTOMATOR,
                            SEARCH_PAGE_TITLE_ID_FIRST, titleFirst));
        } catch (NoSuchElementException e) {
            return androidElementActions.getElementByAndroidUiAutomator(
                    String.format(
                            SEARCH_PAGE_TITLE_UIAUTOMATOR,
                            SEARCH_PAGE_TITLE_ID_SECOND, titleSecond));
        }
    }

    private WebElement getScanSpotifyCodeButton() {
        return androidElementActions.getElementByAndroidUiAutomator(String.format(SCAN_SPOTIFY_CODE_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().scanSpotifyCodeButtonText()));
    }

    private WebElement getSearchField() {
        return androidElementActions.getElementById(SEARCH_FIELD);
    }
}
