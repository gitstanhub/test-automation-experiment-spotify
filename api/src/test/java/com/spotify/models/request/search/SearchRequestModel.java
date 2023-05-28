package com.spotify.models.request.search;

import com.spotify.testdata.search.constants.SearchTypes;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SearchRequestModel {
    private String q;
    private List<String> type;

    public SearchRequestModel(String searchQuery, SearchTypes... specifiedSearchTypes) {
        this.q = searchQuery;
        this.type = Arrays.stream(specifiedSearchTypes)
                .map(SearchTypes::getValue)
                .collect(Collectors.toList());
    }
}
