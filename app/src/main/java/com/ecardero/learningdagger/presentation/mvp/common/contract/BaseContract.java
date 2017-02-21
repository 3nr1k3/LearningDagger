package com.ecardero.learningdagger.presentation.mvp.common.contract;

import android.support.annotation.NonNull;

/**
 * Created by ecardero on 9/02/17.
 */

public interface BaseContract {

    interface Presenter<V extends View>{
        void onStart();
        void onStop();

        void attachView(@NonNull V view);
    }
    interface View{}
}
