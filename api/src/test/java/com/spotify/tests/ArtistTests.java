package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.models.response.artist.*;
import com.spotify.testdata.artist.assertions.ArtistAlbumsAssertionData;
import com.spotify.testdata.artist.assertions.ArtistEntitiesAssertionData;
import com.spotify.testdata.artist.assertions.ArtistRelatedAssertionData;
import com.spotify.testdata.artist.assertions.ArtistTracksAssertionData;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.responsefields.artist.ArtistAlbumFieldsUtil;
import com.spotify.utils.responsefields.artist.ArtistProfileFieldsUtil;
import com.spotify.utils.responsefields.artist.ArtistRelatedFieldsUtil;
import com.spotify.utils.responsefields.artist.ArtistTopTracksFieldsUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.spotify.testdata.artist.constants.AristTracks.*;
import static com.spotify.testdata.artist.constants.ArtistAlbums.*;
import static com.spotify.testdata.artist.constants.ArtistEntities.*;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    ArtistProfileFieldsUtil artistResponseFieldsUtil = new ArtistProfileFieldsUtil();
    ArtistTopTracksFieldsUtil artistTopTracksFieldsUtil = new ArtistTopTracksFieldsUtil();
    ArtistAlbumFieldsUtil artistAlbumFieldsUtil = new ArtistAlbumFieldsUtil();
    ArtistRelatedFieldsUtil artistRelatedFieldsUtil = new ArtistRelatedFieldsUtil();

    @Test
    void artistProfileTest() {

        ArtistProfileResponseModel fetchedArtistData = artistClient.getArtistData(CAPITAL_BRA.getArtistId());

        ArtistEntitiesAssertionData.ActualArtistData actualArtistData = new ArtistEntitiesAssertionData.ActualArtistData(
                artistResponseFieldsUtil.getArtistName(fetchedArtistData),
                artistResponseFieldsUtil.getArtistGenres(fetchedArtistData),
                artistResponseFieldsUtil.getArtistId(fetchedArtistData),
                artistResponseFieldsUtil.getArtistType(fetchedArtistData),
                artistResponseFieldsUtil.getArtistUri(fetchedArtistData)
        );

        ArtistEntitiesAssertionData.ExpectedArtistData expectedArtistData = new ArtistEntitiesAssertionData.ExpectedArtistData(
                CAPITAL_BRA.getArtistName(),
                CAPITAL_BRA.getArtistGenres(),
                CAPITAL_BRA.getArtistId(),
                CAPITAL_BRA.getArtistType(),
                CAPITAL_BRA.getArtistUri()
        );


        String countryCode = String.valueOf(CountryCode.DE);

        ArtistTopTracksResponseModel fetchedArtistTopTracks = artistClient.getArtistTopTracks(countryCode, CAPITAL_BRA.getArtistId());

        ArtistTracksAssertionData.ActualTracksData actualTopTracksData = new ArtistTracksAssertionData.ActualTracksData(
                artistTopTracksFieldsUtil.getTrackName(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackId(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackDuration(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackType(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackAlbumName(fetchedArtistTopTracks, NEYMAR.getTrackName()),
                artistTopTracksFieldsUtil.getTrackArtistName(fetchedArtistTopTracks, NEYMAR.getTrackName(), 0),
                artistTopTracksFieldsUtil.getTrackExplicitStatus(fetchedArtistTopTracks, NEYMAR.getTrackName())
        );

        ArtistTracksAssertionData.ExpectedTracksData expectedTopTracksData = new ArtistTracksAssertionData.ExpectedTracksData(
                NEYMAR.getTrackName(),
                NEYMAR.getTrackId(),
                NEYMAR.getTrackDurationMs(),
                NEYMAR.getTrackType(),
                BERLIN_LEBT.getAlbumName(),
                NEYMAR.getTrackArtists().get(0),
                NEYMAR.getTrackExplicit()
        );


        ArtistAlbumsResponseModel fetchedArtistAlbums = artistClient.getArtistAlbums(countryCode, CAPITAL_BRA.getArtistId());

        ArtistAlbumsAssertionData.ActualAlbumData actualAlbumsData = new ArtistAlbumsAssertionData.ActualAlbumData(
                artistAlbumFieldsUtil.getAlbumName(fetchedArtistAlbums, BERLIN_LEBT.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumId(fetchedArtistAlbums, BERLIN_LEBT.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumArtistName(fetchedArtistAlbums, BERLIN_LEBT.getAlbumName(), 0),
                artistAlbumFieldsUtil.getAlbumType(fetchedArtistAlbums, BERLIN_LEBT.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumTotalTracks(fetchedArtistAlbums, BERLIN_LEBT.getAlbumName()),
                artistAlbumFieldsUtil.getAlbumReleaseDate(fetchedArtistAlbums, BERLIN_LEBT.getAlbumName())
        );

        ArtistAlbumsAssertionData.ExpectedAlbumData expectedAlbumsData = new ArtistAlbumsAssertionData.ExpectedAlbumData(
                BERLIN_LEBT.getAlbumName(),
                BERLIN_LEBT.getAlbumId(),
                BERLIN_LEBT.getAlbumArtists().get(0),
                BERLIN_LEBT.getAlbumType(),
                BERLIN_LEBT.getAlbumTotalTracks(),
                BERLIN_LEBT.getAlbumReleaseDate()
        );

        ArtistRelatedResponseModel fetchedArtistRelated = artistClient.getRelatedArtists(CAPITAL_BRA.getArtistId());

        ArtistRelatedAssertionData.ActualRelatedArtistData actualRelatedArtistData = new ArtistRelatedAssertionData.ActualRelatedArtistData(
                artistRelatedFieldsUtil.getRelatedArtistName(fetchedArtistRelated, AK_AUSSERKONTOLLE.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistGenres(fetchedArtistRelated, AK_AUSSERKONTOLLE.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistId(fetchedArtistRelated, AK_AUSSERKONTOLLE.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistType(fetchedArtistRelated, AK_AUSSERKONTOLLE.getArtistName()),
                artistRelatedFieldsUtil.getRelatedArtistUri(fetchedArtistRelated, AK_AUSSERKONTOLLE.getArtistName())
        );

        ArtistRelatedAssertionData.ExpectedRelatedArtistData expectedAssertionData = new ArtistRelatedAssertionData.ExpectedRelatedArtistData(
                AK_AUSSERKONTOLLE.getArtistName(),
                AK_AUSSERKONTOLLE.getArtistGenres(),
                AK_AUSSERKONTOLLE.getArtistId(),
                AK_AUSSERKONTOLLE.getArtistType(),
                AK_AUSSERKONTOLLE.getArtistUri()
        );

        apiAssertionsUtil.verifyResponseMultipleFields(actualArtistData, expectedArtistData);
        apiAssertionsUtil.verifyResponseMultipleFields(actualTopTracksData, expectedTopTracksData);
        apiAssertionsUtil.verifyResponseMultipleFields(actualAlbumsData, expectedAlbumsData);
        apiAssertionsUtil.verifyResponseMultipleFields(actualRelatedArtistData, expectedAssertionData);
    }

    @Test
    void multipleArtistProfilesTest() {

        List<String> artistsCollection = Arrays.asList(
                CAPITAL_BRA.getArtistId(),
                AK_AUSSERKONTOLLE.getArtistId(),
                YEAT.getArtistId()
        );

        ArtistMultipleResponseModel fetchedArtistMultiple = artistClient.getMultipleArtistsData(artistsCollection);


//        apiAssertionsUtil.verifyResponseSingleField(artistResponseFieldsUtil.getArtistName(artistsMultiple, 1), ARTIST_NAME_MULTIPLE_PROFILES);
    }
}
