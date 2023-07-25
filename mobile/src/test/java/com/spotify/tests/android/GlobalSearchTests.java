package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

public class GlobalSearchTests extends MobileTests {

    @Test
    @AuthRequiredMobile
    public void artistCanBeFound() {
        getNavigation()
                .tapSearchButton();
        getSearchPage()
                .verifySearchPageIsOpened()
                .tapGlobalSearchField();
        getSearchResultsPage()
                .searchGloballyFor("Eminem")
                .tapArtistsFilterButton()
                .verifySearchResultIsAvailable("Eminem");
    }

    @Test
    @AuthRequiredMobile
    public void albumCanBeFound() {
        getNavigation()
                .tapSearchButton();
        getSearchPage()
                .verifySearchPageIsOpened()
                .tapGlobalSearchField();
        getSearchResultsPage()
                .searchGloballyFor("The Eminem Show")
                .tapAlbumFilterButton()
                .verifySearchResultIsAvailable("The Eminem Show");
    }
}
