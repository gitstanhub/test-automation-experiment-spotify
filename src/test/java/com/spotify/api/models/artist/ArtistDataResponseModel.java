package com.spotify.api.models.artist;

import com.spotify.api.models.commons.ArtistCommons;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDataResponseModel {

    private ArtistCommons.ExternalUrls external_urls;
    private Followers followers;
    private List<String> genres;
    private String href;
    private String id;
    private List<ArtistCommons.Images> images;
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
