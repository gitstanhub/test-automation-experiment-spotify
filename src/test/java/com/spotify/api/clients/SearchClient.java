package com.spotify.api.clients;

import com.spotify.api.models.response.search.SearchResponseModel;
import io.qameta.allure.Step;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import java.util.*;

import static com.spotify.api.specifications.SearchSpec.searchRequestSpec;
import static com.spotify.api.specifications.SearchSpec.searchResponseSpec;
import static io.restassured.RestAssured.given;

public class SearchClient {

    @Step
    public SearchResponseModel search(String query, List<String> types) {
        return search(query, types, null, null, null, null);
    }

    @Step
    public SearchResponseModel searchWithMarket(String query, List<String> types, String market) {
        return search(query, types, market, null, null, null);
    }

    @Step
    public SearchResponseModel searchWithMarketLimitOffset(String query, List<String> types, String market, Integer limit, Integer offset) {
        return search(query, types, market, limit, offset, null);
    }

    @Step
    public SearchResponseModel searchWithLimitOffset(String query, List<String> types, Integer limit, Integer offset) {
        return search(query, types, null, limit, offset, null);
    }

    @Step
    public SearchResponseModel searchWithIncludeExternal(String query, List<String> types, String includeExternal) {
        return search(query, types, null, null, null, includeExternal);
    }

    private SearchResponseModel search(String query, List<String> types, String market, Integer limit, Integer offset, String includeExternal) {

        String typesParamValue = types != null ? String.join(",", types) : null;


        RequestSpecification request =
                given(searchRequestSpec)
                        .param("q", query)
                        .param("type", typesParamValue);

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

        if (query != null && typesParamValue != null) {
            return request.
                when()
                .get()
                .then()
                .spec(searchResponseSpec)
                .extract().as(SearchResponseModel.class);
        } else {
            return request
                    .when()
                    .get()
                    .then()
                    .log().status()
                    .statusCode(400)
                    .extract().as(SearchResponseModel.class);
        }
    }
}
