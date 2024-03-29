package com.spotify.specifications;

import com.spotify.config.ConfigProviderApi;
import com.spotify.utils.auth.ApiAuthUtil;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.utils.allure.AllureListenerUtil.customTemplates;
import static io.restassured.RestAssured.with;

public class SearchSpec {

    public static RequestSpecification searchRequestSpec = with()
            .filter(customTemplates())
            .log().uri()
            .log().headers()
            .header("Authorization", "Bearer " + ApiAuthUtil.getAuthToken())
            .baseUri(ConfigProviderApi.getRestAssuredApiConfiguration().baseUrl())
            .basePath("v1/search");

    public static ResponseSpecification searchResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification searchErrorResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .expectStatusCode(400)
            .build();
}
