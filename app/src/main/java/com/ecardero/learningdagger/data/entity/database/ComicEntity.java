package com.ecardero.learningdagger.data.entity.database;

import io.realm.RealmModel;

/**
 * Created by ecardero on 8/02/17.
 */
public class ComicEntity implements RealmModel {

    //region Properties
    private String title;
    private int pageCount;
    private String thumbnailUrl;
    private byte[] thumbnail;
    //endregion

    //region Constructors
    public ComicEntity(){}
    //endregion

    //region Getters
    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }
    //endregion

    //region Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
    //endregion

    //region Builder Pattern <Internal Class>
    public static class Builder{
        private ComicEntity _comic;

        public Builder(){
            if(_comic == null)
                _comic = new ComicEntity();
        }

        public Builder setTitle(String title){
            _comic.setTitle(title);
            return this;
        }

        public Builder setPageCount(int pageCount){
            _comic.setPageCount(pageCount);
            return this;
        }

        public Builder setThumbnail(byte[] image){
            _comic.setThumbnail(image);
            return this;
        }

        public Builder setThumbnailUrl(String url){
            _comic.setThumbnailUrl(url);
            return this;
        }

        public ComicEntity build(){
            return _comic;
        }
    }
    //endregion
}
