package com.spotify.pageobjects.pages.interfaces.library;

public interface LibraryPage {

    public LibraryPage selectArtistItem(String artistName);

    public LibraryPage selectAlbumItem(String albumName, String artistName);

    public LibraryPage selectPlaylistItem(String playlistName, String playlistAuthorName);

    public LibraryPage verifyLibraryPageIsOpened();

    public LibraryPage verifyArtistButtonIsSelected();

    public LibraryPage verifyAlbumsButtonIsSelected();

    public LibraryPage tapArtistsButton();

    public LibraryPage tapAlbumsButton();

    public LibraryPage tapPlaylistsButton();

    public LibraryPage tapSortButton();

    public LibraryPage tapSearchButton();

    public LibraryPage tapCreatePlaylistButton();

    public LibraryPage choosePlaylistOption();
}
