package com.ecardero.learningdagger.presentation.mvp.common.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.constants.Constants;
import com.ecardero.learningdagger.presentation.di.component.AppComponent;
import com.ecardero.learningdagger.presentation.mvp.common.contract.BaseContract;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

import javax.inject.Inject;

import dagger.internal.GwtIncompatible;
import dagger.internal.Preconditions;

import static dagger.internal.Preconditions.checkNotNull;

public abstract class BaseActivity<P extends BaseContract.Presenter, V extends BaseContract.View>
        extends AppCompatActivity
        implements GoogleApiClient.OnConnectionFailedListener, BaseContract.View
{
    @Inject protected P mPresenter;
    @Inject protected FirebaseAnalytics mFirebaseAnalytics;

    protected void onCreate(@Nullable Bundle savedInstanceState, Activity activity){
        super.onCreate(savedInstanceState);

        Bundle bundle = new Bundle();
        bundle.putString(Constants.CustomFirebase.Params.ACTIVITY_NAME, activity.getClass().getSimpleName());
        mFirebaseAnalytics.logEvent(Constants.CustomFirebase.Event.ACTIVITY_START, bundle);
    }

    protected void initializeDependencies(Activity activity){
        checkNotNull(activity);

        this.getAppComponent().inject(activity);
    }

    protected void initializePresenter(V view){
        checkNotNull(view);

        mPresenter.attachView(view);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        FirebaseCrash.report(new Exception(connectionResult.getErrorMessage()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    private AppComponent getAppComponent(){
        return ((DaggerApp)getApplication()).getAppComponent();
    }
}
