package com.spotify.api.utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class AuthUtil {

    private static String authToken;

    private static void generateAuthToken() {
        String clientIdParam = "&client_id=" + "7aaa8656480f4a629d02973618636403";
        String clientSecretParam = "&client_secret=" + "2616a7f644b94b90a015f7c70257f79d";

        Response response = given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("grant_type=client_credentials" + clientIdParam + clientSecretParam)
        .when()
                .post("https://accounts.spotify.com/api/token")
        .then()
                .log().status()
                .statusCode(200)
                .extract().response();

        authToken = response.path("access_token");
    }

    public static String getAuthToken() {
        if (authToken == null) {
            generateAuthToken();
        }
        return authToken;
    }
}
