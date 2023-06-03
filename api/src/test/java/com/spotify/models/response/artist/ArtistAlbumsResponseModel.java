package com.spotify.models.response.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.models.response.commons.ApiCommonsResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class ArtistAlbumsResponseModel {

    private String href;
    private List<Item> items;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;

    @Data
    public static class Item {
        @JsonProperty("album_group")
        private String albumGroup;

        @JsonProperty("album_type")
        private String albumType;

        private List<ArtistProfileResponseModel> artists;

        @JsonProperty("available_markets")
        private List<String> availableMarkets;

        @JsonProperty("external_urls")
        private ApiCommonsResponseModel.ExternalUrls externalUrls;

        private String href;
        private String id;
        private List<ApiCommonsResponseModel.Images> images;

        @JsonProperty("is_playable")
        private Boolean isPlayable;

        private String name;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("release_date_precision")
        private String releaseDatePrecision;

        @JsonProperty("total_tracks")
        private Integer totalTracks;

        private String type;
        private String uri;
    }
}
