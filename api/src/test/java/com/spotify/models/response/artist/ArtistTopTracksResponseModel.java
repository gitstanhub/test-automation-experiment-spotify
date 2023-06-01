package com.spotify.models.response.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.models.response.commons.ApiCommonsResponseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class ArtistTopTracksResponseModel {

    private List<Track> tracks;

    @Data
    public static class Track {
        private Album album;
        private List<ArtistProfileResponseModel> artists;

        @JsonProperty("disc_number")
        private Integer discNumber;

        @JsonProperty("duration_ms")
        private Integer durationMs;

        private Boolean explicit;

        @JsonProperty("external_ids")
        private ExternalIds externalIds;

        @JsonProperty("external_urls")
        private ApiCommonsResponseModel.ExternalUrls externalUrls;

        private String href;
        private String id;

        @JsonProperty("is_local")
        private Boolean isLocal;

        @JsonProperty("is_playable")
        private Boolean isPlayable;

        private String name;
        private Integer popularity;

        @JsonProperty("preview_url")
        private String previewUrls;

        @JsonProperty("track_number")
        private Integer trackNumber;

        private String type;
        private String uri;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class Album extends ArtistAlbumsResponseModel.Item{
        @JsonProperty("is_playable")
        private Boolean isPlayable;
    }

    @Data
    public static class ExternalIds {
        private String isrc;
    }
}
