package com.spotify.models.response.playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.models.response.commons.ApiCommonsResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistResponseModel {

    private Boolean collaborative;
    private String description;
    private ApiCommonsResponseModel.ExternalUrls external_urls;
    private String href;
    private String id;
    private List<ApiCommonsResponseModel.Images> images;
    private String name;
    private Owner owner;
    private String primary_color;
    @JsonProperty("public")
    private Boolean isPublic;
    private String snapshot_id;
    private Tracks tracks;
    private String type;
    private String uri;

    @Data
    private static class Owner {
        private String display_name;
        private ApiCommonsResponseModel.ExternalUrls external_urls;
        private String href;
        private String id;
        private String type;
        private String uri;
    }

    @Data
    private static class Tracks {
        private String href;
        private Integer total;
    }

}
