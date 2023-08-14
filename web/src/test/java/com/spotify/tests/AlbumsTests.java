package com.spotify.tests;

import com.spotify.annotations.AuthRequiredWeb;
import com.spotify.pageobjects.commons.ContextMenu;
import com.spotify.pageobjects.pages.AlbumPage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.tests.base.WebTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import static com.spotify.testdata.albums.constants.Albums.ARTIST_1_ALBUM_1;

public class AlbumsTests extends WebTests {

    @Autowired
    @Lazy
    AlbumPage albumPage;
    @Autowired
    @Lazy
    ContextMenu contextMenu;
    @Autowired
    @Lazy
    LibraryPage libraryPage;

    @Test
    @AuthRequiredWeb
    public void albumEmbeddedLinkCanBeGenerated() {

        String albumId = ARTIST_1_ALBUM_1.getAlbumId();

        albumPage.openAlbumPage(albumId);

        contextMenu
                .clickContextMenuButton()
                .selectShareOption()
                .clickEmbedAlbumOption();

        albumPage
                .verifyEmbedAlbumModalIsAvailable()
                .clickShowCodeCheckbox()
                .verifyIframeCodeFieldContainsAlbum(albumId)
                .clickEmbedCodeCopyButton()
                .verifyEmbedCodeCopyButtonIsClicked();
    }

    @Test
    @AuthRequiredWeb
    public void albumVersionCanBeSwitched() {

        String albumId = ARTIST_1_ALBUM_1.getAlbumId();
        String albumName = ARTIST_1_ALBUM_1.getAlbumName();

        albumPage
                .openAlbumPage(albumId)
                .verifyAlbumPageIsAvailable()
                .verifyExplicitTracksAreAvailable()
                .clickAlbumTypeSwitcher()
                .selectAlbumTypeSwitcherOption(albumName)
                .verifyExplicitTracksAreNotAvailable();
    }

    @Test
    @AuthRequiredWeb
    public void albumCanBeAddedToPlaylist() {

        String albumId = ARTIST_1_ALBUM_1.getAlbumId();
        String albumName = ARTIST_1_ALBUM_1.getAlbumName();

        albumPage
                .openAlbumPage(albumId)
                .verifyAlbumPageIsAvailable();

        contextMenu
                .clickContextMenuButton()
                .selectAddToPlaylistOption()
                .clickCreatePlaylistButton();

        libraryPage
                .clickPlaylistsFilterButton()
                .verifyPlaylistsFilterButtonIsPressed()
                .selectSortByRecentlyAddedOption()
                .verifyCreatedPlaylistIsAvailable(albumName);
    }
}
