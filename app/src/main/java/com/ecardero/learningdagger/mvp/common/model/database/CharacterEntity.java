package com.ecardero.learningdagger.mvp.common.model.database;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ecardero on 6/02/17.
 */

public class CharacterEntity implements RealmModel {

    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private RealmList<UrlEntity> urls;
    private String thumbnail;
    private RealmList<ComicEntity> comics;
    private RealmList<EventEntity> events;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public static class Builder{

        private CharacterEntity _characterBuilder;

        public Builder(){
            _characterBuilder = new CharacterEntity();
        }

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

        public CharacterEntity build(){
            return _characterBuilder;
        }
    }
}
