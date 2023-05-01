package com.spotify.api.tests;

import com.spotify.api.clients.ArtistClient;
import com.spotify.api.models.artist.*;
import com.spotify.api.utils.ApiAssertionsUtil;
import org.junit.jupiter.api.Test;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();

    @Test
    void artistProfileTest() {
        ArtistDataResponseModel artistData = artistClient.getArtistData();
        apiAssertionsUtil.verifyFieldValue(artistData.getName(), "Capital Bra");

        ArtistTopTracksResponseModel artistTopTracks = artistClient.getArtistTopTracks();
        apiAssertionsUtil.verifyFieldValue(artistTopTracks.getTracks().get(0).getName(), "Discokugel");

        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums();
        apiAssertionsUtil.verifyFieldValue(artistAlbums.getItems().get(0).getName(), "DEUTSCHRAP BRANDNEU");

        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists();
        apiAssertionsUtil.verifyFieldValue(artistRelated.getArtists().get(0).getName(), "AK AUSSERKONTROLLE");

        ArtistMultipleResponseModel artistsMultiple = artistClient.getMultipleArtistsData();
        apiAssertionsUtil.verifyFieldValue(artistsMultiple.getArtists().get(1).getName(), "Yeat");
    }
}
