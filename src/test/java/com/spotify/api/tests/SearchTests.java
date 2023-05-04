package com.spotify.api.tests;

import com.spotify.api.clients.SearchClient;
import org.junit.jupiter.api.Test;

public class SearchTests {

    SearchClient searchClient = new SearchClient();

    @Test
    void searchTest() {
        searchClient.search();
    }

/// add test for regular album search
// add test for audiobook + ES country
// add test for 400 code when params are empty

}
