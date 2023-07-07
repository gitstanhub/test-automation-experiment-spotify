package com.spotify.tests;

import com.spotify.pageobjects.pages.HomePage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class LibraryTests extends WebPlaywrightTestBase {

    private final HomePage homePage = new HomePage(page);
    private final LibraryPage libraryPage = new LibraryPage(page);

    //@Test
    //public void playlistFolderCanBeCreated

    @Test
    public void libraryCanBeSortedAlphabetically() {
        homePage.openHomePage();
        libraryPage
                .verifyLibraryButtonIsAvailable()
                .clickExpandLibraryButton()
                .selectSortByOption("Alphabetical");
    }

    //@Test
    //public void artistCanBeAddedToLibrary
}
