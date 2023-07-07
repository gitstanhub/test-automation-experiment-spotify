package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.pages.SearchPage;
import com.spotify.android.pageobjects.pages.SearchResultsPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class GlobalSearchTests extends MobileAndroidTestBase {

    private final Navigation navigation = new Navigation(driver);
    private final SearchPage searchPage = new SearchPage(driver, wait);
    private final SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wait);

    @Test
    public void artistCanBeFound() {
        navigation
                .tapSearchButton();
        searchPage
                .verifySearchPageIsOpened()
                .tapGlobalSearchField();
        searchResultsPage
                .searchGloballyFor("Eminem")
                .tapArtistsFilterButton()
                .verifySearchResultIsAvailable("Eminem");
    }

    @Test
    public void albumCanBeFound() {
        navigation
                .tapSearchButton();
        searchPage
                .verifySearchPageIsOpened()
                .tapGlobalSearchField();
        searchResultsPage
                .searchGloballyFor("The Eminem Show")
                .tapAlbumFilterButton()
                .verifySearchResultIsAvailable("The Eminem Show");
    }
}
