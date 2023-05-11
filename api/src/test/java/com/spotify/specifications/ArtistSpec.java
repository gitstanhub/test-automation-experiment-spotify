package com.spotify.specifications;

import com.spotify.utils.ApiAuthUtil;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.utils.AllureListenerUtil.customTemplates;
import static io.restassured.RestAssured.with;

public class ArtistSpec {

    public static RequestSpecification artistRequestSpec = with()
            .filter(customTemplates())
            .log().uri()
            .log().headers()
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + ApiAuthUtil.getAuthToken())
            .baseUri("https://api.spotify.com/")
            .basePath("v1/artists/");

    public static ResponseSpecification artistResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
