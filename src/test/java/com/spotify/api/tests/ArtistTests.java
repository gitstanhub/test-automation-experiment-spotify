package com.spotify.api.tests;

import com.spotify.api.clients.ArtistClient;
import com.spotify.api.models.ArtistAlbumsResponseModel;
import com.spotify.api.models.ArtistDataResponseModel;
import com.spotify.api.models.ArtistRelatedResponseModel;
import com.spotify.api.models.ArtistTopTracksResponseModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();

    @Test
    void artistProfileTest() {
        ArtistDataResponseModel artistData = artistClient.getArtistData();
        Assertions.assertThat(artistData.getName()).isEqualTo("Capital Bra");

        ArtistTopTracksResponseModel artistTopTracks = artistClient.getArtistTopTracks();
        Assertions.assertThat(artistTopTracks.getTracks().get(0).getName()).isEqualTo("Discokugel");

        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums();
        Assertions.assertThat(artistAlbums.getItems().get(0).getName()).isEqualTo("DEUTSCHRAP BRANDNEU");

        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists();
        Assertions.assertThat(artistRelated.getArtists().get(0).getName()).isEqualTo("AK AUSSERKONTROLLE");

    }



//    @Test
//    void multipleArtistsDataTest() {
//        given()
//                .log().uri()
//                .log().headers()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
//                .param("ids", "4WZGDpNwrC0vNQyl9QzF7d,3qiHUAX7zY4Qnjx8TNUzVx,07SFzTMeYf5P8Rd32a9Zzw")
//                .when()
//                .get("https://api.spotify.com/v1/artists")
//                .then()
//                .log().status()
//                .log().body()
//                .statusCode(200);
//    }



}
