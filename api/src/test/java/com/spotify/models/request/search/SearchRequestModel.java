package com.spotify.models.request.search;

import com.spotify.testdata.search.constants.SearchRequestTypes;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SearchRequestModel {
    private String q;
    private List<String> type;
    private String market;
    private Integer limit;
    private Integer offset;
    private String includeExternal;

    @Builder
    public SearchRequestModel(String searchQuery, String desiredMarket, Integer desiredLimit, Integer desiredOffset, String desiredIncludeExternal, SearchRequestTypes... specifiedSearchRequestTypes) {
        this.q = searchQuery;
        this.type = Arrays.stream(specifiedSearchRequestTypes)
                .map(SearchRequestTypes::getValue)
                .collect(Collectors.toList());
        this.market = desiredMarket;
        this.limit = desiredLimit;
        this.offset = desiredOffset;
        this.includeExternal = desiredIncludeExternal;
    }
}
