package com.spotify.api.tests;

import com.spotify.api.clients.SearchClient;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SearchTests {

    SearchClient searchClient = new SearchClient();

    @Test
    void searchTest() {
        List<String> types = Arrays.asList("album");

        searchClient.search("Capital Bra", types);
    }

/// add test for regular album search
// add test for audiobook + ES country
// add test for 400 code when params are empty

}
