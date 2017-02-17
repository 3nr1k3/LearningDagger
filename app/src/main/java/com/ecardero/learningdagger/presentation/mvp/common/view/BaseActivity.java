package com.ecardero.learningdagger.presentation.mvp.common.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.constants.Constants;
import com.ecardero.learningdagger.presentation.di.component.AppComponent;
import com.ecardero.learningdagger.presentation.mvp.common.contract.BaseContract;
import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

/**
 * Created by ecardero on 6/02/17.
 */

public abstract class BaseActivity<P extends BaseContract.Presenter, V extends BaseContract.View> extends AppCompatActivity implements BaseContract.View {

    @Inject protected P mPresenter;
    @Inject protected FirebaseAnalytics mFirebaseAnalytics;

    protected void onCreate(@Nullable Bundle savedInstanceState, Activity activity){
        super.onCreate(savedInstanceState);

        Bundle bundle = new Bundle();
        bundle.putString(Constants.CustomFirebase.Params.ACTIVITY_NAME, activity.getClass().getSimpleName());
        mFirebaseAnalytics.logEvent(Constants.CustomFirebase.Event.ACTIVITY_START, bundle);
    }

    protected void initializeDependencies(Activity activity){
        this.getAppComponent().inject(activity);
    }

    protected void initializePresenter(V view){
        mPresenter.attachView(view);
    }

    protected AppComponent getAppComponent(){
        return ((DaggerApp)getApplication()).getAppComponent();
    }
}
