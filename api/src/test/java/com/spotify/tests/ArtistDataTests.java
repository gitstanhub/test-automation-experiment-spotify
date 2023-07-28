package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.models.response.artist.*;
import com.spotify.testdata.artist.assertions.*;
import com.spotify.testdata.artist.constants.ArtistEntities;
import com.spotify.tests.base.ApiTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static com.spotify.testdata.artist.constants.AristTracks.*;
import static com.spotify.testdata.artist.constants.ArtistAlbums.*;
import static com.spotify.testdata.artist.constants.ArtistEntities.*;

public class ArtistDataTests extends ApiTests {

    @Autowired
    ArtistClient artistClient;

    @Test
    void artistProfileCanBeFetched() {
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

        apiAssertionsUtil.assertFieldsAreEqual(actualArtistData, expectedArtistData);
    }

    @Test
    void artistTopTracksCanBeFetched() {
        String countryCode = String.valueOf(CountryCode.DE);

        ArtistTopTracksResponseModel fetchedArtistTopTracks = artistClient.getArtistTopTracks(countryCode, CAPITAL_BRA.getArtistId());

        ArtistTracksAssertionData.ActualTracksData actualTopTracksData = new ArtistTracksAssertionData.ActualTracksData(
                artistTopTracksFieldsUtil.getTrackName(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackId(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackDuration(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackType(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackAlbumName(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName()),
                artistTopTracksFieldsUtil.getTrackArtistName(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName(), 0),
                artistTopTracksFieldsUtil.getTrackExplicitStatus(fetchedArtistTopTracks, ARTIST1_TRACK_1.getTrackName())
        );

        ArtistTracksAssertionData.ExpectedTracksData expectedTopTracksData = new ArtistTracksAssertionData.ExpectedTracksData(
                ARTIST1_TRACK_1.getTrackName(),
                ARTIST1_TRACK_1.getTrackId(),
                ARTIST1_TRACK_1.getTrackDurationMs(),
                ARTIST1_TRACK_1.getTrackType(),
                BERLIN_LEBT.getAlbumName(),
                ARTIST1_TRACK_1.getTrackArtists().get(0),
                ARTIST1_TRACK_1.getTrackExplicit()
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualTopTracksData, expectedTopTracksData);
    }

    @Test
    void artistAlbumsCanBeFetched() {
        String countryCode = String.valueOf(CountryCode.DE);

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

        apiAssertionsUtil.assertFieldsAreEqual(actualAlbumsData, expectedAlbumsData);
    }

    @Test
    void relatedArtistsCanBeFetched() {
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

        apiAssertionsUtil.assertFieldsAreEqual(actualRelatedArtistData, expectedAssertionData);
    }

    @Test
    void multipleArtistsProfilesCanBeFetched() {
        List<ArtistEntities> inScopeArtists = Arrays.asList(
                CAPITAL_BRA,
                AK_AUSSERKONTOLLE,
                YEAT
        );

        List<String> inScopeArtistsIds = ArtistEntities.getMultipleArtistIds(inScopeArtists);
        List<String> inScopeArtistsNames = ArtistEntities.getMultipleArtistNames(inScopeArtists);
        List<String> inScopeArtistsGenres = ArtistEntities.getMultipleArtistGenres(inScopeArtists);

        ArtistMultipleResponseModel fetchedArtistMultiple = artistClient.getMultipleArtistsData(inScopeArtistsIds);

        ArtistMultipleAssertionData.ActualMultipleArtistData actualMultipleArtistData = new ArtistMultipleAssertionData.ActualMultipleArtistData(
                artistMultipleFieldsUtil.getMultipleArtistsNames(fetchedArtistMultiple),
                artistMultipleFieldsUtil.getMultipleArtistGenres(fetchedArtistMultiple),
                artistMultipleFieldsUtil.getMultipleArtistIds(fetchedArtistMultiple)
        );

        ArtistMultipleAssertionData.ExpectedMultipleArtistData expectedMultipleArtistData = new ArtistMultipleAssertionData.ExpectedMultipleArtistData(
                inScopeArtistsNames,
                inScopeArtistsGenres,
                inScopeArtistsIds
        );

        apiAssertionsUtil.assertFieldsAreEqual(actualMultipleArtistData, expectedMultipleArtistData);
    }
}
