package com.ecardero.learningdagger.domain;

import com.ecardero.learningdagger.data.entity.service.MarvelApiResponse;
import com.ecardero.learningdagger.data.entity.service.MarvelCharacter;
import com.ecardero.learningdagger.data.entity.service.MarvelComic;
import com.ecardero.learningdagger.data.entity.service.MarvelEvent;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by ecardero on 15/02/17.
 */

public interface CharacterRepository {
    Observable<MarvelApiResponse<MarvelCharacter>> getCharacters(int offset);
    Observable<MarvelApiResponse<MarvelCharacter>> getCharactersByName(String nameStartsWith, int offset);
    Observable<MarvelApiResponse<MarvelCharacter>> getCharacter(final int characterId);
    Observable<MarvelApiResponse<MarvelComic>> getCharacterComics(final int characterId, int offset);
    Observable<MarvelApiResponse<MarvelEvent>> getCharacterEvents(final int characterId, int offset);
}
