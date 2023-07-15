package com.spotify.tests;

import com.spotify.pageobjects.commons.CookiesBanner;
import com.spotify.pageobjects.commons.OptionsMenu;
import com.spotify.pageobjects.pages.HomePage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.pageobjects.pages.LoginPage;
import com.spotify.pageobjects.pages.PlaylistPage;
import com.spotify.tests.base.WebTestsBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class LibraryTests extends WebTestsBase {

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
    @Autowired
    @Lazy
    LoginPage loginPage;
    @Autowired
    @Lazy
    CookiesBanner cookiesBanner;

    @Test
    public void libraryCanBeSortedAlphabetically() {
        homePage.openHomePage();

        loginPage.handleLoginFor("spotify_user_login", "spotify_user_password");
        cookiesBanner.handleCookiesBanner();

        libraryPage
                .verifyLibraryButtonIsAvailable()
                .clickExpandLibraryButton()
                .selectSortByOption("Alphabetical")
                .verifyLibraryListIsSortedAsc();
    }

    @Test
    public void playlistDetailsCanBeUpdatedFromLibrary() {
        homePage.openHomePage();

        loginPage.handleLoginFor("spotify_user_login", "spotify_user_password");
        cookiesBanner.handleCookiesBanner();

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
