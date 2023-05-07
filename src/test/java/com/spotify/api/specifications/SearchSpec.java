package com.spotify.api.specifications;

import com.spotify.api.utils.ApiAuthUtil;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.api.utils.AllureListenerUtil.customTemplates;
import static io.restassured.RestAssured.with;

public class SearchSpec {

    public static RequestSpecification searchRequestSpec = with()
            .filter(customTemplates())
            .log().uri()
            .log().headers()
            .header("Authorization", "Bearer " + ApiAuthUtil.getAuthToken())
            .baseUri("https://api.spotify.com/")
            .basePath("v1/search");

    public static ResponseSpecification searchResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
