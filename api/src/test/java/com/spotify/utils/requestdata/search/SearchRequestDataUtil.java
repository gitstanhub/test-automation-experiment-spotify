package com.spotify.utils.requestdata.search;

import com.spotify.models.request.search.SearchRequestModel;

import java.util.List;

public class SearchRequestDataUtil {

    public String getSearchQueryFrom(SearchRequestModel searchRequest) {
        return searchRequest.getQ();
    }
    public List<String> getSearchTypesFrom(SearchRequestModel searchRequest) {
        return searchRequest.getType();
    }

    public String getSearchMarketFrom(SearchRequestModel searchRequest) {
        return searchRequest.getMarket();
    }
}
