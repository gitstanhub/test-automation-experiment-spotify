package com.spotify.tests;

import com.spotify.pageobjects.pages.SearchPage;
import com.spotify.tests.base.WebTestsBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class GlobalSearchTests extends WebTestsBase {

    @Autowired
    @Lazy
    SearchPage searchPage;

//    private final SearchPage searchPage = new SearchPage(page);

    @Test
    public void songCanBeFoundInTopResults() {
        searchPage
                .openSearchPage()
                .fillInSearchField("Life Goes On by Oliver Tree")
                .verifyAllFilterButtonIsAvailable()
                .clickSongsFilterButton()
                .verifySearchedSongIsReturnedInTop10Results("Life Goes On", "Oliver Tree");
    }

    @Test
    public void playlistCanBeFoundInTopResults() {
        searchPage
                .openSearchPage()
                .fillInSearchField("This Is Oliver Tree")
                .verifyAllFilterButtonIsAvailable()
                .clickPlaylistsFilterButton()
                .verifySearchedPlaylistIsReturnedInTop10Results("This Is Oliver Tree");
    }
}
