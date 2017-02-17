package com.ecardero.learningdagger.presentation.di.module;

import android.content.Context;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.domain.CharacterRepository;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    @Provides
    @ApplicationScope
    @Named("UiThread")
    public Scheduler provideUiScheduler(){
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @ApplicationScope
    @Named("ExecutorThread")
    public Scheduler provideScheduler(){
        return Schedulers.newThread();
    }
}