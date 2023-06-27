package com.spotify.android.tests;

import com.spotify.android.pageobjects.commons.ContextMenu;
import com.spotify.android.pageobjects.commons.MediaInteraction;
import com.spotify.android.pageobjects.commons.Navigation;
import com.spotify.android.pageobjects.commons.SpotifyCode;
import com.spotify.android.pageobjects.pages.ArtistDiscographyPage;
import com.spotify.android.pageobjects.pages.ArtistProfilePage;
import com.spotify.android.pageobjects.pages.LibraryPage;
import com.spotify.android.tests.base.MobileAndroidTestBase;
import org.junit.jupiter.api.Test;

public class ArtistTests extends MobileAndroidTestBase {

    private final Navigation navigationBar = new Navigation(driver);
    private final LibraryPage libraryPage = new LibraryPage(driver, wait);
    private final ArtistProfilePage artistProfilePage = new ArtistProfilePage(driver, wait);
    private final MediaInteraction mediaInteraction = new MediaInteraction(driver, wait);
    private final ArtistDiscographyPage aristDiscographyPage = new ArtistDiscographyPage(driver, wait);
    private final ContextMenu contextMenu = new ContextMenu(driver, wait);
    private final SpotifyCode spotifyCode = new SpotifyCode(driver, wait);

    @Test
    public void artistProfileCanBeOpenedFromLibrary() {
        navigationBar
                .tapLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .tapArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Oliver Tree");
        artistProfilePage
                .verifyProfileTitleHasText("Oliver Tree")
                .verifyMonthlyListenersCountIsAvailable()
                .verifyFollowButtonIsAvailable();
        mediaInteraction
                .verifyContextMenuButtonIsAvailable()
                .verifyShuffleButtonIsAvailable()
                .verifyPlayButtonIsAvailable();
        artistProfilePage
                .verifyTrackCloudContainsArtist("Oliver Tree")
                .verifyPopularReleasesSectionIsAvailable()
                .verifyArtistPlaylistsSectionIsAvailable()
                .verifyFansAlsoLikeSectionIsAvailable();
    }

    @Test
    public void artistDiscographyCanBeOpenedFromProfile() {
        navigationBar
                .tapLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .tapArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Oliver Tree");
        artistProfilePage
                .tapSeeDiscographyButton();
        aristDiscographyPage
                .verifyDiscographyTitleIsAvailable()
                .verifyLatestReleaseTitleIsAvailable()
                .verifyAlbumsTitleIsAvailable()
                .verifyDiscographyItemIsAvailable("Cowboy Tears", 2022)
                .verifySinglesTitleIsAvailable()
                .verifyDiscographyItemIsAvailable("Miss You (Remix)", 2022);
    }

    @Test
    public void artistSpotifyCodeCanBeOpenedFromProfile() {
        navigationBar
                .tapLibraryButton();
        libraryPage
                .verifyLibraryPageIsOpened()
                .selectArtistItem("Oliver Tree");
        mediaInteraction
                .tapContextMenuButton();
        contextMenu
                .verifyContextMenuTitleIsAvailable("Oliver Tree")
                .tapShowSpotifyCodeButton();
        spotifyCode
                .verifySpotifyCodeIsAvailable();
    }
}
