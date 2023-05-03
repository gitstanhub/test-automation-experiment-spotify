package com.spotify.api.utils;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureListenerUtil {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured customTemplates() {
        FILTER.setRequestTemplate("tpl/request.ftl");
        FILTER.setResponseTemplate("tpl/response.ftl");
        return FILTER;
    }
}
