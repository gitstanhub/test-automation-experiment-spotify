package com.spotify.pageobjects.commons;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import org.junit.jupiter.api.Assertions;

public class OptionsMenu {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public OptionsMenu(Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public OptionsMenu verifyOptionsMenuIsAvailable() {
        page.waitForSelector("div[id='context-menu']");
        Assertions.assertTrue(elementChecks.isElementVisible(findContextMenu()));
        return this;
    }

    public OptionsMenu clickEditDetailsOption() {
        findEditDetailsOption().click();
        return this;
    }

    private Locator findContextMenu() {
        return elementActions.findElementBySelector("div[id='context-menu']");
    }

    private Locator findEditDetailsOption() {
        return elementActions.findElementBySelectorAndText("div[id='context-menu'] button[role='menuitem']", "Edit details");
    }

}
