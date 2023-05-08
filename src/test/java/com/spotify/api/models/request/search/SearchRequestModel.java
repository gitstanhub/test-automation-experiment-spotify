package com.spotify.api.models.request.search;

import com.spotify.api.constants.search.SearchTypes;
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
