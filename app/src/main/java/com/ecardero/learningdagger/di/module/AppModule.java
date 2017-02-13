package com.ecardero.learningdagger.di.module;

import android.content.Context;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.di.scope.ApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ecardero on 3/02/17.
 */
@Module
public class AppModule {
    DaggerApp mApplication;

    public AppModule(DaggerApp app) {
        this.mApplication = app;
    }

    @Provides
    @ApplicationScope
    @Named("AppContext")
    public Context provideContext(){
        return this.mApplication.getApplicationContext();
    }

    @Provides
    @ApplicationScope
    public DaggerApp provideApplication(){
        return mApplication;
    }
}