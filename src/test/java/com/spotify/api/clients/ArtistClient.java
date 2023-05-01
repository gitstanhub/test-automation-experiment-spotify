package com.spotify.api.clients;

import com.spotify.api.models.artist.*;
import com.spotify.api.utils.AuthUtil;

import static com.spotify.api.specifications.ArtistSpec.artistRequestSpec;
import static com.spotify.api.specifications.ArtistSpec.artistResponseSpec;
import static io.restassured.RestAssured.given;

public class ArtistClient {

    public ArtistDataResponseModel getArtistData() {
        return given(artistRequestSpec)
        .when()
                .get("4WZGDpNwrC0vNQyl9QzF7d")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistDataResponseModel.class);
    }

    public ArtistTopTracksResponseModel getArtistTopTracks() {
        return given(artistRequestSpec)
                .param("market", "DE")
        .when()
                .get("4WZGDpNwrC0vNQyl9QzF7d/top-tracks")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistTopTracksResponseModel.class);
    }

    public ArtistAlbumsResponseModel getArtistAlbums() {
        return given(artistRequestSpec)
                .param("include_groups", "album")
                .param("market", "DE")
        .when()
                .get("4WZGDpNwrC0vNQyl9QzF7d/albums")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistAlbumsResponseModel.class);
    }

    public ArtistRelatedResponseModel getRelatedArtists() {
        return given(artistRequestSpec)
        .when()
                .get("4WZGDpNwrC0vNQyl9QzF7d/related-artists")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistRelatedResponseModel.class);
    }

    public ArtistMultipleResponseModel getMultipleArtistsData() {

        String[] artistsCollection = {
                "4WZGDpNwrC0vNQyl9QzF7d",
                "3qiHUAX7zY4Qnjx8TNUzVx",
                "07SFzTMeYf5P8Rd32a9Zzw"
        };

        String artistsParam = String.join(",", artistsCollection);

        return given(artistRequestSpec)
                .param("ids", artistsParam)
        .when()
                .get("https://api.spotify.com/v1/artists")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistMultipleResponseModel.class);
    }
}
