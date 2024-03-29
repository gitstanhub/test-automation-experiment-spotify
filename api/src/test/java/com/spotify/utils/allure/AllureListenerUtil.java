package com.spotify.utils.allure;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureListenerUtil {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured customTemplates() {

        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");

        return FILTER;
    }
}
