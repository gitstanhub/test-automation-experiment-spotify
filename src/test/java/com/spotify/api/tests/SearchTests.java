package com.spotify.api.tests;

import com.spotify.api.clients.SearchClient;
import com.spotify.api.constants.artist.ArtistProfileConstants;
import com.spotify.api.constants.search.SearchTypes;
import com.spotify.api.models.request.search.SearchRequestModel;
import com.spotify.api.models.response.search.SearchResponseModel;
import com.spotify.api.utils.ApiAssertionsUtil;
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

    }

    @Test
    void searchEmptyParamsTest() {

    }

}
