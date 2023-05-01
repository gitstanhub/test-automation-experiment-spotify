package com.spotify.api.models.commons;

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
