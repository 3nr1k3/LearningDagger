package com.ecardero.learningdagger.presentation.service;


import com.ecardero.learningdagger.data.entity.service.StarWarsApi.Character;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface StarWarsService {

    @GET("api/characters")
    Observable<List<Character>> getCharacters(
            @HeaderMap Map<String, String> headers
    );

    @GET("api/characters/{characterId}")
    Observable<Character> getCharacterById(
            @Path("characterId") int characterId
    );
}