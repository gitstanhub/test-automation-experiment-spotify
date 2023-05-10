package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.SearchClient;
import com.spotify.constants.artist.ArtistProfileConstants;
import com.spotify.constants.search.SearchTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.utils.ApiAssertionsUtil;
import org.junit.jupiter.api.Test;

public class SearchTests {

    SearchClient searchClient = new SearchClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();

    @Test
    void searchAlbumsTest() {

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                SearchTypes.ALBUM,
                SearchTypes.ARTIST
        );

        SearchResponseModel searchResults = searchClient
                .searchWithLimitOffset("Capital Bra", searchRequestModel.getSearchTypes(), 5, 0);

        apiAssertionsUtil.verifyResponseSingleField(
                searchResults.getAlbums().getItems().get(0).getArtists().get(0).getName(),
                ArtistProfileConstants.ARTIST_NAME_SINGLE_PROFILE
        );
    }

    @Test
    void searchPlaylistByCountryTest() {

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                SearchTypes.PLAYLIST
        );

        String countryCode = String.valueOf(CountryCode.getByCode("DE"));

        SearchResponseModel searchResults = searchClient
                .searchWithMarket("Capital Bra", searchRequestModel.getSearchTypes(), countryCode);

        apiAssertionsUtil.verifyResponseSingleField(
                searchResults.getPlaylists().getItems().get(0).getName(),
                "CAPITAL BRA - KEIN PLATZ"
        );
    }

    @Test
    void searchEmptyParamsTest() {

        SearchResponseModel searchResults = searchClient
                .search(null, null);

        apiAssertionsUtil.verifyResponseSingleField(
                searchResults.getError().getMessage(), "No search query"
        );
    }
}
