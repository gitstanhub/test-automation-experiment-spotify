package com.spotify.api.clients;

import com.spotify.api.utils.ApiAuthUtil;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.*;

import static com.spotify.api.specifications.SearchSpec.searchRequestSpec;
import static com.spotify.api.specifications.SearchSpec.searchResponseSpec;
import static io.restassured.RestAssured.given;

public class SearchClient {

    public ValidatableResponse search(String query, List<String> type, Optional<String> market, Optional<Integer> limit, Optional<Integer> offset, Optional<String> includeExternal) {
        RequestSpecification request =
                given(searchRequestSpec)
                        .param("q", query)
                        .param("type", type);

        Map<String, Object> optionalParams = new HashMap<>();
        optionalParams.put("market", market);
        optionalParams.put("limit", limit);
        optionalParams.put("offset", offset);
        optionalParams.put("include_external", includeExternal);

        optionalParams.forEach((key, value) -> {
            if (value != null) {
                request.param(key, value);
            }
        });

        return request
                .when()
                        .get()
                .then()
                        .spec(searchResponseSpec);
    }

}



