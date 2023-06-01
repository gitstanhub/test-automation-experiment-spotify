package com.spotify.models.response.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.models.response.commons.ApiCommonsResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class ArtistProfileResponseModel {

    @JsonProperty("external_urls")
    private ApiCommonsResponseModel.ExternalUrls externalUrls;

    private Followers followers;
    private List<String> genres;
    private String href;
    private String id;
    private List<ApiCommonsResponseModel.Images> images;
    private String name;
    private Integer popularity;
    private String type;
    private String uri;

    @Data
    public static class Followers {
        private String href;
        private Integer total;
    }
}
