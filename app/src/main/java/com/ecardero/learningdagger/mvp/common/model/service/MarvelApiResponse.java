package com.ecardero.learningdagger.mvp.common.model.service;

/**
 * Created by ecardero on 24/01/17.
 */

public class MarvelApiResponse<T extends MarvelData> {
    private String code;
    private String status;
    private MarvelDataContainer<T> data;

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public MarvelDataContainer<T> getData() {
        return data;
    }
}
