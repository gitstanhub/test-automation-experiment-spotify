package com.spotify.pageobjects.pages.interfaces.artist;

public interface ArtistProfilePage {

    public ArtistProfilePage verifyProfileTitleHasText(String artistName);

    public ArtistProfilePage verifyFollowButtonIsAvailable();

    public ArtistProfilePage verifyMonthlyListenersCountIsAvailable();

    public ArtistProfilePage verifyTrackCloudContainsArtist(String artistName);

    public ArtistProfilePage verifyPopularReleasesSectionIsAvailable();

    public ArtistProfilePage verifyArtistPlaylistsSectionIsAvailable();

    public ArtistProfilePage verifyFansAlsoLikeSectionIsAvailable();

    public ArtistProfilePage tapSeeDiscographyButton();
}
