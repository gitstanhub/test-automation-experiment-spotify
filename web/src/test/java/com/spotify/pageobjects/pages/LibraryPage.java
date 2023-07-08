package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public LibraryPage selectSortByOption(String sortByOption) {
        findSortByButton().click();

        elementActions
                .findElementBySelector("div[id = context-menu] li button span ")
                .filter(new Locator.FilterOptions().setHasText(sortByOption)).click();

        page.waitForCondition(() -> elementChecks.isElementVisibleWithText(sortByOption));

        return this;
    }


    public LibraryPage verifyLibraryListIsSortedAsc() {
        final int MAX_ELEMENTS = 35;
        String libraryItemSelector = "div[role=presentation] li[aria-posinset] div[data-encore-id='listRow'] p[id^='listrow-title-spotify'] span";
        List<Locator> libraryItemsList = elementActions.findAndScrollIntoAllElementsBySelector(libraryItemSelector, MAX_ELEMENTS);

        Function<String, String> removeThePrefix = (String s) -> s != null && s.toLowerCase().startsWith("the ") ? s.substring(4) : s;

        List<String> libraryItemsCollected = libraryItemsList.stream()
                .filter(Objects::nonNull)
                .map(element -> element.innerText())
                .map(removeThePrefix)
                .collect(Collectors.toList());


        System.out.println("AHAHAHA here's the initial list of elements: " + "with size: " + libraryItemsList.size() + ", so: " + libraryItemsList);
        System.out.println("AHAHAHA here's the collected list of strings: " + "with size: " + libraryItemsCollected.size() + ", so: " + libraryItemsCollected);

        assertThat(libraryItemsCollected, softOrdered(String.CASE_INSENSITIVE_ORDER));

        return this;
    }

//    public LibraryPage verifyLibraryListIsSortedAsc() {
//        final int MAX_ELEMENTS = 25;
//
//        List<String> libraryItemsList = new ArrayList<>();
//
//        Function<String, String> removeThePrefix = (String s) -> s != null && s.toLowerCase().startsWith("the ") ? s.substring(4) : s;
//
//        for (int i = 0; i < MAX_ELEMENTS; i++) {
//            String libraryItemSelector = "div[role=presentation] li[aria-posinset='" + (1 + i) + "'] div[data-encore-id='listRow'] p[id^='listrow-title-spotify'] span";
//            Locator libraryItem = elementActions.findElementBySelector(libraryItemSelector);
//            libraryItem.scrollIntoViewIfNeeded();
//
//            if (libraryItem != null) {
//                String libraryItemText = libraryItem.innerText();
//                libraryItemsList.add(removeThePrefix.apply(libraryItemText));
//            }
//        }
//
//        System.out.println("AHAHAHA here's the collected list: " + "with size: " + libraryItemsList.size() + ", so: " + libraryItemsList);
//        assertThat(libraryItemsList, softOrdered(String.CASE_INSENSITIVE_ORDER));
//
//
//        return this;
//    }

//    public LibraryPage verifyLibraryListIsSortedAsc() {
//        final int MAX_ELEMENTS = 27;
//        String libraryItemSelector = "div[role=presentation] li[aria-posinset] div[data-encore-id='listRow'] p[id^='listrow-title-spotify'] span";
//
//        List<Locator> libraryItemsList = elementActions.findAllElementsBySelector(libraryItemSelector);
//
//        Function<String, String> removeThePrefix = (String s) -> s != null && s.toLowerCase().startsWith("the ") ? s.substring(4) : s;
//
//        List<String> libraryItemsCollected = libraryItemsList.stream()
//                .filter(Objects::nonNull)
//                .limit(MAX_ELEMENTS)
//                .map(element -> element.innerText())
//                .map(removeThePrefix)
//                .collect(Collectors.toList());
//
//        System.out.println("AHAHAHA here's the initial array: " + "with size: " + libraryItemsList.size() + ", so: " + libraryItemsList);
//        System.out.println("AHAHAHA here's the collected list: " + "with size: " + libraryItemsCollected.size() + ", so: " + libraryItemsCollected);
//
//        assertThat(libraryItemsCollected, softOrdered(String.CASE_INSENSITIVE_ORDER));
//
//        return this;
//    }

//    public LibraryPage verifyLibraryListIsSortedAsc() {
//        String[] libraryItemsArray = new String[27];
//
//        for (int i = 0; i < 27; i++) {
//            String libraryItemSelector = "div[role=presentation] li[aria-posinset='" + (1 + i) + "'] div[data-encore-id='listRow'] p[id^='listrow-title-spotify'] span";
//
//            Locator libraryItemElement = elementActions.findElementBySelector(libraryItemSelector);
//
//            if (libraryItemElement != null) {
//                String libraryItemTitle = libraryItemElement.innerText();
//                libraryItemsArray[i] = libraryItemTitle;
//            }
//        }
//
//        Function<String, String> removeThePrefix = (String s) -> s != null && s.toLowerCase().startsWith("the ") ? s.substring(4) : s;
//
//        List<String> libraryItemsCollected = Arrays.stream(libraryItemsArray)
//                .filter(Objects::nonNull)
//                .map(removeThePrefix)
//                .collect(Collectors.toList());
//
//        System.out.println("AHAHAHA here's the initial array: " + Arrays.stream(libraryItemsArray).toList());
//        System.out.println("AHAHAHA here's the collected list: " + libraryItemsCollected);
//
//        assertThat(libraryItemsCollected, softOrdered(String.CASE_INSENSITIVE_ORDER));
//
//        return this;
//    }

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
