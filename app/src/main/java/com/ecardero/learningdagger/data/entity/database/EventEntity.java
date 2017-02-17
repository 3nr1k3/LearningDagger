package com.ecardero.learningdagger.data.entity.database;

import io.realm.RealmModel;

/**
 * Created by ecardero on 8/02/17.
 */
public class EventEntity implements RealmModel {
    //region Properties
    private int id;
    private String title;
    private String description;
    private String thumbnailUrl;
    //endregion

    //region Constructors
    /**
     * Public empty constructor method required for Builder Pattern.
     */
    public EventEntity(){}
    //endregion

    //region Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    //endregion

    //region Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    //endregion

    //region Builder Pattern <Internal Class>
    public static class Builder{
        private EventEntity _event;

        //region Constructors
        public Builder(){
            if(_event == null)
                _event = new EventEntity();
        }
        //endregion

        //region Setters -> return this instance
        public Builder setId(int eventId){
            _event.setId(eventId);
            return this;
        }

        public Builder setTitle(String title){
            _event.setTitle(title);
            return this;
        }

        public Builder setDescription(String description){
            _event.setDescription(description);
            return this;
        }

        public Builder setThumbnailUrl(String url){
            _event.setThumbnailUrl(url);
            return this;
        }
        //endregion

        //region build
        public EventEntity build(){
            return _event;
        }
        //endregion
    }
    //endregion
}
