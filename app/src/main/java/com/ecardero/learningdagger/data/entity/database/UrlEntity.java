package com.ecardero.learningdagger.data.entity.database;

import io.realm.RealmModel;

/**
 * Created by ecardero on 8/02/17.
 */
public class UrlEntity implements RealmModel {

    //region Properties
    private String type;
    private String url;
    //endregion

    //region Constructors
    public UrlEntity(){}
    //endregion

    //region Getters
    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
    //endregion

    //region Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //endregion

    //region Builder Patterns <Internal Class>
    public static class Builder{
        private UrlEntity _url;

        public Builder(){
            if(_url == null)
                _url = new UrlEntity();
        }

        public Builder setType(String type){
            _url.setType(type);
            return this;
        }

        public Builder setUrl(String url){
            _url.setUrl(url);
            return this;
        }

        public UrlEntity build(){
            return _url;
        }
    }
    //endregion
}
