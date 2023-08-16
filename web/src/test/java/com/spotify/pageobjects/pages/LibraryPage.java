package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.github.seregamorph.hamcrest.OrderMatchers.softOrdered;
import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.pages.LibraryPageLocators.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
@Lazy
@Slf4j
public class LibraryPage extends PlaywrightPage {


    @Step
    public LibraryPage verifyLibraryButtonIsAvailable() {
        getPage().waitForSelector(String.format(LIBRARY_BUTTON, ConfigProviderWeb.getWebAppLocaleConfig().libraryButtonText()));
        Assertions.assertTrue(elementChecks.isElementVisible(findLibraryPageTitle()));
        return this;
    }


    @Step
    public LibraryPage clickExpandLibraryButton() {
        findExpandLibraryButton().click();
        return this;
    }


    @Step
    public LibraryPage clickPlaylistsFilterButton() {
        findPlaylistsFilterButton().click();
        return this;
    }


    @Step
    public LibraryPage clickSearchLibraryButton() {
        findSearchLibraryButton().click();
        return this;
    }


    @Step
    public LibraryPage fillInSearchLibraryField(String searchQuery) {
        findSearchLibraryField().fill(searchQuery);
        return this;
    }


    @Step
    public LibraryPage clickLibraryItemWithText(String itemText) {
        findLibraryItemByText(itemText).click();
        return this;
    }


    @Step
    public LibraryPage rightClickLibraryItemWithText(String itemText) {
        findLibraryItemByText(itemText).click(new Locator.ClickOptions()
                .setButton(MouseButton.RIGHT));
        return this;
    }


    @Step
    public LibraryPage verifyPlaylistsFilterButtonIsPressed() {
        getPage().waitForSelector(String.format(CLEAR_FILTERS_BUTTON, ConfigProviderWeb.getWebAppLocaleConfig().clearFiltersButtonText()));
        Assertions.assertTrue(isLibraryFilterButtonPressed(findPlaylistsFilterButton()));
        return this;
    }


    @Step
    public LibraryPage selectSortByRecentlyAddedOption() {
        selectSortByOption(ConfigProviderWeb.getWebAppLocaleConfig().sortByRecentOption());
        return this;
    }


    @Step
    public LibraryPage selectSortByAlphabeticalOption() {
        selectSortByOption(ConfigProviderWeb.getWebAppLocaleConfig().sortByAlphabeticalOption());
        return this;
    }


    @Step
    public LibraryPage verifyLibraryListIsSortedAsc() {
        final int MAX_ELEMENTS = 30;

        List<String> libraryItemsList = new ArrayList<>();

        Function<String, String> removeThePrefix = (String s) -> s != null && s.toLowerCase().startsWith("the ") ? s.substring(4) : s;

        int libraryItemsTotal = Integer.parseInt(elementActions.getElementAttributeBySelector(
                LIBRARY_ITEMS_TOTAL,
                LIBRARY_ITEMS_TOTAL_ATTRIBUTE));

        for (int i = 0; i < MAX_ELEMENTS && i < libraryItemsTotal; i++) {

            Locator libraryItem = elementActions.findElementBySelector(String.format(LIBRARY_ITEM_SELECTOR, (1 + i)));
            libraryItem.scrollIntoViewIfNeeded();
            String libraryItemText = libraryItem.innerText();
            libraryItemsList.add(removeThePrefix.apply(libraryItemText));
        }

        log.info("Here's the collected list: " + "with size: " + libraryItemsList.size() + ", so: " + libraryItemsList);
        assertThat(libraryItemsList, softOrdered(String.CASE_INSENSITIVE_ORDER));

        return this;
    }


    @Step
    public LibraryPage verifyCreatedPlaylistIsAvailable(String expectedPlaylistName) {
        Assertions.assertTrue(elementChecks.isElementVisible(findLibraryItemByText(expectedPlaylistName).locator(CREATED_PLAYLIST_ITEM)));
        return this;
    }

    private LibraryPage selectSortByOption(String sortByOption) {
        findSortByButton().click();

        elementActions
                .findElementBySelector(SORT_BY_OPTION)
                .filter(new Locator.FilterOptions().setHasText(sortByOption)).click();

        getPage().waitForCondition(() -> elementChecks.isElementVisibleWithText(sortByOption));

        return this;
    }

    private Locator findLibraryPageTitle() {
        return elementActions.findElementByExactText(ConfigProviderWeb.getWebAppLocaleConfig().libraryPageTitle());
    }

    private Locator findExpandLibraryButton() {
        return elementActions.findElementBySelector(String.format(EXPAND_LIBRARY_BUTTON, ConfigProviderWeb.getWebAppLocaleConfig().expandLibraryButtonText()));
    }

    private Locator findSortByButton() {
        return elementActions.findElementBySelector(String.format(SORT_BY_BUTTON, ConfigProviderWeb.getWebAppLocaleConfig().sortByButtonText()));
    }

    private Locator findPlaylistsFilterButton() {
        return elementActions.findElementBySelectorAndText(PLAYLISTS_FILTER_BUTTON, ConfigProviderWeb.getWebAppLocaleConfig().libraryPlaylistsFilterButtonText());
    }

    private Locator findLibraryItemByText(String libraryItemText) {
        return elementActions.findElementBySelectorAndText(LIBRARY_ITEM, libraryItemText);
    }

    private Boolean isLibraryFilterButtonPressed(Locator locator) {
        return locator.getAttribute(LIBRARY_FILTER_BUTTON_PRESSED).equals("true");
    }

    private Locator findSearchLibraryButton() {
        return elementActions.findElementByTestId(SEARCH_LIBRARY_BUTTON);
    }

    private Locator findSearchLibraryField() {
        return elementActions.findElementBySelector(String.format(SEARCH_LIBRARY_FIELD, ConfigProviderWeb.getWebAppLocaleConfig().searchLibraryFieldText()));
    }
}
