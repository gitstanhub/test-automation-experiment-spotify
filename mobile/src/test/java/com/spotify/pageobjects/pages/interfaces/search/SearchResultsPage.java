package com.spotify.pageobjects.pages.interfaces.search;

public interface SearchResultsPage {

    public SearchResultsPage searchGloballyFor(String searchQuery);

    public SearchResultsPage tapArtistsFilterButton();

    public SearchResultsPage tapAlbumFilterButton();

    public SearchResultsPage verifySearchResultIsAvailable(String expectedSearchResult);
}
