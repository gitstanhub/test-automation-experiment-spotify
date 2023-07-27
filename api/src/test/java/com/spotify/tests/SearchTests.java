package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.SearchClient;
import com.spotify.testdata.search.assertions.SearchResultsAssertionData;
import com.spotify.testdata.search.constants.SearchTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.tests.base.ApiTests;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.requestdata.search.SearchRequestDataUtil;

import com.spotify.utils.responsedata.search.SearchResponseDataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.spotify.testdata.artist.constants.ArtistEntities.CAPITAL_BRA;

public class SearchTests extends ApiTests {

    @Autowired
    SearchClient searchClient;

    @Test
    void artistsAndAlbumsCanBeFound() {
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

        SearchResponseModel searchResults = searchClient.searchWithLimitAndOffset(searchRequestDataUtil.getSearchQuery(searchRequest),
                searchRequestDataUtil.getSearchTypes(searchRequest), desiredLimit, desiredOffset);

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults = SearchResultsAssertionData.ActualSearchResultsData
                .builder()
                .actualArtistsPaginationData(new SearchResultsAssertionData.PaginationData(
                        searchResponseDataUtil.getPaginationDataLimit(searchResults, "artists"),
                        searchResponseDataUtil.getPaginationDataOffset(searchResults, "artists")))
                .actualArtistsTypes(
                        searchResponseDataUtil.getAllArtistsTypes(searchResults))
                .actualArtistsItemsSize(
                        searchResponseDataUtil.getItemsCount(searchResults, "artists"))
                .actualAlbumsPaginationData(new SearchResultsAssertionData.PaginationData(
                        searchResponseDataUtil.getPaginationDataLimit(searchResults, "albums"),
                        searchResponseDataUtil.getPaginationDataOffset(searchResults, "albums")))
                .actualAlbumsTypes(
                        searchResponseDataUtil.getAllAlbumsTypes(searchResults))
                .actualAlbumsArtistsNames(
                        searchResponseDataUtil.getAllAlbumsArtistsNames(searchResults))
                .actualAlbumsItemsSize(
                        searchResponseDataUtil.getItemsCount(searchResults, "albums"))
                .build();

        apiAssertionsUtil
                .assertFieldEqualsTo(actualSearchResults.getActualArtistsPaginationData().getLimit(), desiredLimit)
                .assertFieldEqualsTo(actualSearchResults.getActualArtistsPaginationData().getOffset(), desiredOffset)
                .assertFieldEqualsTo(actualSearchResults.getActualAlbumsPaginationData().getLimit(), desiredLimit)
                .assertFieldEqualsTo(actualSearchResults.getActualAlbumsPaginationData().getOffset(), desiredOffset);

        apiAssertionsUtil
                .assertFieldEqualsTo(actualSearchResults.getActualArtistsItemsSize(), desiredLimit)
                .assertFieldEqualsTo(actualSearchResults.getActualAlbumsItemsSize(), desiredLimit);

        apiAssertionsUtil
                .assertAllFieldsContainExpectedText(actualSearchResults.getActualArtistsTypes(), "artist")
                .assertAnyFieldContainsExpectedText(actualSearchResults.getActualAlbumsArtistsNames(), CAPITAL_BRA.getArtistName())
                .assertAnyFieldContainsExpectedText(actualSearchResults.getActualAlbumsTypes(), "album");
    }

    @Test
    void playlistsCanBeFoundByCountry() {
        SearchTypes[] searchTypes = new SearchTypes[]{
                SearchTypes.PLAYLIST
        };

        String countryCode = String.valueOf(CountryCode.DE);

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery("Capital Bra")
                .specifiedSearchTypes(searchTypes)
                .desiredMarket(countryCode)
                .build();

        SearchResponseModel searchResults = searchClient.searchWithMarket(searchRequestDataUtil.getSearchQuery(searchRequest),
                searchRequestDataUtil.getSearchTypes(searchRequest), searchRequestDataUtil.getSearchMarket(searchRequest));

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults = SearchResultsAssertionData.ActualSearchResultsData
                .builder()
                .actualPlaylistsPaginationData(new SearchResultsAssertionData.PaginationData(
                        searchResponseDataUtil.getPaginationDataLimit(searchResults, "playlists"),
                        searchResponseDataUtil.getPaginationDataOffset(searchResults, "playlists")))
                .actualPlaylistsTypes(
                        searchResponseDataUtil.getAllPlaylistsTypes(searchResults))
                .actualPlaylistsItemsSize(
                        searchResponseDataUtil.getItemsCount(searchResults, "playlists"))
                .build();

        apiAssertionsUtil
                .assertFieldEqualsTo(actualSearchResults.getActualPlaylistsPaginationData().getLimit(), 20)
                .assertFieldEqualsTo(actualSearchResults.getActualPlaylistsPaginationData().getOffset(), 0);

        apiAssertionsUtil.assertAllFieldsContainExpectedText(actualSearchResults.getActualPlaylistsTypes(), "playlist");

        apiAssertionsUtil.assertFieldEqualsTo(actualSearchResults.getActualPlaylistsItemsSize(), 20);
    }

    @Test
    void searchWithoutRequiredParamsReturnsNoResults() {
        SearchResponseModel searchResults = searchClient.search(null, null);

        apiAssertionsUtil.assertFieldEqualsTo(
                searchResults.getError().getMessage(), "No search query");
    }
}
