package com.spotify.testdata.search.assertions;

import com.spotify.testdata.commons.AssertionData;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class SearchResultsAssertionData extends AssertionData {

    @Data
    public static class PaginationData {
        private Integer limit;
        private Integer offset;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Builder
    public static class ActualSearchResultsData extends ActualAssertionData {

        //Albums
        private PaginationData albumsPaginationData;
        private List<String> albumsTypes;
        private List<String> albumsArtists;

        //Artists
        private PaginationData artistsPaginationData;
        private List<String> artistsTypes;

        //Playlists
        private PaginationData playlistsPaginationData;
        private List<String> playlistsTypes;

        @Override
        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            Stream.of(
                            getAlbumsPaginationData().getLimit(),
                            getAlbumsPaginationData().getOffset(),
                            getAlbumsTypes(),
                            getAlbumsArtists(),
                            getArtistsPaginationData().getLimit(),
                            getArtistsPaginationData().getOffset(),
                            getArtistsTypes(),
                            getPlaylistsPaginationData().getLimit(),
                            getPlaylistsPaginationData().getOffset(),
                            getPlaylistsTypes()
                    )
                    .filter(Objects::nonNull)
                    .forEach(actualFieldList::add);
            return actualFieldList;
        }
    }


}
