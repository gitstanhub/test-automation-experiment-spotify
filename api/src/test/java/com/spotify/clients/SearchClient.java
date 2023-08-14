package com.spotify.clients;

import com.spotify.models.response.search.SearchResponseModel;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.spotify.specifications.SearchSpec.*;
import static io.restassured.RestAssured.given;

@Component
@Lazy
@Slf4j
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
    public SearchResponseModel searchWithMarketAndLimitAndOffset(String query, List<String> types, String market, Integer limit, Integer offset) {
        return search(query, types, market, limit, offset, null);
    }

    @Step
    public SearchResponseModel searchWithLimitAndOffset(String query, List<String> types, Integer limit, Integer offset) {
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
            return request
                    .when()
                    .get()
                    .then()
                    .spec(searchResponseSpec)
                    .extract().as(SearchResponseModel.class);
        } else {
            return request
                    .when()
                    .get()
                    .then()
                    .spec(searchErrorResponseSpec)
                    .extract().as(SearchResponseModel.class);
        }
    }
}
