package com.spotify.api.models.response.search;

import com.spotify.api.models.response.artist.ArtistAlbumsResponseModel;
import com.spotify.api.models.response.artist.ArtistDataResponseModel;
import com.spotify.api.models.response.commons.ApiCommonsResponseModel;
import com.spotify.api.models.response.playlist.PlaylistResponseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class SearchResponseModel {

    private ArtistAlbumsResponseModel albums;
    private Artists artists;
    private Playlists playlists;

    private ApiCommonsResponseModel.Error error;

    @Data
    public static class SearchResponsePaginationBase {
        private String href;
        private Integer limit;
        private String next;
        private Integer offset;
        private String previous;
        private Integer total;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Artists extends SearchResponsePaginationBase {
        private List<ArtistDataResponseModel> items;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Playlists extends SearchResponsePaginationBase {
        private List<PlaylistResponseModel> items;
    }
}
