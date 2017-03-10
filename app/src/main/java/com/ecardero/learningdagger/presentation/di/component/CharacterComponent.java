package com.ecardero.learningdagger.presentation.di.component;

import com.ecardero.learningdagger.presentation.di.module.ActivityModule;
import com.ecardero.learningdagger.presentation.di.module.CharacterModule;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;
import com.ecardero.learningdagger.presentation.mvp.main.adapter.CharacterAdapter;
import com.ecardero.learningdagger.presentation.mvp.main.view.MainActivity;

import dagger.Component;

/**
 * Created by ecardero on 6/02/17.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {
                CharacterModule.class,
                ActivityModule.class
        }
)
public interface CharacterComponent extends ActivityComponent{
    void inject(MainActivity mainActivity);

    CharacterAdapter adapter();
}
