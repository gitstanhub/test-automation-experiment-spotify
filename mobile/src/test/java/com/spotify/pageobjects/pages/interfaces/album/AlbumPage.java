package com.spotify.pageobjects.pages.interfaces.album;

public interface AlbumPage {

    public AlbumPage verifyAlbumTitleHasText(String albumTitle);

    public AlbumPage verifyArtistNamesRowContainsArtist(String artistName);

    public AlbumPage verifyAlbumInfoHasText(String albumInfo);

    public AlbumPage verifyFavouritesButtonIsAvailable();

    public AlbumPage verifyDownloadButtonIsAvailable();

    public AlbumPage verifyTrackCloudIsAvailable();

    public AlbumPage verifyAlbumReleaseDateIs(String releaseDate);

    public AlbumPage verifyAlbumArtistListContainsItem(String artistName);

    public AlbumPage verifyYouMightAlsoLikeIsAvailable();

    public AlbumPage verifyCopyRightRowMatches(String copyrightText);
}
