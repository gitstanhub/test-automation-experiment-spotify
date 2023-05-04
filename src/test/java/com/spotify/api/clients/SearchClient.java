package com.spotify.api.clients;

import com.spotify.api.utils.ApiAuthUtil;
import io.restassured.response.ValidatableResponse;

import static com.spotify.api.specifications.SearchSpec.searchRequestSpec;
import static com.spotify.api.specifications.SearchSpec.searchResponseSpec;
import static io.restassured.RestAssured.given;

public class SearchClient {

    public ValidatableResponse search() {
        return given(searchRequestSpec)
                .param("q","capital bra")
                .param("type","album")
        .when()
                .get()
        .then()
                .spec(searchResponseSpec);
    }
}



