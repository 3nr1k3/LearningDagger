package com.ecardero.learningdagger.presentation.di.component;

import com.ecardero.learningdagger.data.entity.database.CharacterEntity;
import com.ecardero.learningdagger.presentation.di.module.ActivityModule;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.mvp.main.view.MainActivity;

import java.util.List;

import dagger.Component;

/**
 * Created by ecardero on 6/02/17.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {
                ActivityModule.class
        }
)
public interface CharacterComponent extends ActivityComponent{
    void inject(MainActivity mainActivity);
}
