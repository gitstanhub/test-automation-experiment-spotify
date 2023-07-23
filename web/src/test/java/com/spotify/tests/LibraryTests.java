package com.spotify.tests;

import com.spotify.annotations.AuthRequiredWeb;
import com.spotify.pageobjects.commons.OptionsMenu;
import com.spotify.pageobjects.pages.HomePage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.pageobjects.pages.PlaylistPage;
import com.spotify.tests.base.WebTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class LibraryTests extends WebTests {

    @Autowired
    HomePage homePage;
    @Autowired
    @Lazy
    LibraryPage libraryPage;
    @Autowired
    @Lazy
    OptionsMenu optionsMenu;
    @Autowired
    @Lazy
    PlaylistPage playlistPage;

    @Test
    @AuthRequiredWeb
    public void libraryCanBeSortedAlphabetically() {
        homePage.openHomePage();

        libraryPage
                .verifyLibraryButtonIsAvailable()
                .clickExpandLibraryButton()
                .selectSortByOption("Alphabetical")
                .verifyLibraryListIsSortedAsc();
    }

    @Test
    @AuthRequiredWeb
    public void playlistDetailsCanBeUpdatedFromLibrary() {
        homePage.openHomePage();

        libraryPage
                .verifyLibraryButtonIsAvailable()
                .clickExpandLibraryButton()
                .clickPlaylistsFilterButton()
                .verifyPlaylistsFilterButtonIsPressed()
                .rightClickLibraryItemWithText("Future Nostalgia");

        optionsMenu
                .verifyOptionsMenuIsAvailable()
                .clickEditDetailsOption();

        playlistPage
                .verifyEditDetailsModalIsAvailable()
                .clearEditDetailsModalDescriptionField()
                .fillInEditDetailsModalDescriptionField("HAHAHA")
                .clickEditDetailsModalSaveButton();

        libraryPage
                .clickLibraryItemWithText("Future Nostalgia");

        playlistPage
                .verifyPlaylistSectionIsAvailable()
                .verifyPlaylistTitleIsAvailableWithText("Future Nostalgia")
                .verifyPlaylistDescriptionIsAvailableWithText("HAHAHA");
    }
}
