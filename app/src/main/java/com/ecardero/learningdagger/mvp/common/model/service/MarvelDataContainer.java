package com.ecardero.learningdagger.mvp.common.model.service;

import java.util.List;

/**
 * Created by ecardero on 24/01/17.
 */

public class MarvelDataContainer<T extends MarvelData> {
    private List<T> results;

    public List<T> getResults() {
        return results;
    }
}
