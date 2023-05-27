package com.spotify.models.request.search;

import com.spotify.testdata.search.constants.SearchTypes;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SearchRequestModel {

    private List<String> searchTypes;

    public SearchRequestModel(SearchTypes... specifiedSearchTypes) {
        this.searchTypes = Arrays.stream(specifiedSearchTypes)
                .map(SearchTypes::getValue)
                .collect(Collectors.toList());
    }
}
