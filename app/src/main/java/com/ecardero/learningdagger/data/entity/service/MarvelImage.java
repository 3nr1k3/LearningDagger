package com.ecardero.learningdagger.data.entity.service;

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
