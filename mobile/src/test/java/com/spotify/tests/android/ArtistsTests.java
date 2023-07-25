package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

public class ArtistsTests extends MobileTests {

    //ToDo: move to LibraryTests
    @Test
    @AuthRequiredMobile
    public void artistProfileCanBeOpenedFromLibrary() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Oliver Tree");

        getArtistProfilePage()
                .verifyProfileTitleHasText("Oliver Tree")
                .verifyMonthlyListenersCountIsAvailable()
                .verifyFollowButtonIsAvailable();

        getMediaInteraction()
                .verifyContextMenuButtonIsAvailable()
                .verifyShuffleButtonIsAvailable()
                .verifyPlayButtonIsAvailable();

        getArtistProfilePage()
                .verifyTrackCloudContainsArtist("Oliver Tree")
                .verifyPopularReleasesSectionIsAvailable()
                .verifyArtistPlaylistsSectionIsAvailable()
                .verifyFansAlsoLikeSectionIsAvailable();
    }

    @Test
    @AuthRequiredMobile
    public void artistDiscographyCanBeOpenedFromProfile() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem("Oliver Tree");

        getArtistProfilePage()
                .tapSeeDiscographyButton();

        getArtistDiscographyPage()
                .verifyDiscographyTitleIsAvailable()
                .verifyLatestReleaseTitleIsAvailable()
                .verifyAlbumsTitleIsAvailable()
                .verifyDiscographyItemIsAvailable("Cowboy Tears", 2022)
                .verifySinglesTitleIsAvailable()
                .verifyDiscographyItemIsAvailable("Miss You (Remix)", 2022);
    }

    @Test
    @AuthRequiredMobile
    public void artistSpotifyCodeCanBeOpenedFromProfile() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .selectArtistItem("Oliver Tree");

        getMediaInteraction()
                .tapContextMenuButton();

        getContextMenu()
                .verifyContextMenuTitleIsAvailable("Oliver Tree")
                .tapShowSpotifyCodeButton();

        getSpotifyCode()
                .verifySpotifyCodeIsAvailable();
    }
}
