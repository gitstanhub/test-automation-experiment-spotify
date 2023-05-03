package com.spotify.api.models.response.artist;

import com.spotify.api.models.response.commons.ArtistCommonsResponseModel;
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
        private String album_group;
        private String album_type;
        private List<ArtistDataResponseModel> artists;
        private ArtistCommonsResponseModel.ExternalUrls external_urls;
        private String href;
        private String id;
        private List<ArtistCommonsResponseModel.Images> images;
        private String name;
        private String release_date;
        private String release_date_precision;
        private Integer total_tracks;
        private String type;
        private String uri;
    }
}
