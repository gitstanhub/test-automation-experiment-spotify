package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.github.seregamorph.hamcrest.OrderMatchers.softOrdered;
import static org.hamcrest.MatcherAssert.assertThat;

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
        page.waitForSelector("button[aria-label='Collapse Your Library']");
        Assertions.assertTrue(elementChecks.isElementVisible(findLibraryPageTitle()));
        return this;
    }

    public LibraryPage clickExpandLibraryButton() {
        findExpandLibraryButton().click();
        return this;
    }

    public LibraryPage clickPlaylistsFilterButton() {
        findPlaylistsFilterButton().click();
        return this;
    }

    public LibraryPage clickLibraryItemWithText(String itemText) {
        findLibraryItemByText(itemText).click();
        return this;
    }

    public LibraryPage rightClickLibraryItemWithText(String itemText) {
        findLibraryItemByText(itemText).click(new Locator.ClickOptions()
                .setButton(MouseButton.RIGHT));
        return this;
    }

    public LibraryPage verifyPlaylistsFilterButtonIsPressed() {
        page.waitForSelector("button[aria-label='Clear filters']");
        Assertions.assertTrue(isLibraryFilterButtonPressed(findPlaylistsFilterButton()));
        return this;
    }

    public LibraryPage selectSortByOption(String sortByOption) {
        findSortByButton().click();

        elementActions
                .findElementBySelector("div[id = context-menu] li button span ")
                .filter(new Locator.FilterOptions().setHasText(sortByOption)).click();

        page.waitForCondition(() -> elementChecks.isElementVisibleWithText(sortByOption));

        return this;
    }

    public LibraryPage verifyLibraryListIsSortedAsc() {
        final int MAX_ELEMENTS = 30;

        List<String> libraryItemsList = new ArrayList<>();

        Function<String, String> removeThePrefix = (String s) -> s != null && s.toLowerCase().startsWith("the ") ? s.substring(4) : s;

        int libraryItemsTotal = Integer.parseInt(elementActions.getElementAttributeBySelector(
                "div[role=presentation] li[aria-posinset] >> nth=1",
                "aria-setsize"));

        for (int i = 0; i < MAX_ELEMENTS && i < libraryItemsTotal; i++) {
            String libraryItemSelector = "div[role=presentation] li[aria-posinset='" + (1 + i) + "'] div[data-encore-id='listRow'] p[id^='listrow-title-spotify'] span";

            Locator libraryItem = elementActions.findElementBySelector(libraryItemSelector);
            libraryItem.scrollIntoViewIfNeeded();
            String libraryItemText = libraryItem.innerText();
            libraryItemsList.add(removeThePrefix.apply(libraryItemText));
        }

        System.out.println("AHAHAHA here's the collected list: " + "with size: " + libraryItemsList.size() + ", so: " + libraryItemsList);
        assertThat(libraryItemsList, softOrdered(String.CASE_INSENSITIVE_ORDER));

        return this;
    }

    public LibraryPage verifyCreatedPlaylistIsAvailable(String expectedPlaylistName) {
        Assertions.assertTrue(elementChecks.isElementVisible(findLibraryItemByText(expectedPlaylistName).locator("nth=0")));
        return this;
    }

    private Locator findLibraryPageTitle() {
        return elementActions.findElementByExactText("Your Library");
    }

    private Locator findExpandLibraryButton() {
        return elementActions.findElementBySelector("button[aria-label='Enlarge Your Library']");
    }

    private Locator findSortByButton() {
        return elementActions.findElementBySelector("button[aria-label='Sort by']");
    }

    private Locator findPlaylistsFilterButton() {
        return elementActions.findElementBySelectorAndText("button[role='checkbox']", "Playlists");
    }

    private Locator findLibraryItemByText(String libraryItemText) {
        return elementActions.findElementBySelectorAndText("li[role='listitem'][aria-posinset]", libraryItemText);
    }

    private Boolean isLibraryFilterButtonPressed(Locator locator) {
        return locator.getAttribute("aria-checked").equals("true");
    }
}
