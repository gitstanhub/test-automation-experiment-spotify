package com.spotify.pageobjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.spotify.config.ConfigProviderWeb;
import com.spotify.pageobjects.base.PlaywrightPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.spotify.driver.PlaywrightDriverHandler.getPage;
import static com.spotify.locators.pages.SearchPageLocators.*;

@Component
@Lazy
@Slf4j
public class SearchPage extends PlaywrightPage {

    public SearchPage openSearchPage() {
        browserActions.navigateToUrl(ConfigProviderWeb.getWebAppConfiguration().baseUrl() + "/search");
        return this;
    }

    public SearchPage fillInSearchField(String searchQuery) {
        browserActions.fillInTextField(findSearchField(), searchQuery);
        return this;
    }

    public SearchPage verifyAllFilterButtonIsAvailable() {
        getPage().waitForSelector(FILTER_ALL_BUTTON_SELECTOR);
        Assertions.assertTrue(elementChecks.isElementVisible(findAllFilterButton()));
        return this;
    }

    public SearchPage clickSongsFilterButton() {
        findSongsFilterButton().click();
        return this;
    }

    public SearchPage clickPlaylistsFilterButton() {
        findPlaylistsFilterButton().click();
        return this;
    }

    public SearchPage verifySearchedSongIsReturnedInTop10Results(String expectedSongTitle, String expectedSongArtist) {
        getPage().waitForSelector(SEARCH_RESULT_TRACK_ROW);

        String[][] songAndArtistArray = new String[10][2];

        for (int i = 0; i < 10; i++) {

            Locator songTitleElement = findSongSearchResultTitle(String.format(SONG_TITLE_SELECTOR, (2 + i)));
            List<Locator> songArtistElements = findSongSearchResultArtists(String.format(SONG_ARTIST_SELECTOR, (2 + i)));

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

    public SearchPage verifySearchedPlaylistIsReturnedInTop10Results(String expectedPlaylistTitle) {
        getPage().waitForSelector(SEARCH_RESULTS_LIST);

        String[] playlistsArray = new String[10];

        for (int i = 0; i < 10; i++) {

            Locator playlistTitleElement = findPlaylistSearchResultTitle(String.format(PLAYLIST_TITLE_SELECTOR, i));

            if (playlistTitleElement != null) {
                String playlistTitle = playlistTitleElement.innerText();

                playlistsArray[i] = playlistTitle;
            }
        }

        boolean isExpectedPlaylistReturned = Arrays.stream(playlistsArray)
                .filter(Objects::nonNull)
                .anyMatch(item -> item.equals(expectedPlaylistTitle));

        Assertions.assertTrue(isExpectedPlaylistReturned);

        System.out.println(Arrays.toString(playlistsArray));

        return this;
    }

    private Locator findSearchField() {
        return elementActions.findElementByTestId(SEARCH_FIELD);
    }

    private Locator findAllFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().allFilterButtonText());
    }

    private Locator findSongsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().songsFilterButtonText());
    }

    private Locator findArtistsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().artistsFilterButtonText());
    }

    private Locator findAlbumsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().albumsFilterButtonText());
    }

    private Locator findPlaylistsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().searchPlaylistsFilterButtonText());
    }

    private Locator findProfilesFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().profilesFilterButtonText());
    }

    private Locator findPodcastsFilterButton() {
        return elementActions.findElementByRole(AriaRole.LINK, ConfigProviderWeb.getWebAppLocaleConfig().podcastsFilterButtonText());
    }

    private Locator findSongSearchResultTitle(String songElementSelector) {
        try {
            return elementActions.findElementBySelector(songElementSelector);
        } catch (PlaywrightException e) {
            log.info("Couldn't find the specified search result element for the song");
            return null;
        }
    }

    private List<Locator> findSongSearchResultArtists(String songElementSelector) {
        try {
            return elementActions.findAllElementsBySelector(songElementSelector);
        } catch (PlaywrightException e) {
            log.info("Couldn't find the specified search result element for the song");
            return null;
        }
    }

    private Locator findPlaylistSearchResultTitle(String playlistElementSelector) {
        try {
            return elementActions.findElementBySelector(playlistElementSelector);
        } catch (PlaywrightException e) {
            log.info("Couldn't find the specified search result element for the playlist");
            return null;
        }
    }
}
