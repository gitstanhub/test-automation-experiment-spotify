package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.pageobjects.pages.PlaylistCreationPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class LibraryTests extends MobileAndroidTestBase {

    private final Navigation navigation = new Navigation(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
    private final PlaylistCreationPage playlistCreationPage = new PlaylistCreationPage(driver, wait);


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
                .tapCreateButton()
                .verifyPlaylistCreationPageIsOpened();
    }


//    @Test
//    public void searchArtistLibraryTest()
}
