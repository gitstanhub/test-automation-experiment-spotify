package com.spotify.api.models.response.search;

import com.spotify.api.models.response.artist.ArtistAlbumsResponseModel;
import com.spotify.api.models.response.artist.ArtistDataResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponseModel {

    private ArtistAlbumsResponseModel albums;
    private Artists artists;

    @Data
    private static class Artists {

        private String href;
        private List<ArtistDataResponseModel> items;
        private Integer limit;
        private String next;
        private Integer offset;
        private String previous;
        private Integer total;
    }
}
