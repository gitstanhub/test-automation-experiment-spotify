package com.spotify.utils.requestdata.search;

import com.spotify.models.request.search.SearchRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
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
