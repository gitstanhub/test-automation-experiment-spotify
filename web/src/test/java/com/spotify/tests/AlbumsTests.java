package com.spotify.tests;

import com.spotify.pageobjects.commons.ContextMenu;
import com.spotify.pageobjects.commons.OptionsMenu;
import com.spotify.pageobjects.pages.AlbumPage;
import com.spotify.tests.base.WebPlaywrightTestBase;
import org.junit.jupiter.api.Test;

public class AlbumsTests extends WebPlaywrightTestBase {

    private final AlbumPage albumPage = new AlbumPage(page);
    private final ContextMenu contextMenu = new ContextMenu(page);

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

    //@Test
    //void albumVersionCanBeSwitched

    //@Test
    //void albumCanBeAddedToPlaylist
}
