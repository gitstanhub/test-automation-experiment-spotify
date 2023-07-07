package com.spotify.tests;

import com.spotify.pageobjects.pages.SearchPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class GlobalSearchTests extends WebPlaywrightTestBase {

    private final SearchPage searchPage = new SearchPage(page);

    @Test
    public void songCanBeFound() {
        searchPage
                .openSearchPage()
                .fillInSearchField("Life Goes On by Oliver Tree")
                .verifyAllFilterButtonIsAvailable()
                .clickSongsFilterButton()
                .verifySearchedSongIsReturnedInTop10Results("Life Goes On", "Oliver Tree");
    }

    //@Test
    //public void playlistCanBeFound()

}
