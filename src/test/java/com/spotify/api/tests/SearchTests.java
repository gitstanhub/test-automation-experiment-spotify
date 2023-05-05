package com.spotify.api.tests;

import com.spotify.api.clients.SearchClient;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchTests {

    SearchClient searchClient = new SearchClient();

    @Test
    void searchTest() {
        List<String> types = Arrays.asList("album");
        Optional<String> marketEmpty = null;
        Optional<Integer> limitEmpty = null;
        Optional<Integer> offsetEmpty = null;
        Optional<String> includeExternalEmpty = null;

        searchClient.search("Capital Bra", types, marketEmpty, limitEmpty, offsetEmpty, includeExternalEmpty);
    }

/// add test for regular album search
// add test for audiobook + ES country
// add test for 400 code when params are empty

}
