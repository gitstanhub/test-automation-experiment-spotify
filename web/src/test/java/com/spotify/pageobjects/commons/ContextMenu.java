package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
public class ContextMenu extends PlaywrightPage {

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

    public ContextMenu selectAddToPlaylistOption() {
        findAddToPlaylistOption().hover();
        return this;
    }

    public ContextMenu clickCreatePlaylistButton() {
        findCreatePlaylistOption().click();
        return this;
    }

    private Locator findContextMenuButton() {
        return elementActions.findElementBySelector("button[data-testid='add-button'] + button[data-testid='more-button']");
    }

    private Locator findShareOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", ConfigProviderWeb.getWebAppLocaleConfig().shareOptionText());
    }

    private Locator findEmbedAlbumOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", ConfigProviderWeb.getWebAppLocaleConfig().embedAlbumOptionText());
    }

    private Locator findAddToPlaylistOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", ConfigProviderWeb.getWebAppLocaleConfig().addToPlaylistOptionText());
    }

    private Locator findCreatePlaylistOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", ConfigProviderWeb.getWebAppLocaleConfig().createPlaylistOptionText());
    }
}
