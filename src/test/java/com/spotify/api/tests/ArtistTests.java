package com.spotify.api.tests;

import com.spotify.api.utils.AuthUtil;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ArtistTests {

    @Test
    void artistDataTest() {
        given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
        .when()
                .get("https://api.spotify.com/v1/artists/7dGJo4pcD2V6oG8kP0tJRR")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void multipleArtistsDataTest() {
        given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .param("ids", "7dGJo4pcD2V6oG8kP0tJRR,3qiHUAX7zY4Qnjx8TNUzVx,07SFzTMeYf5P8Rd32a9Zzw")
        .when()
                .get("https://api.spotify.com/v1/artists")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void artistAlbumTest() {
        given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .param("include_groups", "album")
                .param("market", "DE")
        .when()
                .get("https://api.spotify.com/v1/artists/7dGJo4pcD2V6oG8kP0tJRR/albums")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void artistTopTracksTest() {
        given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .param("market", "DE")
        .when()
                .get("https://api.spotify.com/v1/artists/7dGJo4pcD2V6oG8kP0tJRR/top-tracks")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void RelatedArtistsTest() {
        given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
        .when()
                .get("https://api.spotify.com/v1/artists/7dGJo4pcD2V6oG8kP0tJRR/related-artists")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}
