package com.spotify.clients;

import com.spotify.models.response.artist.*;
import io.qameta.allure.Step;

import java.util.List;

import static com.spotify.specifications.ArtistSpec.artistRequestSpec;
import static com.spotify.specifications.ArtistSpec.artistResponseSpec;
import static io.restassured.RestAssured.given;

public class ArtistClient {

    @Step
    public ArtistProfileResponseModel getArtistData(String artistId) {
        return given(artistRequestSpec)
                .when()
                .get(artistId)
                .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistProfileResponseModel.class);
    }

    @Step
    public ArtistTopTracksResponseModel getArtistTopTracks(String country, String artistID) {
        return given(artistRequestSpec)
                .param("market", country)
                .when()
                .get(artistID + "/top-tracks")
                .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistTopTracksResponseModel.class);
    }

    @Step
    public ArtistAlbumsResponseModel getArtistAlbums(String country, String artistID) {
        return given(artistRequestSpec)
                .param("include_groups", "album")
                .param("market", country)
                .when()
                .get(artistID + "/albums")
                .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistAlbumsResponseModel.class);
    }

    @Step
    public ArtistRelatedResponseModel getRelatedArtists(String artistID) {
        return given(artistRequestSpec)
                .when()
                .get(artistID + "/related-artists")
                .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistRelatedResponseModel.class);
    }

    @Step
    public ArtistMultipleResponseModel getMultipleArtistsData(List<String> artists) {

        String artistsParam = String.join(",", artists);

        return given(artistRequestSpec)
                .param("ids", artistsParam)
                .when()
                .get()
                .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistMultipleResponseModel.class);
    }
}
