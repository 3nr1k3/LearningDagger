package com.ecardero.learningdagger.data.entity.database;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ecardero on 6/02/17.
 */

public class CharacterEntity implements RealmModel {

    //region Properties
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private RealmList<UrlEntity> urls;
    private String thumbnail;
    private RealmList<ComicEntity> comics;
    private RealmList<EventEntity> events;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public RealmList<UrlEntity> getUrls() {
        return urls;
    }

    public RealmList<ComicEntity> getComics() {
        return comics;
    }

    public RealmList<EventEntity> getEvents() {
        return events;
    }
    //endregion

    //region Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setUrls(RealmList<UrlEntity> urls) {
        this.urls = urls;
    }

    public void setComics(RealmList<ComicEntity> comics) {
        this.comics = comics;
    }

    public void setEvents(RealmList<EventEntity> events) {
        this.events = events;
    }

    //endregion

    //region Builder Pattern <Internal Class>
    public static class Builder{

        private CharacterEntity _characterBuilder;

        //region Constructors
        public Builder(){
            if(_characterBuilder == null)
                _characterBuilder = new CharacterEntity();
        }
        //endregion

        //region Setters -> return this instance
        public Builder setId(int id){
            _characterBuilder.setId(id);
            return this;
        }

        public Builder setName(String name){
            _characterBuilder.setName(name);
            return this;
        }

        public Builder setDescription(String description){
            _characterBuilder.setDescription(description);
            return this;
        }

        public Builder setThumbnail(String thumbnailUrl){
            _characterBuilder.setThumbnail(thumbnailUrl);
            return this;
        }

        public Builder setUrls(RealmList<UrlEntity> urls){
            _characterBuilder.setUrls(urls);
            return this;
        }

        public Builder setComics(RealmList<ComicEntity> comics){
            _characterBuilder.setComics(comics);
            return this;
        }

        public Builder addComic(ComicEntity comic){
            if(_characterBuilder.getComics().isEmpty())
                _characterBuilder.setComics(new RealmList<>());

            _characterBuilder.getComics().add(comic);
            return this;
        }

        public Builder setEvents(RealmList<EventEntity> events){
            _characterBuilder.setEvents(events);
            return this;
        }

        public Builder addEvent(EventEntity event){
            if(_characterBuilder.getEvents().isEmpty())
                _characterBuilder.setEvents(new RealmList<>());

            _characterBuilder.getEvents().add(event);
            return this;
        }
        //endregion

        //region build
        public CharacterEntity build(){
            return _characterBuilder;
        }
        //endregion

    }
    //endregion

}
