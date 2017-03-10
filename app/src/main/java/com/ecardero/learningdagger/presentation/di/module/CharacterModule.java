package com.ecardero.learningdagger.presentation.di.module;

import android.content.Context;

import com.ecardero.learningdagger.data.entity.database.CharacterEntity;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.mvp.main.adapter.CharacterAdapter;
import com.ecardero.learningdagger.presentation.mvp.main.adapter.CharacterAdapterCallback;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ecardero on 8/02/17.
 */
@Module
public class CharacterModule {

    @Provides
    @ActivityScope
    CharacterAdapter provideCharacterAdapter(@Named("ActivityContext") Context context ){
        return new CharacterAdapter(context);
    }
}
