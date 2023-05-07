package com.spotify.api.models.response.commons;

import lombok.Data;

@Data
public class ArtistCommonsResponseModel {

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
}
