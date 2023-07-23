package com.spotify.pageobjects.pages.interfaces.playlist;

public interface PlaylistCreationPage {

    public PlaylistCreationPage verifyPlaylistCreationPageIsOpened();

    public PlaylistCreationPage enterPlaylistName(String playlistName);

    public PlaylistCreationPage tapCreateButton();

    public PlaylistCreationPage tapCancelButton();
}
