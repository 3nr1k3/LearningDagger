package com.ecardero.learningdagger.data.entity.mapper;

import com.ecardero.learningdagger.data.entity.service.MarvelImage;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;

import javax.inject.Inject;

/**
 * Created by ecardero on 1/02/17.
 */
//@ApplicationScope
public class MarvelImageToEntityMapper/* extends Mapper<MarvelImage, ImageEntity> */{

    /*@Inject
    public MarvelImageToEntityMapper(){}

    @Override
    public ImageEntity map(MarvelImage value) {
        return new ImageEntity(
                value.getPath(),
                value.getExtension()
        );
    }

    @Override
    public MarvelImage reverseMap(ImageEntity value) {
        return new MarvelImage(
                value.getPath(),
                value.getExtension()
        );
    }*/
}
