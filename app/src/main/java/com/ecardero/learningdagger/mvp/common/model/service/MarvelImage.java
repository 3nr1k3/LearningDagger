package com.ecardero.learningdagger.mvp.common.model.service;

/**
 * Created by ecardero on 16/01/17.
 */
public class MarvelImage {
    private String path;
    private String extension;

    public String getImageUrl(){
        return String.format("%s.%s",path, extension);
    }
}
