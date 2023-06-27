package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.MediaInteraction;
import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.pages.AlbumPage;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class AlbumTests extends MobileAndroidTestBase {

    private final Navigation navigationBar = new Navigation(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
    private final MediaInteraction mediaInteraction = new MediaInteraction(driver, wait);
    private final AlbumPage albumPage = new AlbumPage(driver, wait);

    @Test
    public void artistAlbumCanBeOpenedFromLibrary() {

        navigationBar
                .tapLibraryButton();
        libraryPage
                .tapAlbumsButton()
                .selectAlbumItem("The Eminem Show", "Eminem");
        albumPage
                .verifyAlbumTitleHasText("The Eminem Show")
                .verifyArtistNamesRowContainsArtist("Eminem")
                .verifyAlbumInfoHasText("Album • 2002")
                .verifyFavouritesButtonIsAvailable()
                .verifyDownloadButtonIsAvailable();
        mediaInteraction
                .verifyContextMenuButtonIsAvailable()
                .verifyShuffleButtonIsAvailable()
                .verifyPlayButtonIsAvailable();
        albumPage
                .verifyTrackCloudIsAvailable()
                .verifyAlbumReleaseDateIs("May 26, 2002")
                .verifyAlbumArtistListContainsItem("Eminem")
                .verifyYouMightAlsoLikeIsAvailable()
                .verifyCopyRightRowMatches("© ℗ 2002 Aftermath Records");
    }
}
