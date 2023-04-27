package com.spotify.api.tests;

import com.spotify.api.clients.ArtistClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();

    @Test
    void artistInfoTest() {
        artistClient.getArtistData();

//        artistClient.getArtistTopTracks();

//        artistClient.getArtistAlbums();
//
//        artistClient.getRelatedArtists();


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
