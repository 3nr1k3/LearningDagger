package com.ecardero.learningdagger.presentation.mvp.common.contract;

/**
 * Created by ecardero on 9/02/17.
 */

public interface BaseContract {

    interface Presenter<V extends View>{
        void attachView(V view);
    }
    interface View{}
}
