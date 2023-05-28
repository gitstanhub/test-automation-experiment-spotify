package com.spotify.utils.requestfields.search;

import com.spotify.models.request.search.SearchRequestModel;

import java.util.List;

public class SearchRequestFieldsUtil {

    public String getSearchQuery(SearchRequestModel searchRequest) {
        return searchRequest.getQ();
    }
    public List<String> getSearchTypes(SearchRequestModel searchRequest) {
        return searchRequest.getType();
    }
}
