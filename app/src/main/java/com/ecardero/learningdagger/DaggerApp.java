package com.ecardero.learningdagger;

import android.app.Application;
import android.os.Bundle;

import com.ecardero.learningdagger.presentation.di.component.AppComponent;
import com.ecardero.learningdagger.presentation.di.component.DaggerAppComponent;
import com.ecardero.learningdagger.presentation.di.module.AppModule;
import com.ecardero.learningdagger.presentation.di.module.DatabaseModule;
import com.ecardero.learningdagger.presentation.service.StarWarsService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

/**
 * Created by ecardero on 3/02/17.
 */

public class DaggerApp extends Application {

    AppComponent appComponent;

    @Inject FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();

        this.initializeLeakDetection();
        this.initializeInjector();

        FirebaseCrash.log("Application created");

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, null);
    }

    private void initializeInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
        appComponent.inject(this);

        FirebaseCrash.log("Application injector initialized");
    }

    public AppComponent getAppComponent(){
        return this.appComponent;
    }

    private void initializeLeakDetection(){
        if(BuildConfig.DEBUG){
            if(LeakCanary.isInAnalyzerProcess(this)){
                return;
            }
            LeakCanary.install(this);
        }
    }
}