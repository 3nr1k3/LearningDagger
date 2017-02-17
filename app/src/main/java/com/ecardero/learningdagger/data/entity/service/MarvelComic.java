package com.ecardero.learningdagger.data.entity.service;

/**
 * Created by ecardero on 24/01/17.
 */

public class MarvelComic extends MarvelData {
    private String title;
    private int pageCount;
    private MarvelImage thumbnail;

    public MarvelComic(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public MarvelComic(String title, int pageCount, MarvelImage thumbnail) {
        this.title = title;
        this.pageCount = pageCount;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public MarvelImage getThumbnail() {
        return thumbnail;
    }
}
