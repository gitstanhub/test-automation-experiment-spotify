package com.spotify.api.models;

import lombok.Data;

import java.util.List;

@Data
public class ArtistDataResponseModel {

    private ExternalUrls external_urls;

    private Followers followers;

    private List<String> genres;

    private String href;

    private String id;

    private List<Images> images;

    private String name;

    private int popularity;

    private String type;

    private String uri;

    @Data
    public static class ExternalUrls {
        private String spotify;
    }

    @Data
    public static class Followers {
        private String href;
        private int total;
    }

    @Data
    public static class Images {
        private int height;
        private String url;
        private int width;
    }
}
