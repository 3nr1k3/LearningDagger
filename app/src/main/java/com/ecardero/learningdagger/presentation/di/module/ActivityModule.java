package com.ecardero.learningdagger.presentation.di.module;

import android.app.Activity;

import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ecardero on 6/02/17.
 */

@Module
public class ActivityModule {
    Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity activity(){
        return this.activity;
    }
}
