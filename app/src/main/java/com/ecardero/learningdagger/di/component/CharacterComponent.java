package com.ecardero.learningdagger.di.component;

import com.ecardero.learningdagger.di.module.ActivityModule;
import com.ecardero.learningdagger.di.module.CharacterModule;
import com.ecardero.learningdagger.di.scope.ActivityScope;
import com.ecardero.learningdagger.mvp.common.model.database.CharacterEntity;
import com.ecardero.learningdagger.mvp.main.view.MainActivity;

import java.util.List;

import dagger.Component;

/**
 * Created by ecardero on 6/02/17.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {
                ActivityModule.class,
                CharacterModule.class
        }
)
public interface CharacterComponent extends ActivityComponent{
    void inject(MainActivity mainActivity);

    List<CharacterEntity> characters();
}
