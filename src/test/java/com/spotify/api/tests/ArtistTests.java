package com.spotify.api.tests;

import com.spotify.api.clients.ArtistClient;
import com.spotify.api.models.artist.*;
import com.spotify.api.utils.ApiAssertionsUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();

    @Test
    void artistProfileTest() {
        ArtistDataResponseModel artistData = artistClient.getArtistData();
        ArtistTopTracksResponseModel artistTopTracks = artistClient.getArtistTopTracks();
        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums();
        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists();

        Map<Object, Object> expectedResponse = Map.of(
                artistData.getName(), "Capital Bra",
                artistTopTracks.getTracks().get(0).getName(), "Discokugel",
                artistAlbums.getItems().get(0).getName(), "DEUTSCHRAP BRANDNEU",
                artistRelated.getArtists().get(0).getName(), "AK AUSSERKONTROLLE"
        );

        apiAssertionsUtil.verifyResponseMultipleFields(expectedResponse);
    }

    @Test
    void multipleArtistProfilesTest() {
        ArtistMultipleResponseModel artistsMultiple = artistClient.getMultipleArtistsData();

        apiAssertionsUtil.verifyResponseSingleField(artistsMultiple.getArtists().get(1).getName(), "Yeat");
    }
}
