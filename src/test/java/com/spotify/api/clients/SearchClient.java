package com.spotify.api.clients;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.*;

import static com.spotify.api.specifications.SearchSpec.searchRequestSpec;
import static com.spotify.api.specifications.SearchSpec.searchResponseSpec;
import static io.restassured.RestAssured.given;

public class SearchClient {

    @Step
    public ValidatableResponse search(String query, List<String> type) {
        return search(query, type, null, null, null, null);
    }

    @Step
    public ValidatableResponse searchWithMarket(String query, List<String> type, String market) {
        return search(query, type, market, null, null, null);
    }

    @Step
    public ValidatableResponse searchWithLimitOffset(String query, List<String> type, Integer limit, Integer offset) {
        return search(query, type, null, limit, offset, null);
    }

    @Step
    public ValidatableResponse searchWithIncludeExternal(String query, List<String> type, String includeExternal) {
        return search(query, type, null, null, null, includeExternal);
    }

    private ValidatableResponse search(String query, List<String> type, String market, Integer limit, Integer offset, String includeExternal) {
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

        return request.
                when()
                .get()
                .then()
                .spec(searchResponseSpec);
    }
}
