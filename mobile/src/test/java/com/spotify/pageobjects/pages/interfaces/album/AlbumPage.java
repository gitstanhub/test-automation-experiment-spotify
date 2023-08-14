package com.spotify.pageobjects.pages.interfaces.album;

public interface AlbumPage {

    AlbumPage verifyAlbumTitleHasText(String albumTitle);

    AlbumPage verifyArtistNamesRowContainsArtist(String artistName);

    AlbumPage verifyAlbumInfoHasText(String albumType, Integer albumReleaseYear);

    AlbumPage verifyFavouritesButtonIsAvailable();

    AlbumPage verifyDownloadButtonIsAvailable();

    AlbumPage verifyTrackCloudIsAvailable();

    AlbumPage verifyAlbumReleaseDateIs(String releaseDate);

    AlbumPage verifyAlbumArtistListContainsItem(String artistName);

    AlbumPage verifyYouMightAlsoLikeIsAvailable();

    AlbumPage verifyCopyRightRowMatches(String copyrightText);
}
