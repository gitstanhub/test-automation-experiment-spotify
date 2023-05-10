package com.spotify.utils;

import static io.restassured.RestAssured.given;

import com.spotify.models.request.auth.AuthRequestModel;
import io.restassured.response.Response;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.StandardCharsets;

public class ApiAuthUtil {

    private static String authToken;

    private static void generateAuthToken() {

        AuthRequestModel authRequestBodyModel = new AuthRequestModel();
        authRequestBodyModel.setGrant_type("client_credentials");
        authRequestBodyModel.setClient_id("7aaa8656480f4a629d02973618636403");
        authRequestBodyModel.setClient_secret("2616a7f644b94b90a015f7c70257f79d");

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
