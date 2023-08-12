package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.artist.constants.ArtistAlbums.ARTIST_1_ALBUM_1;
import static com.spotify.testdata.artist.constants.ArtistAlbums.ARTIST_2_ALBUM_1;
import static com.spotify.testdata.artist.constants.ArtistEntities.ARTIST_1;
import static com.spotify.testdata.artist.constants.ArtistEntities.ARTIST_2;

public class GlobalSearchTests extends MobileTests {

    @Test
    @AuthRequiredMobile
    public void artistCanBeFound() {

        String artistName = ARTIST_1.getArtistName();

        getNavigation()
                .tapSearchButton();
        getSearchPage()
                .verifySearchPageIsOpened()
                .tapGlobalSearchField();
        getSearchResultsPage()
                .searchGloballyFor(artistName)
                .tapArtistsFilterButton()
                .verifySearchResultIsAvailable(artistName);
    }

    @Test
    @AuthRequiredMobile
    public void albumCanBeFound() {

        String albumName = ARTIST_1_ALBUM_1.getAlbumName();

        getNavigation()
                .tapSearchButton();
        getSearchPage()
                .verifySearchPageIsOpened()
                .tapGlobalSearchField();
        getSearchResultsPage()
                .searchGloballyFor(albumName)
                .tapAlbumFilterButton()
                .verifySearchResultIsAvailable(albumName);
    }
}
