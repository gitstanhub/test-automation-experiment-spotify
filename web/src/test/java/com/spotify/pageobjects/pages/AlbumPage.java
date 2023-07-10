package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;

public class AlbumPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public AlbumPage (Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public AlbumPage openAlbumPage(String albumId) {
        browserActions.navigateToUrl("https://open.spotify.com/album/" + albumId);
        return this;
    }
}
