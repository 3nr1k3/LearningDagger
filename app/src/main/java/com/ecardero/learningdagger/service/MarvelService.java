package com.ecardero.learningdagger.service;

import com.ecardero.learningdagger.mvp.common.model.service.MarvelApiResponse;
import com.ecardero.learningdagger.mvp.common.model.service.MarvelCharacter;
import com.ecardero.learningdagger.mvp.common.model.service.MarvelComic;
import com.ecardero.learningdagger.mvp.common.model.service.MarvelEvent;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ecardero on 3/02/17.
 */

public interface MarvelService {

    @GET("/v1/public/characters")
    Observable<MarvelApiResponse<MarvelCharacter>> getCharacters(
            @Query("offset") int offset
    );

    @GET("/v1/public/characters")
    Observable<MarvelApiResponse<MarvelCharacter>> getCharactersByStartName(
            @Query("nameStartsWith") String name
    );

    @GET("/v1/public/characters/{characterId}")
    Observable<MarvelApiResponse<MarvelCharacter>> getCharacterById(
            @Path("characterId") int characterId
    );

    @GET("/v1/public/characters/{characterId}/events")
    Observable<MarvelApiResponse<MarvelEvent>> getEventsByCharacter(
            @Path("characterId") int characterId,
            @Query("offset") int offset
    );

    @GET("/v1/public/characters/{characterId}/comics")
    Observable<MarvelApiResponse<MarvelComic>> getComicsByCharacter(
            @Path("characterId") int characterId,
            @Query("offset") int offset
    );
}
