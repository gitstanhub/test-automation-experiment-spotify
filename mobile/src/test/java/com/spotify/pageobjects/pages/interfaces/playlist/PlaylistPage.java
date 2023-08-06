package com.spotify.pageobjects.pages.interfaces.playlist;

public interface PlaylistPage {

    public PlaylistPage verifyPlaylistArtworkIsAvailable();

    public PlaylistPage verifyPlaylistNameIsAvailable();

    public PlaylistPage verifyPlaylistNameIsExact(String expectedPlaylistTitle);

    public PlaylistPage verifyDeletePopupTitleIsAvailable();

    public PlaylistPage verifyDeletePopupSubtitleIsAvailable(String playlistName);

    public PlaylistPage tapPlaylistDeleteConfirmButton();
}
