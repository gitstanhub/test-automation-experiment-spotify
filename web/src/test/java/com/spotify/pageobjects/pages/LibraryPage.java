package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import org.junit.jupiter.api.Assertions;

public class LibraryPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public LibraryPage(Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public LibraryPage verifyLibraryButtonIsAvailable() {
        Assertions.assertTrue(elementChecks.isElementVisible(findLibraryPageTitle()));
        return this;
    }

    public LibraryPage clickExpandLibraryButton() {
        findExpandLibraryButton().click();
        return this;
    }

    public LibraryPage selectSortByOption(String sortByOption) {
        findSortByButton().click();

        elementActions
                .findElementBySelector("div[id = context-menu] li button span ")
                .filter(new Locator.FilterOptions().setHasText(sortByOption)).click();

        return this;
    }

    private Locator findLibraryPageTitle() {
        return elementActions.findElementByText("Your Library");
    }

    private Locator findExpandLibraryButton() {
        return elementActions.findElementBySelector("button[aria-label='Enlarge Your Library']");
    }

    private Locator findSortByButton() {
        return elementActions.findElementBySelector("button[aria-label='Sort by']");
    }
}
