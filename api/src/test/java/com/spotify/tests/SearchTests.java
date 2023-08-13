package com.spotify.tests;

import com.spotify.clients.SearchClient;
import com.spotify.config.ConfigProviderApi;
import com.spotify.testdata.search.assertions.SearchResultsAssertionData;
import com.spotify.testdata.search.constants.SearchTypes;
import com.spotify.models.request.search.SearchRequestModel;
import com.spotify.models.response.search.SearchResponseModel;
import com.spotify.tests.base.ApiTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.spotify.testdata.artist.constants.ArtistEntities.ARTIST_1;
import static com.spotify.testdata.artist.constants.SearchResultsTypes.*;

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

        String expectedArtistName = ARTIST_1.getArtistName();
        String expectedArtistType = SearchTypes.ARTIST.getValue();
        String expectedAlbumType = SearchTypes.ALBUM.getValue();

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery(expectedArtistName)
                .specifiedSearchTypes(searchTypes)
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

        SearchTypes[] searchTypes = new SearchTypes[]{
                SearchTypes.PLAYLIST
        };

        String expectedArtistName = ARTIST_1.getArtistName();
        String expectedPlaylistType = SearchTypes.PLAYLIST.getValue();
        String marketCode = ConfigProviderApi.getRestAssuredApiConfiguration().marketCode();

        SearchRequestModel searchRequest = SearchRequestModel.builder()
                .searchQuery(expectedArtistName)
                .specifiedSearchTypes(searchTypes)
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
                .assertFieldEqualsTo(actualSearchResults.getActualPlaylistsPaginationData().getLimit(), 20)
                .assertFieldEqualsTo(actualSearchResults.getActualPlaylistsPaginationData().getOffset(), 0);

        apiAssertionsUtil.assertAllFieldsContainExpectedText(actualSearchResults.getActualPlaylistsTypes(), expectedPlaylistType);

        apiAssertionsUtil.assertFieldEqualsTo(actualSearchResults.getActualPlaylistsItemsSize(), 20);
    }

    @Test
    void searchWithoutRequiredParamsReturnsNoResults() {

        SearchResponseModel searchResults = searchClient.search(null, null);

        apiAssertionsUtil.assertFieldEqualsTo(
                searchResults.getError().getMessage(), "No search query");
    }
}
