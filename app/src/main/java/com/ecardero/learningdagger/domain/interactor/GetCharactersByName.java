package com.ecardero.learningdagger.domain.interactor;

import com.ecardero.learningdagger.data.entity.mapper.MarvelCharacterToEntityMapper;
import com.ecardero.learningdagger.domain.CharacterRepository;
import com.ecardero.learningdagger.domain.UseCase;
import com.ecardero.learningdagger.data.entity.database.CharacterEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by ecardero on 15/02/17.
 */

public class GetCharactersByName extends UseCase<List<CharacterEntity>> {

    CharacterRepository mRepository;
    MarvelCharacterToEntityMapper mCharacterMapper;
    Scheduler mUiThread;
    Scheduler mExecutorThread;

    @Inject
    public GetCharactersByName(
            CharacterRepository repository,
            MarvelCharacterToEntityMapper characterMapper,
            @Named("UiThread")Scheduler uiThread,
            @Named("ExecutorThread")Scheduler executorThread
    ){
        mRepository = repository;
        mCharacterMapper = characterMapper;
        mUiThread = uiThread;
        mExecutorThread = executorThread;
    }

    public Observable<List<CharacterEntity>> buildObservable(String characterName, int offset){
        return mRepository.getCharactersByName(characterName, offset)
                .map(marvelCharacterMarvelApiResponse -> mCharacterMapper.map(marvelCharacterMarvelApiResponse.getData().getResults()))
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }

    @Override
    public Observable<List<CharacterEntity>> buildObservable() {
        return null;
    }
}
