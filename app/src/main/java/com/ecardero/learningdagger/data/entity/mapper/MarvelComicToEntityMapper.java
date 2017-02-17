package com.ecardero.learningdagger.data.entity.mapper;

import com.ecardero.learningdagger.data.entity.database.ComicEntity;
import com.ecardero.learningdagger.data.entity.service.MarvelComic;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;


import javax.inject.Inject;

/**
 * Created by ecardero on 1/02/17.
 */
@ActivityScope
public class MarvelComicToEntityMapper extends Mapper<MarvelComic, ComicEntity> {

    //MarvelImageToEntityMapper imageMapper;

    @Inject
    public MarvelComicToEntityMapper() {}

    @Override
    public ComicEntity map(MarvelComic value) {
        return new ComicEntity.Builder()
                .setTitle(value.getTitle())
                .setPageCount(value.getPageCount())
                .setThumbnailUrl(value.getThumbnail().getImageUrl())
                .build();
    }

    @Override
    public MarvelComic reverseMap(ComicEntity value) {
        return new MarvelComic(
                value.getTitle(),
                value.getPageCount()
        );
    }
}
