package com.ecardero.learningdagger.data.entity.service;

import java.util.Collection;

/**
 * Created by ecardero on 24/01/17.
 */

public class MarvelCharacter extends MarvelData {

    //region Properties
    private int id;
    private String name;
    private String description;
    private Collection<MarvelUrl> urls;
    private MarvelImage thumbnail;
    private MarvelCollection comics;
    private MarvelCollection events;
    private MarvelCollection series;
    private MarvelCollection stories;
    //endregion

    //region Constructors
    //endregion

    //region Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<MarvelUrl> getUrls() {
        return urls;
    }

    public MarvelImage getThumbnail() {
        return thumbnail;
    }

    public MarvelCollection getComics() {
        return comics;
    }

    public MarvelCollection getEvents() {
        return events;
    }

    public MarvelCollection getSeries() {
        return series;
    }

    public MarvelCollection getStories() {
        return stories;
    }
    //endregion

    //region Setters
    //endregion
}
