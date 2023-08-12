package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.artist.constants.ArtistEntities.ARTIST_2;

public class LibraryTests extends MobileTests {

    //ToDo: move to PlaylistsTests
    @Test
    @AuthRequiredMobile
    public void playlistCanBeCreatedFromLibrary() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .tapPlaylistsButton()
                .tapCreatePlaylistButton();

        getPlaylistCreationPage()
                .verifyPlaylistCreationPageIsOpened()
                .enterPlaylistName("Braa")
                .tapCreateButton();

        getPlaylistPage()
                .verifyPlaylistArtworkIsAvailable()
                .verifyPlaylistNameIsAvailable()
                .verifyPlaylistNameIsExact("Braa");
    }

    @Test
    @AuthRequiredMobile
    public void playlistCanBeDeletedFromLibrary() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapPlaylistsButton()
                .selectPlaylistItem("Braa", "Stanislav");

        getPlaylistPage()
                .verifyPlaylistNameIsExact("Braa");

        getMediaInteraction()
                .tapContextMenuButton();

        getContextMenu()
                .tapDeletePlaylistButton();

        getPlaylistPage()
                .verifyDeletePopupTitleIsAvailable()
                .verifyDeletePopupSubtitleIsAvailable("Braa")
                .tapPlaylistDeleteConfirmButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened();
    }

    @Test
    @AuthRequiredMobile
    public void artistCanBeSearchedInLibrary() {
        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapSearchButton();

        getLibrarySearchPage()
                .searchLibraryFor(ARTIST_2.getArtistName())
                .verifySearchResultIsAvailable(ARTIST_2.getArtistName(), "Artist");
    }
}
