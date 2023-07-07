package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.spotify.utils.BrowserActions;
import com.spotify.utils.ElementActions;
import com.spotify.utils.ElementChecks;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SearchPage {

    private final BrowserActions browserActions;
    private final ElementActions elementActions;
    private final ElementChecks elementChecks;
    private final Page page;

    public SearchPage (Page page) {
        this.page = page;
        this.browserActions = new BrowserActions(page);
        this.elementActions = new ElementActions(page);
        this.elementChecks = new ElementChecks(page);
    }

    public SearchPage openSearchPage() {
        browserActions.navigateToUrl("https://open.spotify.com/search");
        return this;
    }

    public SearchPage fillInSearchField(String searchQuery) {
        browserActions.fillInTextField(findSearchField(), searchQuery);
        return this;
    }

    public SearchPage verifyAllFilterButtonIsAvailable() {
        page.waitForSelector("[data-testid='grid-search-results']");
        Assertions.assertTrue(elementChecks.isElementVisible(findAllFilterButton()));
        return this;
    }

    public SearchPage clickSongsFilterButton() {
        findSongsFilterButton().click();
        return this;
    }

    public SearchPage verifySearchedSongIsReturnedInTop10Results(String expectedSongTitle, String expectedSongArtist) {
        page.waitForSelector("[data-testid = 'tracklist-row']");

        String[][] songAndArtistArray = new String[10][2];

        for (int i = 0; i < 10; i++) {
            String songTitleSelector = "div[aria-rowindex='" + (2 + i) + "'] [data-testid = 'tracklist-row'] a div";
            String songArtistSelector = "div[aria-rowindex='" + (2 + i) + "'] [data-testid = 'tracklist-row'] span a[href*='/artist']";

            Locator songTitleElement = findSongSearchResultTitle(songTitleSelector);
            List<Locator> songArtistElements = findSongSearchResultArtists(songArtistSelector);

            if (songTitleElement != null && songArtistElements != null && !songArtistElements.isEmpty()) {
                String songTitle = songTitleElement.innerText();

                StringBuilder songArtists = new StringBuilder();
                for (Locator songArtist : songArtistElements) {
                    if (songArtists.length() != 0) {
                        songArtists.append(", ");
                    }
                    songArtists.append(songArtist.innerText());
                }

                songAndArtistArray[i][0] = songTitle;
                songAndArtistArray[i][1] = songArtists.toString();
            }
        }

        boolean isExpectedSongReturned = Arrays.stream(songAndArtistArray)
                .filter(Objects::nonNull)
                .anyMatch(pair -> pair[0].equals(expectedSongTitle) && pair[1].equals(expectedSongArtist));

        Assertions.assertTrue(isExpectedSongReturned);

        System.out.println(Arrays.deepToString(songAndArtistArray));

        return this;
    }

    private Locator findSearchField() {
        return elementActions.findElementByTestId("search-input");
    }

    private Locator findAllFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "All");
    }

    private Locator findSongsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "Songs");
    }

    private Locator findArtistsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "Artists");
    }

    private Locator findAlbumsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "Albums");
    }

    private Locator findPlaylistsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "Playlists");
    }

    private Locator findProfilesFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "Profiles");
    }

    private Locator findPodcastsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, "Podcasts & Shows");
    }

    private Locator findSongSearchResultTitle(String songElementSelector) {
        try {
            return elementActions.findElementBySelector(songElementSelector);
        } catch (PlaywrightException e) {
            System.out.println("Couldn't find the specified search result element for the song");
            return null;
        }
    }

    private List<Locator> findSongSearchResultArtists(String songElementSelector) {
        try {
            return elementActions.findAllElementsBySelector(songElementSelector);
        } catch (PlaywrightException e) {
            System.out.println("Couldn't find the specified search result element for the song");
            return null;
        }
    }
}