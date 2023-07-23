package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

public class AlbumsTests extends MobileTests {

   //ToDo: move to LibraryTests
    @Test
    @AuthRequiredMobile
    public void albumCanBeOpenedFromLibrary() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapAlbumsButton()
                .selectAlbumItem("The Eminem Show", "Eminem");

        getAlbumPage()
                .verifyAlbumTitleHasText("The Eminem Show")
                .verifyArtistNamesRowContainsArtist("Eminem")
                .verifyAlbumInfoHasText("Album • 2002")
                .verifyFavouritesButtonIsAvailable();
//                .verifyDownloadButtonIsAvailable();

        getMediaInteraction()
                .verifyContextMenuButtonIsAvailable()
//                .verifyShuffleButtonIsAvailable()
                .verifyPlayButtonIsAvailable();

        getAlbumPage()
//                .verifyTrackCloudIsAvailable()
                .verifyAlbumReleaseDateIs("May 26, 2002")
                .verifyAlbumArtistListContainsItem("Eminem")
                .verifyYouMightAlsoLikeIsAvailable()
                .verifyCopyRightRowMatches("© ℗ 2002 Aftermath Records");
    }
}

//
//    private final Navigation navigationBar = new Navigation(driver);
//    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
//    private final MediaInteraction mediaInteraction = new MediaInteraction(driver, wait);
//    private final AlbumPage albumPage = new AlbumPage(driver, wait);
//
