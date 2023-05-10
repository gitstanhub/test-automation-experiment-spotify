package com.spotify.models.response.artist;

import com.spotify.models.response.commons.ApiCommonsResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDataResponseModel {

    private ApiCommonsResponseModel.ExternalUrls external_urls;
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
