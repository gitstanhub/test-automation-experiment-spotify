package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;

public class ContextMenu {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public ContextMenu(Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public ContextMenu clickContextMenuButton() {
        findContextMenuButton().click();
        return this;
    }

    public ContextMenu selectShareOption() {
        findShareOption().hover();
        return this;
    }

    public ContextMenu clickEmbedAlbumOption() {
        findEmbedAlbumOption().click();
        return this;
    }

    private Locator findContextMenuButton() {
        return elementActions.findElementBySelector("button[data-testid='add-button'] + button[data-testid='more-button']");
    }

    private Locator findShareOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", "Share");
    }

    private Locator findEmbedAlbumOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", "Embed album");
    }
}
