package com.spotify.tests;

import com.spotify.annotations.AuthRequiredWeb;
import com.spotify.pageobjects.pages.SearchPage;
import com.spotify.tests.base.WebTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class GlobalSearchTests extends WebTests {

    @Autowired
    @Lazy
    SearchPage searchPage;

    @Test
    @AuthRequiredWeb
    public void songCanBeFoundInTopResults() {
        searchPage
                .openSearchPage()
                .fillInSearchField("Life Goes On by Oliver Tree")
                .verifyAllFilterButtonIsAvailable()
                .clickSongsFilterButton()
                .verifySearchedSongIsReturnedInTop10Results("Life Goes On", "Oliver Tree");
    }

    @Test
    @AuthRequiredWeb
    public void playlistCanBeFoundInTopResults() {
        searchPage
                .openSearchPage()
                .fillInSearchField("This Is Oliver Tree")
                .verifyAllFilterButtonIsAvailable()
                .clickPlaylistsFilterButton()
                .verifySearchedPlaylistIsReturnedInTop10Results("This Is Oliver Tree");
    }
}
