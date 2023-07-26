package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.SearchClient;
import com.spotify.testdata.search.assertions.SearchResultsAssertionData;
import com.spotify.testdata.search.constants.SearchTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.requestdata.search.SearchRequestDataUtil;

import com.spotify.utils.responsedata.search.SearchResponseDataUtil;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.artist.constants.ArtistEntities.CAPITAL_BRA;

public class SearchTests {
    SearchClient searchClient = new SearchClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    SearchRequestDataUtil searchRequestDataUtil = new SearchRequestDataUtil();
    SearchResponseDataUtil searchResponseDataUtil = new SearchResponseDataUtil();

    @Test
    void artistsAndAlbumsAreFound() {
        SearchTypes[] searchTypes = new SearchTypes[]{
                SearchTypes.ALBUM,
                SearchTypes.ARTIST
        };

        int desiredLimit = 5;
        int desiredOffset = 0;

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery("Capital Bra")
                .specifiedSearchTypes(searchTypes)
                .build();

        SearchResponseModel searchResults = searchClient.searchWithLimitOffset(
                searchRequestDataUtil.getSearchQuery(searchRequest),
                searchRequestDataUtil.getSearchTypes(searchRequest),
                desiredLimit, desiredOffset
        );

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults =
                SearchResultsAssertionData.ActualSearchResultsData.builder()
                        .actualArtistsPaginationData(
                                new SearchResultsAssertionData.PaginationData(
                                        searchResponseDataUtil.getPaginationDataLimit(searchResults, "artists"),
                                        searchResponseDataUtil.getPaginationDataOffset(searchResults, "artists")
                                )
                        )
                        .actualArtistsTypes(searchResponseDataUtil.getAllArtistsTypes(searchResults))
                        .actualArtistsItemsSize(searchResponseDataUtil.getItemsCount(searchResults, "artists"))

                        .actualAlbumsPaginationData(
                                new SearchResultsAssertionData.PaginationData(
                                        searchResponseDataUtil.getPaginationDataLimit(searchResults, "albums"),
                                        searchResponseDataUtil.getPaginationDataOffset(searchResults, "albums")
                                )
                        )
                        .actualAlbumsTypes(searchResponseDataUtil.getAllAlbumsTypes(searchResults))
                        .actualAlbumsArtistsNames(searchResponseDataUtil.getAllAlbumsArtistsNames(searchResults))
                        .actualAlbumsItemsSize(searchResponseDataUtil.getItemsCount(searchResults, "albums"))
                        .build();

        apiAssertionsUtil
                .verifyResponseSingleField(actualSearchResults.getActualArtistsPaginationData().getLimit(), desiredLimit)
                .verifyResponseSingleField(actualSearchResults.getActualArtistsPaginationData().getOffset(), desiredOffset)
                .verifyResponseSingleField(actualSearchResults.getActualAlbumsPaginationData().getLimit(), desiredLimit)
                .verifyResponseSingleField(actualSearchResults.getActualArtistsPaginationData().getOffset(), desiredOffset);

        apiAssertionsUtil
                .verifyResponseSingleField(actualSearchResults.getActualArtistsItemsSize(), desiredLimit)
                .verifyResponseSingleField(actualSearchResults.getActualAlbumsItemsSize(), desiredLimit);

        apiAssertionsUtil
                .verifyEachResponseFieldContains(actualSearchResults.getActualArtistsTypes(), "artist")
                .verifySomeResponseFieldsContain(actualSearchResults.getActualAlbumsArtistsNames(), CAPITAL_BRA.getArtistName())
                .verifySomeResponseFieldsContain(actualSearchResults.getActualAlbumsTypes(), "album");
    }

    @Test
    void playlistsByCountryAreFound() {
        SearchTypes[] searchTypes = new SearchTypes[]{
                SearchTypes.PLAYLIST
        };

        String countryCode = String.valueOf(CountryCode.DE);

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery("Capital Bra")
                .specifiedSearchTypes(searchTypes)
                .desiredMarket(countryCode)
                .build();

        SearchResponseModel searchResults = searchClient.searchWithMarket(
                searchRequestDataUtil.getSearchQuery(searchRequest),
                searchRequestDataUtil.getSearchTypes(searchRequest),
                searchRequestDataUtil.getSearchMarket(searchRequest)
        );

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults = SearchResultsAssertionData.ActualSearchResultsData.builder()
                .actualPlaylistsPaginationData(
                        new SearchResultsAssertionData.PaginationData(
                                searchResponseDataUtil.getPaginationDataLimit(searchResults, "playlists"),
                                searchResponseDataUtil.getPaginationDataOffset(searchResults, "playlists")
                        )
                )
                .actualPlaylistsTypes(searchResponseDataUtil.getAllPlaylistsTypes(searchResults))
                .actualPlaylistsItemsSize(searchResponseDataUtil.getItemsCount(searchResults, "playlists"))
                .build();

        apiAssertionsUtil.verifyResponseSingleField(actualSearchResults.getActualPlaylistsPaginationData().getLimit(), 20)
                .verifyResponseSingleField(actualSearchResults.getActualPlaylistsPaginationData().getOffset(), 0);

        apiAssertionsUtil.verifyEachResponseFieldContains(actualSearchResults.getActualPlaylistsTypes(), "playlist");

        apiAssertionsUtil.verifyResponseSingleField(actualSearchResults.getActualPlaylistsItemsSize(), 20);
    }

    @Test
    void searchWithoutRequiredParamsIsNotPossible() {

        SearchResponseModel searchResults = searchClient
                .search(null, null);

        apiAssertionsUtil.verifyResponseSingleField(
                searchResults.getError().getMessage(), "No search query"
        );
    }
}
