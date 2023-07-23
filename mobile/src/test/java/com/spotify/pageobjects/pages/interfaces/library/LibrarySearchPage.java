package com.spotify.pageobjects.pages.interfaces.library;

public interface LibrarySearchPage {

    public LibrarySearchPage searchLibraryFor(String searchQuery);

    public LibrarySearchPage verifySearchResultIsAvailable(String expectedSearchResult, String searchResultType);
}
