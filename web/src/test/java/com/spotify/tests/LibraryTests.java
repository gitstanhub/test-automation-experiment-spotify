package com.spotify.tests;

import com.spotify.pageobjects.commons.OptionsMenu;
import com.spotify.pageobjects.pages.HomePage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.pageobjects.pages.PlaylistPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class LibraryTests extends WebPlaywrightTestBase {

    private final HomePage homePage = new HomePage(page);
    private final LibraryPage libraryPage = new LibraryPage(page);
    private final OptionsMenu optionsMenu = new OptionsMenu(page);
    private final PlaylistPage playlistPage = new PlaylistPage(page);

    @Test
    public void libraryCanBeSortedAlphabetically() {
        homePage.openHomePage();

        libraryPage
                .verifyLibraryButtonIsAvailable()
                .clickExpandLibraryButton()
                .selectSortByOption("Alphabetical")
                .verifyLibraryListIsSortedAsc();
    }

    @Test
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
