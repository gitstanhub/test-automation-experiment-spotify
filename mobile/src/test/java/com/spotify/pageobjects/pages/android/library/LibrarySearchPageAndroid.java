package com.spotify.pageobjects.pages.android.library;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.library.LibrarySearchPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.LibrarySearchPageLocators.*;

@Component
@Lazy
@Slf4j
public class LibrarySearchPageAndroid extends AppiumPageAndroid implements LibrarySearchPage {

    @Step
    public LibrarySearchPageAndroid searchLibraryFor(String searchQuery) {
        getLibrarySearchField().sendKeys(searchQuery);
        return this;
    }

    @Step
    public LibrarySearchPageAndroid verifySearchResultIsAvailable(String expectedSearchResult, String searchResultType) {
        androidElementChecks.assertElementIsVisible(getSearchResult(expectedSearchResult, searchResultType));
        return this;
    }

    private WebElement getLibrarySearchField() {
        return androidElementActions.getElementById(LIBRARY_SEARCH_FIELD);
    }

    private WebElement getSearchFieldClearButton() {
        return androidElementActions.getElementById(SEARCH_FIELD_CLEAR_BUTTON);
    }

    private WebElement getEmptyViewTitle() {
        return androidElementActions.getElementByXpath(String.format(EMPTY_VIEW_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().emptyViewTitleText()));
    }

    private WebElement getEmptyViewSubtitle() {
        return androidElementActions.getElementByXpath(String.format(EMPTY_VIEW_SUBTITLE, ConfigProviderMobile.getMobileAppLocaleConfig().emptyViewSubtitleText()));
    }

    private WebElement getSearchResult(String title, String subtitle) {
        String contentDesc = String.format("%s, %s, ", title, subtitle);

        androidPageNavigationActions.swipeToElementByDescription(contentDesc, 15);

        return androidElementActions.getElementByAndroidUiAutomator(
                String.format(
                        SEARCH_RESULT_UIAUTOMATOR,
                        contentDesc));
    }
}
