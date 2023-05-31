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
        private PaginationData actualAlbumsPaginationData;
        private List<String> actualAlbumsTypes;
        private List<String> actualAlbumsArtists;

        //Artists
        private PaginationData actualArtistsPaginationData;
        private List<String> actualArtistsTypes;

        //Playlists
        private PaginationData actualPlaylistsPaginationData;
        private List<String> actualPlaylistsTypes;

        @Override
        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            Stream.of(
                            getActualAlbumsPaginationData().getLimit(),
                            getActualAlbumsPaginationData().getOffset(),
                            getActualAlbumsTypes(),
                            getActualAlbumsArtists(),
                            getActualArtistsPaginationData().getLimit(),
                            getActualArtistsPaginationData().getOffset(),
                            getActualArtistsTypes(),
                            getActualPlaylistsPaginationData().getLimit(),
                            getActualPlaylistsPaginationData().getOffset(),
                            getActualPlaylistsTypes()
                    )
                    .filter(Objects::nonNull)
                    .forEach(actualFieldList::add);
            return actualFieldList;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Builder
    public static class ExpectedSearchResultsData extends ExpectedAssertionData {

        //Album
        private PaginationData expectedAlbumsPaginationData;
        private List<String> expectedAlbumsTypes;
        private List<String> expectedAlbumsArtists;

        //Artists
        private PaginationData expectedArtistsPaginationData;
        private List<String> expectedArtistsTypes;

        //Playlists
        private PaginationData expectedPlaylistsPaginationData;
        private List<String> expectedPlaylistsTypes;

        @Override
        public List<Object> toList() {
            List<Object> actualFieldList = new ArrayList<>();
            Stream.of(
                            getExpectedAlbumsPaginationData().getLimit(),
                            getExpectedAlbumsPaginationData().getOffset(),
                            getExpectedAlbumsTypes(),
                            getExpectedAlbumsArtists(),
                            getExpectedArtistsPaginationData().getLimit(),
                            getExpectedArtistsPaginationData().getOffset(),
                            getExpectedArtistsTypes(),
                            getExpectedPlaylistsPaginationData().getLimit(),
                            getExpectedPlaylistsPaginationData().getOffset(),
                            getExpectedPlaylistsTypes()
                    )
                    .filter(Objects::nonNull)
                    .forEach(actualFieldList::add);
            return actualFieldList;
        }
    }
}
