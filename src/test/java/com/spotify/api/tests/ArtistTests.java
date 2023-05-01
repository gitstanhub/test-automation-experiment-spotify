package com.spotify.api.tests;

import com.spotify.api.clients.ArtistClient;
import com.spotify.api.models.response.artist.*;
import com.spotify.api.utils.ApiAssertionsUtil;
import com.spotify.api.utils.response.ArtistResponseFieldsUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.spotify.api.constants.ArtistProfileConstants.*;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    ArtistResponseFieldsUtil artistResponseFieldsUtil = new ArtistResponseFieldsUtil();

    @Test
    void artistProfileTest() {
        ArtistDataResponseModel artistData = artistClient.getArtistData();
        ArtistTopTracksResponseModel artistTopTracks = artistClient.getArtistTopTracks();
        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums();
        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists();

        Map<Object, Object> actualAndExpectedValues = Map.of(
                artistResponseFieldsUtil.getArtistName(artistData), ARTIST_NAME_SINGLE_PROFILE,
                artistResponseFieldsUtil.getTrackName(artistTopTracks, 0), ARTIST_TOP_TRACK_TITLE,
                artistResponseFieldsUtil.getArtistAlbumName(artistAlbums, 0), ARTIST_ALBUM_TITLE,
                artistResponseFieldsUtil.getArtistRelated(artistRelated, 0), ARTIST_RELATED_NAME
        );

        apiAssertionsUtil.verifyResponseMultipleFields(actualAndExpectedValues);
    }

    @Test
    void multipleArtistProfilesTest() {
        ArtistMultipleResponseModel artistsMultiple = artistClient.getMultipleArtistsData();

        apiAssertionsUtil.verifyResponseSingleField(artistResponseFieldsUtil.getArtistName(artistsMultiple, 1), ARTIST_NAME_MULTIPLE_PROFILES);
    }
}
