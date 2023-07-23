package com.spotify.pageobjects.pages.interfaces.artist;

public interface ArtistDiscographyPage {

    public ArtistDiscographyPage verifyDiscographyTitleIsAvailable();

    public ArtistDiscographyPage verifyLatestReleaseTitleIsAvailable();

    public ArtistDiscographyPage verifyAlbumsTitleIsAvailable();

    public ArtistDiscographyPage verifySinglesTitleIsAvailable();

    public ArtistDiscographyPage verifyDiscographyItemIsAvailable(String itemTitle, Integer itemReleaseYear);
}
