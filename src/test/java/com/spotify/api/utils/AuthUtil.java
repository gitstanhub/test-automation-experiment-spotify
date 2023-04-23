package com.spotify.api.utils;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class AuthUtil {

    private static String authToken;

    private static void generateAuthToken() {
        Response response = given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("grant_type=client_credentials&client_id=&client_secret=")
        .when()
                .post("https://accounts.spotify.com/api/token")
        .then()
                .log().status()
                .extract()
                .response();

        authToken = response.path("access_token");
    }

    public static String getAuthToken() {
        if (authToken == null) {
            generateAuthToken();
        }
        return authToken;
    }
}
