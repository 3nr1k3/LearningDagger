package com.ecardero.learningdagger.data.entity.mapper;

import com.ecardero.learningdagger.data.entity.database.UrlEntity;
import com.ecardero.learningdagger.data.entity.service.MarvelUrl;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;


import javax.inject.Inject;

/**
 * Mapeador objeto a objeto entre los modelos {@link MarvelUrl} y {@link UrlEntity}.
 * Created by ecardero on 1/02/17.
 */
@ActivityScope
public class MarvelUrlToEntityMapper extends Mapper<MarvelUrl, UrlEntity> {

    @Inject
    public MarvelUrlToEntityMapper() {}

    /**
     * Convierte una instancia de {@link MarvelUrl} a {@link UrlEntity}
     * @param value La instancia de {@link MarvelUrl} a convertir.
     * @return {@link UrlEntity}
     */
    @Override
    public UrlEntity map(MarvelUrl value) {
        return new UrlEntity.Builder()
                .setType(value.getType())
                .setUrl(value.getUrl())
                .build();
    }

    @Override
    public MarvelUrl reverseMap(UrlEntity value) {
        throw new UnsupportedOperationException();
        /*return new MarvelUrl(
                value.getType(),
                value.getUrl()
        );*/
    }
}
