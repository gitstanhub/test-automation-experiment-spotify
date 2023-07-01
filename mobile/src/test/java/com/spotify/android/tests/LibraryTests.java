package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.pageobjects.pages.LibrarySearchPage;
import com.spotify.android.pageobjects.pages.PlaylistCreationPage;
import com.spotify.android.pageobjects.pages.PlaylistPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class LibraryTests extends MobileAndroidTestBase {

    private final Navigation navigation = new Navigation(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
    private final PlaylistCreationPage playlistCreationPage = new PlaylistCreationPage(driver, wait);
    private final PlaylistPage playlistPage = new PlaylistPage(driver, wait);
    private final LibrarySearchPage librarySearchPage = new LibrarySearchPage(driver, wait);

    @Test
    public void playlistCanBeCreatedFromLibrary() {
        navigation
                .tapLibraryButton();
        libraryPage
                .tapCreatePlaylistButton()
                .choosePlaylistOption();
        playlistCreationPage
                .verifyPlaylistCreationPageIsOpened()
                .enterPlaylistName("Braa")
                .tapCreateButton();
        playlistPage
                .verifyPlaylistArtworkIsAvailable()
                .verifyPlaylistNameIsAvailable()
                .verifyPlaylistNameIsExact("Braa");
    }

    @Test
    public void playlistCanBeDeletedFromLibrary() {

    }

    @Test
    public void artistCanBeSearchedInLibrary() {
        navigation
                .tapLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .tapSearchButton();
        librarySearchPage
                .searchLibraryFor("Oliver Tree")
                .verifySearchResultIsAvailable("Oliver Tree", "Artist");
    }
}
