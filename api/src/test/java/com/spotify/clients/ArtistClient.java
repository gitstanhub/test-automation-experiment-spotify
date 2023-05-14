package com.spotify.clients;

import com.spotify.models.response.artist.*;

import static com.spotify.specifications.ArtistSpec.artistRequestSpec;
import static com.spotify.specifications.ArtistSpec.artistResponseSpec;
import static io.restassured.RestAssured.given;

public class ArtistClient {

    public ArtistProfileResponseModel getArtistData(String artistId) {
        return given(artistRequestSpec)
        .when()
                .get(artistId)
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistProfileResponseModel.class);
    }

    public ArtistTopTracksResponseModel getArtistTopTracks(String country, String artistID) {
        return given(artistRequestSpec)
                .param("market", country)
        .when()
                .get(artistID + "/top-tracks")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistTopTracksResponseModel.class);
    }

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

    public ArtistRelatedResponseModel getRelatedArtists(String artistID) {
        return given(artistRequestSpec)
        .when()
                .get(artistID + "/related-artists")
        .then()
                .spec(artistResponseSpec)
                .extract().as(ArtistRelatedResponseModel.class);
    }

    public ArtistMultipleResponseModel getMultipleArtistsData(String[] artists) {

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
