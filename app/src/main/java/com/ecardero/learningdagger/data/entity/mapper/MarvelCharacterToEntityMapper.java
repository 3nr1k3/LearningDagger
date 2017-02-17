package com.ecardero.learningdagger.data.entity.mapper;

import com.ecardero.learningdagger.data.entity.database.CharacterEntity;
import com.ecardero.learningdagger.data.entity.database.ComicEntity;
import com.ecardero.learningdagger.data.entity.database.EventEntity;
import com.ecardero.learningdagger.data.entity.database.UrlEntity;
import com.ecardero.learningdagger.data.entity.service.MarvelCharacter;
import com.ecardero.learningdagger.data.entity.service.MarvelComic;
import com.ecardero.learningdagger.data.entity.service.MarvelEvent;
import com.ecardero.learningdagger.data.entity.service.MarvelUrl;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;

import java.util.List;

import javax.inject.Inject;

import io.realm.RealmList;


@ActivityScope
public class MarvelCharacterToEntityMapper extends Mapper<MarvelCharacter, CharacterEntity> {

    MarvelUrlToEntityMapper urlMapper;
    MarvelComicToEntityMapper comicMapper;
    MarvelEventToEntityMapper eventMapper;

    @Inject
    public MarvelCharacterToEntityMapper(
            MarvelUrlToEntityMapper urlMapper,
            MarvelComicToEntityMapper comicMapper,
            MarvelEventToEntityMapper eventMapper
    ) {
        this.urlMapper = urlMapper;
        this.comicMapper = comicMapper;
        this.eventMapper = eventMapper;
    }

    @Override
    public CharacterEntity map(MarvelCharacter value) {
        List<UrlEntity> urls = urlMapper.map((List<MarvelUrl>)value.getUrls());

        return new CharacterEntity.Builder()
                .setId(value.getId())
                .setName(value.getName())
                .setDescription(value.getDescription())
                .setThumbnail(value.getThumbnail().getImageUrl())
                .setUrls(new RealmList<>((UrlEntity[]) urls.toArray()))
                .build();
    }

    public CharacterEntity map(MarvelCharacter value, List<MarvelComic> comics, List<MarvelEvent> events){
        CharacterEntity dbCharacter = this.map(value);
        List<ComicEntity> mappedComics = comicMapper.map(comics);
        List<EventEntity> mappedEvents = eventMapper.map(events);

        dbCharacter.setComics(new RealmList<>((ComicEntity[])mappedComics.toArray()));
        dbCharacter.setEvents(new RealmList<>((EventEntity[])mappedEvents.toArray()));

        return dbCharacter;
    }

    @Override
    public MarvelCharacter reverseMap(CharacterEntity value) {
        return null;
    }
}
