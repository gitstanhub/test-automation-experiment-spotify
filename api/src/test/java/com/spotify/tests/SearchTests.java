package com.spotify.tests;

import com.spotify.clients.SearchClient;
import com.spotify.testdata.search.constants.SearchTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.requestfields.search.SearchRequestFieldsUtil;
import org.junit.jupiter.api.Test;

public class SearchTests {

    SearchClient searchClient = new SearchClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    SearchRequestFieldsUtil searchRequestFieldsUtil = new SearchRequestFieldsUtil();

    @Test
    void searchForArtistsAndAlbumsTest() {
        SearchTypes[] searchTypes = new SearchTypes[]{
                SearchTypes.ALBUM,
                SearchTypes.ARTIST
        };

        SearchRequestModel searchRequest = new SearchRequestModel(
                "Capital Bra",
                searchTypes
        );

        SearchResponseModel searchResults = searchClient.searchWithLimitOffset(
                searchRequestFieldsUtil.getSearchQuery(searchRequest),
                searchRequestFieldsUtil.getSearchTypes(searchRequest),
                5, 0
        );

        //write assertion
    }

    @Test
    void searchForPlaylistsByCountryTest() {

//        SearchRequestModel searchRequestModel = new SearchRequestModel(
//                SearchTypes.PLAYLIST
//        );
//
//        String countryCode = String.valueOf(CountryCode.getByCode("DE"));
//
//        SearchResponseModel searchResults = searchClient
//                .searchWithMarket("Capital Bra", searchRequestModel.getSearchTypes(), countryCode);
//
//        apiAssertionsUtil.verifyResponseSingleField(
//                searchResults.getPlaylists().getItems().get(0).getName(),
//                "CAPITAL BRA - KEIN PLATZ"
//        );
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
