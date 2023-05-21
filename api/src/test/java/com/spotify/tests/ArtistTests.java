package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.models.response.artist.*;
import com.spotify.testdata.artist.assertions.ArtistAssertionData;
import com.spotify.testdata.artist.assertions.ArtistTopTracksAssertionData;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.responsefields.artist.ArtistProfileFieldsUtil;
import com.spotify.utils.responsefields.artist.ArtistTopTracksFieldsUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.spotify.testdata.artist.constants.AristTracks.*;
import static com.spotify.testdata.artist.constants.ArtistAlbums.*;
import static com.spotify.testdata.artist.constants.ArtistEntities.*;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    ArtistProfileFieldsUtil artistResponseFieldsUtil = new ArtistProfileFieldsUtil();
    ArtistTopTracksFieldsUtil artistTopTracksFieldsUtil = new ArtistTopTracksFieldsUtil();

    @Test
    void artistProfileTest() {

        ArtistProfileResponseModel fetchedArtistData = artistClient.getArtistData(CAPITAL_BRA.getArtistId());

        ArtistAssertionData.ActualArtistData actualArtistData = new ArtistAssertionData.ActualArtistData(
                artistResponseFieldsUtil.getArtistName(fetchedArtistData),
                artistResponseFieldsUtil.getArtistGenres(fetchedArtistData),
                artistResponseFieldsUtil.getArtistId(fetchedArtistData),
                artistResponseFieldsUtil.getArtistType(fetchedArtistData),
                artistResponseFieldsUtil.getArtistUri(fetchedArtistData)
        );

        ArtistAssertionData.ExpectedArtistData expectedArtistData = new ArtistAssertionData.ExpectedArtistData(
                CAPITAL_BRA.getArtistName(),
                CAPITAL_BRA.getArtistGenres(),
                CAPITAL_BRA.getArtistId(),
                CAPITAL_BRA.getArtistType(),
                CAPITAL_BRA.getArtistUri()
        );

        String countryCode = String.valueOf(CountryCode.DE);
        ArtistTopTracksResponseModel fetchedArtistTopTracks = artistClient.getArtistTopTracks(countryCode, CAPITAL_BRA.getArtistId());

        ArtistTopTracksAssertionData.ActualTopTracksData actualTopTracksData = new ArtistTopTracksAssertionData.ActualTopTracksData(
                artistTopTracksFieldsUtil.getTrackId(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackDuration(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackType(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackAlbumName(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackArtistName(fetchedArtistTopTracks, NEYMAR.getTrackName(), 0),
                artistTopTracksFieldsUtil.getTrackExplicitStatus(fetchedArtistTopTracks, NEYMAR.getTrackName())
        );

        ArtistTopTracksAssertionData.ExpectedTopTracksData expectedTopTracksData = new ArtistTopTracksAssertionData.ExpectedTopTracksData(
                NEYMAR.getTrackId(),
                NEYMAR.getTrackDurationMs(),
                NEYMAR.getTrackType(),
                BERLIN_LEBT.getAlbumName(),
                CAPITAL_BRA.getArtistName(),
                NEYMAR.getTrackExplicit()
        );

        apiAssertionsUtil.verifyResponseMultipleFields(actualArtistData, expectedArtistData);
        apiAssertionsUtil.verifyResponseMultipleFields(actualTopTracksData, expectedTopTracksData);

//        List<Object> actualTopTracksDataList = new ArrayList<>();
//        actualTopTracksDataList.add(artistTopTracksFieldsUtil.getTrackId(fetchedArtistTopTracks, NEYMAR.getTrackName()));
//        actualTopTracksDataList.add(artistTopTracksFieldsUtil.getTrackDuration(fetchedArtistTopTracks, NEYMAR.getTrackName()));
//        actualTopTracksDataList.add(artistTopTracksFieldsUtil.getTrackType(fetchedArtistTopTracks, NEYMAR.getTrackName()));
//        actualTopTracksDataList.add(artistTopTracksFieldsUtil.getTrackAlbumName(fetchedArtistTopTracks, NEYMAR.getTrackName()));
//        actualTopTracksDataList.add(artistTopTracksFieldsUtil.getTrackArtistName(fetchedArtistTopTracks, NEYMAR.getTrackName(), 0));
//        actualTopTracksDataList.add(artistTopTracksFieldsUtil.getTrackExplicitStatus(fetchedArtistTopTracks, NEYMAR.getTrackName()));
//
//        List<Object> expectedTopTracksDataList = new ArrayList<>();
//        expectedTopTracksDataList.add(NEYMAR.getTrackId());
//        expectedTopTracksDataList.add(NEYMAR.getTrackDurationMs());
//        expectedTopTracksDataList.add(NEYMAR.getTrackType());
//        expectedTopTracksDataList.add(BERLIN_LEBT.getAlbumName());
//        expectedTopTracksDataList.add(CAPITAL_BRA.getArtistName());
//        expectedTopTracksDataList.add(NEYMAR.getTrackExplicit());


//        apiAssertionsUtil.verifyResponseMultipleFields(actualTopTracksDataList, expectedTopTracksDataList);


        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums(countryCode, CAPITAL_BRA.getArtistId());

        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists(CAPITAL_BRA.getArtistId());

    }

    @Test
    void multipleArtistProfilesTest() {

        String[] artistsCollection = {
                "4WZGDpNwrC0vNQyl9QzF7d",
                "3qiHUAX7zY4Qnjx8TNUzVx",
                "07SFzTMeYf5P8Rd32a9Zzw"
        };

        ArtistMultipleResponseModel artistsMultiple = artistClient.getMultipleArtistsData(artistsCollection);

//        apiAssertionsUtil.verifyResponseSingleField(artistResponseFieldsUtil.getArtistName(artistsMultiple, 1), ARTIST_NAME_MULTIPLE_PROFILES);
    }
}
