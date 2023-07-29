package com.spotify.tests.base;

import com.spotify.config.SpringConfigApi;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.requestdata.search.SearchRequestDataUtil;
import com.spotify.utils.responsedata.artist.*;
import com.spotify.utils.responsedata.search.SearchResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfigApi.class)
@Slf4j
public class ApiTests {

    public static final ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    public static final ArtistProfileResponseDataUtil artistResponseFieldsUtil = new ArtistProfileResponseDataUtil();
    public static final ArtistTopTracksResponseDataUtil artistTopTracksFieldsUtil = new ArtistTopTracksResponseDataUtil();
    public static final ArtistAlbumResponseDataUtil artistAlbumFieldsUtil = new ArtistAlbumResponseDataUtil();
    public static final RelatedArtistsResponseDataUtil artistRelatedFieldsUtil = new RelatedArtistsResponseDataUtil();
    public static final MultipleArtistsResponseDataUtil artistMultipleFieldsUtil = new MultipleArtistsResponseDataUtil();
    public static final SearchRequestDataUtil searchRequestDataUtil = new SearchRequestDataUtil();
    public static final SearchResponseDataUtil searchResponseDataUtil = new SearchResponseDataUtil();
}