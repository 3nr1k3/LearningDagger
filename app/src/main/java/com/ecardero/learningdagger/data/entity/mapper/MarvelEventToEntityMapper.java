package com.ecardero.learningdagger.data.entity.mapper;

import com.ecardero.learningdagger.data.entity.database.EventEntity;
import com.ecardero.learningdagger.data.entity.service.MarvelEvent;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;


import javax.inject.Inject;

/**
 * Created by ecardero on 1/02/17.
 */
@ActivityScope
public class MarvelEventToEntityMapper extends Mapper<MarvelEvent, EventEntity> {

    //@Inject MarvelImageToEntityMapper imageMapper;

    @Inject
    public MarvelEventToEntityMapper(){}

    @Override
    public EventEntity map(MarvelEvent value) {
        return new EventEntity.Builder()
                .setId(value.getId())
                .setTitle(value.getTitle())
                .setDescription(value.getDescription())
                .setThumbnailUrl(value.getThumbnail().getImageUrl())
                .build();
    }

    @Override
    public MarvelEvent reverseMap(EventEntity value) {
        throw new UnsupportedOperationException();
        /*return new MarvelEvent(
                value.getId(),
                value.getTitle(),
                value.getDescription(),
                value.getResourceURI(),
                imageMapper.reverseMap(value.getThumbnail())
        );*/
    }
}
