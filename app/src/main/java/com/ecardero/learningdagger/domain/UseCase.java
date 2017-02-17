package com.ecardero.learningdagger.domain;

import io.reactivex.Observable;

/**
 * Created by ecardero on 15/02/17.
 */

public abstract class UseCase<T> {

    public abstract Observable<T> buildObservable();

    public Observable<T> execute(){
        return buildObservable();
    }
}
