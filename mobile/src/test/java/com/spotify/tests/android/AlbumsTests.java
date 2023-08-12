package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.artist.constants.ArtistAlbums.ARTIST_1_ALBUM_1;
import static com.spotify.testdata.artist.constants.ArtistEntities.ARTIST_1;

public class AlbumsTests extends MobileTests {

    //ToDo: move to LibraryTests
    @Test
    @AuthRequiredMobile
    public void albumCanBeOpenedFromLibrary() {

        String artistName = ARTIST_1.getArtistName();

        String albumName = ARTIST_1_ALBUM_1.getAlbumName();
        String albumType = ARTIST_1_ALBUM_1.getAlbumType();
        Integer albumReleaseYear = ARTIST_1_ALBUM_1.getAlbumReleaseYear();
        String albumFullReleaseDate = ARTIST_1_ALBUM_1.getAlbumFullReleaseDate();
        String albumCopyrightText = ARTIST_1_ALBUM_1.getAlbumCopyrightText();

        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapAlbumsButton()
                .selectAlbumItem(albumName, artistName);

        getAlbumPage()
                .verifyAlbumTitleHasText(albumName)
                .verifyArtistNamesRowContainsArtist(artistName)
                .verifyAlbumInfoHasText(albumType, albumReleaseYear)
                .verifyFavouritesButtonIsAvailable();

        getMediaInteraction()
                .verifyContextMenuButtonIsAvailable()
                .verifyShuffleButtonIsAvailable()
                .verifyPlayButtonIsAvailable();

        getAlbumPage()
                .verifyTrackCloudIsAvailable()
                .verifyAlbumReleaseDateIs(albumFullReleaseDate)
                .verifyAlbumArtistListContainsItem(artistName)
                .verifyYouMightAlsoLikeIsAvailable()
                .verifyCopyRightRowMatches(albumCopyrightText);
    }
}
