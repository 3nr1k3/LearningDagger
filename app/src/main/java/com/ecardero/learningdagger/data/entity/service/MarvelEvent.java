package com.ecardero.learningdagger.data.entity.service;


/**
 * Created by ecardero on 24/01/17.
 */
public class MarvelEvent extends MarvelData {
    //region Properties
    private int id;
    private String title;
    private String description;
    private String resourceURI;
    private MarvelImage thumbnail;
    //endregion

    //region Constructors
    public MarvelEvent(){}
    //endregion

    //region Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public MarvelImage getThumbnail() {
        return thumbnail;
    }
    //endregion

    //region Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setThumbnail(MarvelImage thumbnail) {
        this.thumbnail = thumbnail;
    }
    //endregion

    //region Builder Pattern <Internal Class>
    public static class Builder{
        private MarvelEvent _event;

        public Builder(){
            if (_event == null)
                _event = new MarvelEvent();
        }

        public Builder setId(int id){
            _event.setId(id);
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

        public Builder setThumbnail(MarvelImage marvelImage){
            _event.setThumbnail(marvelImage);
            return this;
        }

        public MarvelEvent build(){
            return _event;
        }
    }
    //endregion
}
