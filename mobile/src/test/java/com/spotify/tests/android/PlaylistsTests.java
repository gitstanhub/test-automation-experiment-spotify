package com.spotify.tests.android;

import com.spotify.annotations.AuthRequiredMobile;
import com.spotify.tests.base.MobileTests;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.playlist.constants.PlaylistEntities.PLAYLIST_1;

public class PlaylistsTests extends MobileTests {

    @Test
    @AuthRequiredMobile
    public void playlistCanBeCreatedFromLibrary() {

        String playlistName = PLAYLIST_1.getPlaylistName();

        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .tapPlaylistsButton()
                .tapCreatePlaylistButton();

        getPlaylistCreationPage()
                .verifyPlaylistCreationPageIsOpened()
                .enterPlaylistName(playlistName)
                .tapCreateButton();

        getPlaylistPage()
                .verifyPlaylistArtworkIsAvailable()
                .verifyPlaylistNameIsAvailable()
                .verifyPlaylistNameIsExact(playlistName);
    }

    @Test
    @AuthRequiredMobile
    public void playlistCanBeDeletedFromLibrary() {

        String playlistName = PLAYLIST_1.getPlaylistName();
        String playlistAuthor = PLAYLIST_1.getPlaylistAuthor();

        getNavigation()
                .tapLibraryButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened()
                .tapPlaylistsButton()
                .selectPlaylistItem(playlistName, playlistAuthor);

        getPlaylistPage()
                .verifyPlaylistNameIsExact(playlistName);

        getMediaInteraction()
                .tapContextMenuButton();

        getContextMenu()
                .tapDeletePlaylistButton();

        getPlaylistPage()
                .verifyDeletePopupTitleIsAvailable()
                .verifyDeletePopupSubtitleIsAvailable(playlistName)
                .tapPlaylistDeleteConfirmButton();

        getLibraryPage()
                .verifyLibraryPageIsOpened();
    }
}
