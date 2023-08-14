package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.albums.constants.Albums.ARTIST_2_ALBUM_1;
import static com.spotify.testdata.albums.constants.Albums.ARTIST_2_ALBUM_2;
import static com.spotify.testdata.artists.constants.Artists.ARTIST_2;

public class ArtistsTests extends MobileTests {

    @Test
    @AuthRequiredMobile
    public void artistDiscographyCanBeOpenedFromProfile() {

        String artistName = ARTIST_2.getArtistName();

        String firstAlbumName = ARTIST_2_ALBUM_1.getAlbumName();
        Integer firstAlbumReleaseYear = ARTIST_2_ALBUM_1.getAlbumReleaseYear();

        String secondAlbumName = ARTIST_2_ALBUM_2.getAlbumName();
        Integer secondAlbumReleaseYear = ARTIST_2_ALBUM_2.getAlbumReleaseYear();

        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapArtistsButton()
                .verifyArtistButtonIsSelected()
                .selectArtistItem(artistName);

        getArtistProfilePage()
                .tapSeeDiscographyButton();

        getArtistDiscographyPage()
                .verifyDiscographyTitleIsAvailable()
                .verifyLatestReleaseTitleIsAvailable()
                .verifyAlbumsTitleIsAvailable()
                .verifyDiscographyItemIsAvailable(firstAlbumName, firstAlbumReleaseYear)
                .verifySinglesTitleIsAvailable()
                .verifyDiscographyItemIsAvailable(secondAlbumName, secondAlbumReleaseYear);
    }

    @Test
    @AuthRequiredMobile
    public void artistSpotifyCodeCanBeOpenedFromProfile() {

        String artistName = ARTIST_2.getArtistName();

        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .selectArtistItem(artistName);

        getMediaInteraction()
                .tapContextMenuButton();

        getContextMenu()
                .verifyContextMenuTitleIsAvailable(artistName)
                .tapShowSpotifyCodeButton();

        getSpotifyCode()
                .verifySpotifyCodeIsAvailable();
    }
}
