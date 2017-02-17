package com.ecardero.learningdagger.presentation.di.module;

import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * Created by ecardero on 10/02/17.
 */
@Module
public class LoggingModule {

    @Provides
    @ApplicationScope
    public Timber provideTimber(){
        return null; //new Timber.Tree().
    }
}
