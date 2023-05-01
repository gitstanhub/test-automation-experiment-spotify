package com.spotify.api.models.artist;

import com.spotify.api.models.commons.ArtistCommonsResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDataResponseModel {

    private ArtistCommonsResponseModel.ExternalUrls external_urls;
    private Followers followers;
    private List<String> genres;
    private String href;
    private String id;
    private List<ArtistCommonsResponseModel.Images> images;
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
