package com.spotify.models.response.commons;

import lombok.Data;

@Data
public class ApiCommonsResponseModel {

    @Data
    public static class ExternalUrls {
        private String spotify;
    }

    @Data
    public static class Images {
        private Integer height;
        private String url;
        private Integer width;
    }

    @Data
    public static class Error {
        private Integer status;
        private String message;
    }
}
