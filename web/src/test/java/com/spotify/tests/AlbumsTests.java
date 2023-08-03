package com.spotify.tests;

import com.spotify.annotations.AuthRequiredWeb;
import com.spotify.pageobjects.commons.ContextMenu;
import com.spotify.pageobjects.pages.AlbumPage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.tests.base.WebTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

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
        albumPage.openAlbumPage("2cWBwpqMsDJC1ZUwz813lo");

        contextMenu
                .clickContextMenuButton()
                .selectShareOption()
                .clickEmbedAlbumOption();

        albumPage
                .verifyEmbedAlbumModalIsAvailable()
                .clickShowCodeCheckbox()
                .verifyIframeCodeFieldContainsAlbum("2cWBwpqMsDJC1ZUwz813lo")
                .clickEmbedCodeCopyButton()
                .verifyEmbedCodeCopyButtonIsClicked();
    }

    @Test
    @AuthRequiredWeb
    public void albumVersionCanBeSwitched() {
        albumPage
                .openAlbumPage("2cWBwpqMsDJC1ZUwz813lo")
                .verifyAlbumPageIsAvailable()
                .verifyExplicitTracksAreAvailable()
                .clickAlbumTypeSwitcher()
                .selectAlbumTypeSwitcherOption("The Eminem Show")
                .verifyExplicitTracksAreNotAvailable();
    }

    @Test
    @AuthRequiredWeb
    public void albumCanBeAddedToPlaylist() {
        albumPage
                .openAlbumPage("2cWBwpqMsDJC1ZUwz813lo")
                .verifyAlbumPageIsAvailable();

        contextMenu
                .clickContextMenuButton()
                .selectAddToPlaylistOption()
                .clickCreatePlaylistButton();

        libraryPage
                .clickPlaylistsFilterButton()
                .verifyPlaylistsFilterButtonIsPressed()
                .selectSortByRecentlyAddedOption()
                .verifyCreatedPlaylistIsAvailable("The Eminem Show");
    }
}
