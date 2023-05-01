package com.spotify.api.models.artist;

import com.spotify.api.models.commons.ArtistCommonsResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class ArtistTopTracksResponseModel {

    private List<Track> tracks;

    @Data
    public static class Track {
        private Album album;
        private List<ArtistDataResponseModel> artists;
        private Integer disc_number;
        private Integer duration_ms;
        private Boolean explicit;
        private ExternalIds external_ids;
        private ArtistCommonsResponseModel.ExternalUrls external_urls;
        private String href;
        private String id;
        private Boolean is_local;
        private Boolean is_playable;
        private String name;
        private Integer popularity;
        private String preview_url;
        private Integer track_number;
        private String type;
        private String uri;
    }

    @Data
    public static class Album {
        private String album_group;
        private String album_type;
        private List<ArtistDataResponseModel> artists;
        private ArtistCommonsResponseModel.ExternalUrls external_urls;
        private String href;
        private String id;
        private List<ArtistCommonsResponseModel.Images> images;
        private Boolean is_playable;
        private String name;
        private String release_date;
        private String release_date_precision;
        private Integer total_tracks;
        private String type;
        private String uri;
    }

    @Data
    public static class ExternalIds {
        private String isrc;
    }
}
