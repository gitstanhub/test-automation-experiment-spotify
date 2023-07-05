package com.spotify.tests;

import com.spotify.pageobjects.pages.SearchPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class GlobalSearchTests extends WebPlaywrightTestBase {

    private final SearchPage searchPage = new SearchPage(page);

    @Test
    public void songCanBeFound() {
        searchPage
                .openSearchPage();
    }

    //@Test
    //public void playlistCanBeFound()

}
