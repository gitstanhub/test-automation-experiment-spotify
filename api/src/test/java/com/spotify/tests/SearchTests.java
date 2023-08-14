package com.spotify.tests;

import com.spotify.clients.SearchClient;
import com.spotify.config.ConfigProviderApi;
import com.spotify.testdata.search.assertions.SearchResultsAssertionData;
import com.spotify.testdata.search.constants.SearchRequestTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.tests.base.ApiTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.spotify.testdata.artists.constants.Artists.ARTIST_1;
import static com.spotify.testdata.search.constants.SearchResultsTypes.*;

public class SearchTests extends ApiTests {

    @Autowired
    SearchClient searchClient;

    @Test
    void artistsAndAlbumsCanBeFound() {

        SearchRequestTypes[] searchRequestTypes = new SearchRequestTypes[]{
                SearchRequestTypes.ALBUM,
                SearchRequestTypes.ARTIST
        };

        int desiredLimit = 5;
        int desiredOffset = 0;

        String expectedArtistName = ARTIST_1.getArtistName();
        String expectedArtistType = SearchRequestTypes.ARTIST.getValue();
        String expectedAlbumType = SearchRequestTypes.ALBUM.getValue();

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery(expectedArtistName)
                .specifiedSearchRequestTypes(searchRequestTypes)
                .build();

        SearchResponseModel searchResults = searchClient.searchWithLimitAndOffset(
                searchRequestDataUtil.getSearchQueryFrom(searchRequest),
                searchRequestDataUtil.getSearchTypesFrom(searchRequest),
                desiredLimit, desiredOffset
        );

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults = SearchResultsAssertionData.ActualSearchResultsData
                .builder()
                .actualArtistsPaginationData(new SearchResultsAssertionData.PaginationData(
                        searchResponseDataUtil.getPaginationDataLimitFrom(searchResults, ARTISTS_SEARCH_RESULTS_TYPE),
                        searchResponseDataUtil.getPaginationDataOffsetFrom(searchResults, ARTISTS_SEARCH_RESULTS_TYPE)))
                .actualArtistsTypes(
                        searchResponseDataUtil.getAllArtistsTypesFrom(searchResults))
                .actualArtistsItemsSize(
                        searchResponseDataUtil.getItemsCountFrom(searchResults, ARTISTS_SEARCH_RESULTS_TYPE))
                .actualAlbumsPaginationData(new SearchResultsAssertionData.PaginationData(
                        searchResponseDataUtil.getPaginationDataLimitFrom(searchResults, ALBUM_SEARCH_RESULTS_TYPE),
                        searchResponseDataUtil.getPaginationDataOffsetFrom(searchResults, ALBUM_SEARCH_RESULTS_TYPE)))
                .actualAlbumsTypes(
                        searchResponseDataUtil.getAllAlbumsTypesFrom(searchResults))
                .actualAlbumsArtistsNames(
                        searchResponseDataUtil.getAllAlbumsArtistsNamesFrom(searchResults))
                .actualAlbumsItemsSize(
                        searchResponseDataUtil.getItemsCountFrom(searchResults, ALBUM_SEARCH_RESULTS_TYPE))
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
                .assertAllFieldsContainExpectedText(actualSearchResults.getActualArtistsTypes(), expectedArtistType)
                .assertAnyFieldContainsExpectedText(actualSearchResults.getActualAlbumsArtistsNames(), expectedArtistName)
                .assertAnyFieldContainsExpectedText(actualSearchResults.getActualAlbumsTypes(), expectedAlbumType);
    }

    @Test
    void playlistsCanBeFoundByCountry() {

        SearchRequestTypes[] searchRequestTypes = new SearchRequestTypes[]{
                SearchRequestTypes.PLAYLIST
        };

        String expectedArtistName = ARTIST_1.getArtistName();
        String expectedPlaylistType = SearchRequestTypes.PLAYLIST.getValue();
        String marketCode = ConfigProviderApi.getRestAssuredApiConfiguration().marketCode();

        int desiredLimit = 20;
        int desiredOffset = 0;

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery(expectedArtistName)
                .specifiedSearchRequestTypes(searchRequestTypes)
                .desiredMarket(marketCode)
                .build();

        SearchResponseModel searchResults = searchClient.searchWithMarket(
                searchRequestDataUtil.getSearchQueryFrom(searchRequest),
                searchRequestDataUtil.getSearchTypesFrom(searchRequest),
                searchRequestDataUtil.getSearchMarketFrom(searchRequest)
        );

        SearchResultsAssertionData.ActualSearchResultsData actualSearchResults = SearchResultsAssertionData.ActualSearchResultsData
                .builder()
                .actualPlaylistsPaginationData(new SearchResultsAssertionData.PaginationData(
                        searchResponseDataUtil.getPaginationDataLimitFrom(searchResults, PLAYLISTS_SEARCH_RESULTS_TYPE),
                        searchResponseDataUtil.getPaginationDataOffsetFrom(searchResults, PLAYLISTS_SEARCH_RESULTS_TYPE)))
                .actualPlaylistsTypes(
                        searchResponseDataUtil.getAllPlaylistsTypesFrom(searchResults))
                .actualPlaylistsItemsSize(
                        searchResponseDataUtil.getItemsCountFrom(searchResults, PLAYLISTS_SEARCH_RESULTS_TYPE))
                .build();

        apiAssertionsUtil
                .assertFieldEqualsTo(actualSearchResults.getActualPlaylistsPaginationData().getLimit(), desiredLimit)
                .assertFieldEqualsTo(actualSearchResults.getActualPlaylistsPaginationData().getOffset(), desiredOffset);

        apiAssertionsUtil.assertAllFieldsContainExpectedText(actualSearchResults.getActualPlaylistsTypes(), expectedPlaylistType);

        apiAssertionsUtil.assertFieldEqualsTo(actualSearchResults.getActualPlaylistsItemsSize(), desiredLimit);
    }

    @Test
    void searchWithoutRequiredParamsReturnsNoResults() {

        String expectedErrorMessage = "No search query";

        SearchResponseModel searchResults = searchClient.search(null, null);

        apiAssertionsUtil.assertFieldEqualsTo(
                searchResults.getError().getMessage(), expectedErrorMessage);
    }
}
