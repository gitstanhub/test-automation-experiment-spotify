package com.spotify.api.utils;

import static io.restassured.RestAssured.given;

import com.spotify.api.models.request.auth.AuthRequestBodyModel;
import io.restassured.response.Response;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.StandardCharsets;

public class ApiAuthUtil {

    private static String authToken;

    private static void generateAuthToken() {
        AuthRequestBodyModel authRequestBodyModel = new AuthRequestBodyModel();
        authRequestBodyModel.setGrant_type("client_credentials");
        authRequestBodyModel.setClient_id("client_id_key");
        authRequestBodyModel.setClient_secret("client_secret_key");

        String requestBody = URLEncodedUtils.format(authRequestBodyModel.getBodyParams(), StandardCharsets.UTF_8);

        Response response = given()
                .log().uri()
                .log().headers()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(requestBody)
        .when()
                .post("https://accounts.spotify.com/api/token")
        .then()
                .log().status()
                .log().body()
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
