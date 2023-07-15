package com.spotify.tests;

import com.spotify.pageobjects.commons.ContextMenu;
import com.spotify.pageobjects.pages.AlbumPage;
import com.spotify.pageobjects.pages.LibraryPage;
import com.spotify.tests.base.WebTestsBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class AlbumsTests extends WebTestsBase {

    @Autowired
    @Lazy
    AlbumPage albumPage;
    @Autowired
    @Lazy
    ContextMenu contextMenu;
    @Autowired
    @Lazy
    LibraryPage libraryPage;

//    private final AlbumPage albumPage = new AlbumPage(page);
//    private final ContextMenu contextMenu = new ContextMenu(page);
//    private final LibraryPage libraryPage = new LibraryPage(page);

    @Test
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
                .selectSortByOption("Recently Added")
                .verifyCreatedPlaylistIsAvailable("The Eminem Show");
    }
}
