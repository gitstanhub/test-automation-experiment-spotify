package com.spotify.tests;

import com.spotify.annotations.AuthRequiredWeb;
import com.spotify.pageobjects.pages.SearchPage;
import com.spotify.tests.base.WebTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import static com.spotify.testdata.playlists.constants.Playlists.PLAYLIST_2;
import static com.spotify.testdata.tracks.constants.Tracks.ARTIST2_TRACK_1;

public class GlobalSearchTests extends WebTests {

    @Autowired
    @Lazy
    SearchPage searchPage;

    @Test
    @AuthRequiredWeb
    public void songCanBeFoundInTopResults() {

        String trackName = ARTIST2_TRACK_1.getTrackName();
        String trackArtist = ARTIST2_TRACK_1.getTrackArtists().get(0);

        searchPage
                .openSearchPage()
                .fillInSearchField(trackName + " " + trackArtist)
                .verifyAllFilterButtonIsAvailable()
                .clickSongsFilterButton()
                .verifySearchedSongIsReturnedInTop10Results(trackName, trackArtist);
    }

    @Test
    @AuthRequiredWeb
    public void playlistCanBeFoundInTopResults() {

        String playlistName = PLAYLIST_2.getPlaylistName();

        searchPage
                .openSearchPage()
                .fillInSearchField(playlistName)
                .verifyAllFilterButtonIsAvailable()
                .clickPlaylistsFilterButton()
                .verifySearchedPlaylistIsReturnedInTop10Results(playlistName);
    }
}
