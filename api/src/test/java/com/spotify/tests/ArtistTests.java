package com.spotify.tests;

import com.neovisionaries.i18n.CountryCode;
import com.spotify.clients.ArtistClient;
import com.spotify.models.response.artist.*;
import com.spotify.utils.assertions.ApiAssertionsUtil;
import com.spotify.utils.responsefields.artist.ArtistProfileFieldsUtil;
import com.spotify.utils.responsefields.artist.ArtistTopTracksFieldsUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.spotify.testdata.artist.AristTracks.*;
import static com.spotify.testdata.artist.ArtistAlbums.*;
import static com.spotify.testdata.artist.ArtistProfiles.*;

public class ArtistTests {

    ArtistClient artistClient = new ArtistClient();
    ApiAssertionsUtil apiAssertionsUtil = new ApiAssertionsUtil();
    ArtistProfileFieldsUtil artistResponseFieldsUtil = new ArtistProfileFieldsUtil();
    ArtistTopTracksFieldsUtil artistTopTracksFieldsUtil = new ArtistTopTracksFieldsUtil();

    @Test
    void artistProfileTest() {

        String countryCode = String.valueOf(CountryCode.DE);

        ArtistProfileResponseModel artistData = artistClient.getArtistData(CAPITAL_BRA_PROFILE.getArtistId());
        ArtistTopTracksResponseModel artistTopTracks = artistClient.getArtistTopTracks(countryCode, CAPITAL_BRA_PROFILE.getArtistId());
        ArtistAlbumsResponseModel artistAlbums = artistClient.getArtistAlbums(countryCode, CAPITAL_BRA_PROFILE.getArtistId());
        ArtistRelatedResponseModel artistRelated = artistClient.getRelatedArtists(CAPITAL_BRA_PROFILE.getArtistId());

        Map<Object, Object> artistDataValidationData = Map.of(
                artistResponseFieldsUtil.getArtistGenres(artistData), CAPITAL_BRA_PROFILE.getArtistGenres(),
                artistResponseFieldsUtil.getArtistName(artistData), CAPITAL_BRA_PROFILE.getArtistName(),
                artistResponseFieldsUtil.getArtistId(artistData), CAPITAL_BRA_PROFILE.getArtistId(),
                artistResponseFieldsUtil.getArtistType(artistData), CAPITAL_BRA_PROFILE.getArtistType(),
                artistResponseFieldsUtil.getArtistUri(artistData), CAPITAL_BRA_PROFILE.getArtistUri()
        );

        Map<Object, Object> artistTopTracksValidationData = Map.of(
                artistTopTracksFieldsUtil.getTrackName(artistTopTracks, CAPITAL_BRA_NEYMAR_TRACK.getTrackName()), CAPITAL_BRA_NEYMAR_TRACK.getTrackName(),
                artistTopTracksFieldsUtil.getTrackId(artistTopTracks, 1), CAPITAL_BRA_NEYMAR_TRACK.getTrackId(),
                artistTopTracksFieldsUtil.getTrackDuration(artistTopTracks, 1), CAPITAL_BRA_NEYMAR_TRACK.getTrackDurationMs(),
                artistTopTracksFieldsUtil.getTrackType(artistTopTracks, 1), CAPITAL_BRA_NEYMAR_TRACK.getTrackType(),
                artistTopTracksFieldsUtil.getTrackAlbumName(artistTopTracks, 1), CAPITAL_BRA_BERLIN_LEBT_ALBUM.getAlbumName(),
                artistTopTracksFieldsUtil.getTrackArtistName(artistTopTracks, 1, 0), CAPITAL_BRA_PROFILE.getArtistName(),
                artistTopTracksFieldsUtil.getTrackExplicitStatus(artistTopTracks, 1), CAPITAL_BRA_NEYMAR_TRACK.getTrackExplicit()
                );

        Map<Object, Object> artistAlbumValidationData = Map.of(

        );

        apiAssertionsUtil.verifyResponseMultipleFields(artistTopTracksValidationData);
        apiAssertionsUtil.verifyResponseMultipleFields(artistDataValidationData);

//                artistResponseFieldsUtil.getArtistAlbumName(artistAlbums, 0), ARTIST_ALBUM_TITLE,
//                artistResponseFieldsUtil.getArtistRelated(artistRelated, 0), ARTIST_RELATED_NAME




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
