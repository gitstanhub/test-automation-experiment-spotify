package com.spotify.pageobjects.pages.android.search;

import com.spotify.config.ConfigProviderMobile;
import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.pages.interfaces.search.SearchResultsPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.spotify.locators.pages.SearchResultsPageLocators.*;

@Component
@Lazy
@Slf4j
public class SearchResultsPageAndroid extends AppiumPageAndroid implements SearchResultsPage {

    @Step
    public SearchResultsPageAndroid searchGloballyFor(String searchQuery) {
        getGlobalSearchField().sendKeys(searchQuery);
        return this;
    }

    @Step
    public SearchResultsPageAndroid tapArtistsFilterButton() {
        getArtistFilterButton().click();
        return this;
    }

    @Step
    public SearchResultsPageAndroid tapAlbumFilterButton() {
        getAlbumsFilterButton().click();
        return this;
    }

    @Step
    public SearchResultsPageAndroid verifySearchResultIsAvailable(String expectedSearchResult) {
        androidElementChecks.assertElementIsVisible(getSearchResult(expectedSearchResult));
        return this;
    }

    private WebElement getGlobalSearchField() {
        return androidElementActions.getElementById(GLOBAL_SEARCH_FIELD);
    }

    private WebElement getSearchResultsPlaceholderTitle() {
        return androidElementActions.getElementByXpath(String.format(SEARCH_RESULTS_PLACEHOLDER_TITLE, ConfigProviderMobile.getMobileAppLocaleConfig().searchResultsPlaceholderTitleText()));
    }

    private WebElement getSearchResultsPlaceholderSubtitle() {
        return androidElementActions.getElementByXpath(String.format(SEARCH_RESULTS_PLACEHOLDER_SUBTITLE, ConfigProviderMobile.getMobileAppLocaleConfig().searchResultsPlaceholderSubtitleText()));
    }

    private WebElement getTopFilterButton() {
        return androidElementActions.getElementByXpath(String.format(TOP_FILTER_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().topFilterButtonText()));
    }

    private WebElement getArtistFilterButton() {
        return androidElementActions.getElementByXpath(String.format(ARTIST_FILTER_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().artistFilterButtonText()));
    }

    private WebElement getSongsFilterButton() {
        return androidElementActions.getElementByXpath(String.format(SONGS_FILTER_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().songsFilterButtonText()));
    }

    private WebElement getAlbumsFilterButton() {
        return androidElementActions.getElementByXpath(String.format(ALBUMS_FILTER_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().albumsFilterButtonText()));
    }

    private WebElement getPlaylistsFilterButton() {
        return androidElementActions.getElementByXpath(String.format(PLAYLISTS_FILTER_BUTTON, ConfigProviderMobile.getMobileAppLocaleConfig().playlistsFilterButtonText()));
    }

    private WebElement getSearchResult(String title) {
        androidPageNavigationActions.swipeToElementByText(SEARCH_RESULT_ID, title, 10);

        return androidElementActions.getElementByXpath(String.format(SEARCH_RESULT, title));
    }
}
