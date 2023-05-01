package com.spotify.api.utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class AuthUtil {

    private static String authToken;

    private static void generateAuthToken() {
        String clientIdParam = "&client_id=" + "client_id_key";
        String clientSecretParam = "&client_secret=" + "client_secret_key";

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
