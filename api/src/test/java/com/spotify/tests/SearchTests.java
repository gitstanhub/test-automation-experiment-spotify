package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.SearchClient;
import com.spotify.testdata.search.assertions.SearchResultsAssertionData;
import com.spotify.testdata.search.constants.SearchTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.requestfields.search.SearchRequestFieldsUtil;

import com.spotify.utils.responsefields.search.SearchResponseFieldsUtil;
import org.junit.jupiter.api.Test;

import static com.spotify.testdata.artist.constants.ArtistEntities.CAPITAL_BRA;

public class SearchTests {
    //TODO: Move client initialisation under @BeforeAll
    SearchClient searchClient = new SearchClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    SearchRequestFieldsUtil searchRequestFieldsUtil = new SearchRequestFieldsUtil();
    SearchResponseFieldsUtil searchResponseFieldsUtil = new SearchResponseFieldsUtil();

    @Test
    void searchForArtistsAndAlbumsTest() {
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
                searchRequestFieldsUtil.getSearchQuery(searchRequest),
                searchRequestFieldsUtil.getSearchTypes(searchRequest),
                desiredLimit, desiredOffset
        );

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults =
                SearchResultsAssertionData.ActualSearchResultsData.builder()
                        .actualArtistsPaginationData(
                                new SearchResultsAssertionData.PaginationData(
                                        searchResponseFieldsUtil.getPaginationDataLimit(searchResults, "artists"),
                                        searchResponseFieldsUtil.getPaginationDataOffset(searchResults, "artists")
                                )
                        )
                        .actualArtistsTypes(searchResponseFieldsUtil.getAllArtistsTypes(searchResults))
                        .actualArtistsItemsSize(searchResponseFieldsUtil.getItemsCount(searchResults, "artists"))

                        .actualAlbumsPaginationData(
                                new SearchResultsAssertionData.PaginationData(
                                        searchResponseFieldsUtil.getPaginationDataLimit(searchResults, "albums"),
                                        searchResponseFieldsUtil.getPaginationDataOffset(searchResults, "albums")
                                )
                        )
                        .actualAlbumsTypes(searchResponseFieldsUtil.getAllAlbumsTypes(searchResults))
                        .actualAlbumsArtistsNames(searchResponseFieldsUtil.getAllAlbumsArtistsNames(searchResults))
                        .actualAlbumsItemsSize(searchResponseFieldsUtil.getItemsCount(searchResults, "albums"))
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
    void searchForPlaylistsByCountryTest() {
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
                searchRequestFieldsUtil.getSearchQuery(searchRequest),
                searchRequestFieldsUtil.getSearchTypes(searchRequest),
                searchRequestFieldsUtil.getSearchMarket(searchRequest)
        );

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults = SearchResultsAssertionData.ActualSearchResultsData.builder()
                .actualPlaylistsPaginationData(
                        new SearchResultsAssertionData.PaginationData(
                                searchResponseFieldsUtil.getPaginationDataLimit(searchResults, "playlists"),
                                searchResponseFieldsUtil.getPaginationDataOffset(searchResults, "playlists")
                        )
                )
                .actualPlaylistsTypes(searchResponseFieldsUtil.getAllPlaylistsTypes(searchResults))
                .actualPlaylistsItemsSize(searchResponseFieldsUtil.getItemsCount(searchResults, "playlists"))
                .build();

                apiAssertionsUtil.verifyResponseSingleField(actualSearchResults.getActualPlaylistsPaginationData().getLimit(), 20)
                        .verifyResponseSingleField(actualSearchResults.getActualPlaylistsPaginationData().getOffset(), 0);

                apiAssertionsUtil.verifyEachResponseFieldContains(actualSearchResults.getActualPlaylistsTypes(), "playlist");

                apiAssertionsUtil.verifyResponseSingleField(actualSearchResults.getActualPlaylistsItemsSize(), 20);
    }

    @Test
    void searchWithoutRequiredParamsTest() {

        SearchResponseModel searchResults = searchClient
                .search(null, null);

        apiAssertionsUtil.verifyResponseSingleField(
                searchResults.getError().getMessage(), "No search query"
        );
    }
}
