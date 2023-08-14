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

import static com.spotify.testdata.playlists.constants.Playlists.PLAYLIST_1;

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
                .selectSortByAlphabeticalOption()
                .verifyLibraryListIsSortedAsc();
    }

    @Test
    @AuthRequiredWeb
    public void playlistDetailsCanBeUpdatedFromLibrary() {

        String playlistName = PLAYLIST_1.getPlaylistName();
        String playlistDescription = PLAYLIST_1.getPlaylistDescription();

        homePage.openHomePage();

        libraryPage
                .verifyLibraryButtonIsAvailable()
                .clickExpandLibraryButton()
                .clickPlaylistsFilterButton()
                .verifyPlaylistsFilterButtonIsPressed()
                .clickSearchLibraryButton()
                .fillInSearchLibraryField(playlistName)
                .rightClickLibraryItemWithText(playlistName);

        optionsMenu
                .verifyOptionsMenuIsAvailable()
                .clickEditDetailsOption();

        playlistPage
                .verifyEditDetailsModalIsAvailable()
                .clearEditDetailsModalDescriptionField()
                .fillInEditDetailsModalDescriptionField(playlistDescription)
                .clickEditDetailsModalSaveButton();

        libraryPage
                .clickLibraryItemWithText(playlistName);

        playlistPage
                .verifyPlaylistSectionIsAvailable()
                .verifyPlaylistTitleIsAvailableWithText(playlistName)
                .verifyPlaylistDescriptionIsAvailableWithText(playlistDescription);
    }
}
