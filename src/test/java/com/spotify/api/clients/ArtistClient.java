package com.spotify.api.clients;

import com.spotify.api.models.ArtistAlbumsResponseModel;
import com.spotify.api.models.ArtistDataResponseModel;
import com.spotify.api.models.ArtistRelatedResponseModel;
import com.spotify.api.models.ArtistTopTracksResponseModel;
import com.spotify.api.utils.AuthUtil;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ArtistClient {

    public ArtistDataResponseModel getArtistData() {
        return given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .when()
                .get("https://api.spotify.com/v1/artists/4WZGDpNwrC0vNQyl9QzF7d")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(ArtistDataResponseModel.class);
    }

    public ArtistTopTracksResponseModel getArtistTopTracks() {
        return given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .param("market", "DE")
                .when()
                .get("https://api.spotify.com/v1/artists/4WZGDpNwrC0vNQyl9QzF7d/top-tracks")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(ArtistTopTracksResponseModel.class);
    }

    public ArtistAlbumsResponseModel getArtistAlbums() {
        return given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .param("include_groups", "album")
                .param("market", "DE")
                .when()
                .get("https://api.spotify.com/v1/artists/4WZGDpNwrC0vNQyl9QzF7d/albums")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(ArtistAlbumsResponseModel.class);
    }

    public ArtistRelatedResponseModel getRelatedArtists() {
        return given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + AuthUtil.getAuthToken())
                .when()
                .get("https://api.spotify.com/v1/artists/4WZGDpNwrC0vNQyl9QzF7d/related-artists")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(ArtistRelatedResponseModel.class);
    }
}
