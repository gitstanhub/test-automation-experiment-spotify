package com.spotify.utils.requestdata.search;

import com.spotify.models.request.search.SearchRequestModel;

import java.util.List;

public class SearchRequestDataUtil {

    public String getSearchQuery(SearchRequestModel searchRequest) {
        return searchRequest.getQ();
    }
    public List<String> getSearchTypes(SearchRequestModel searchRequest) {
        return searchRequest.getType();
    }

    public String getSearchMarket(SearchRequestModel searchRequest) {
        return searchRequest.getMarket();
    }
}
