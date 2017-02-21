package com.ecardero.learningdagger.presentation.di.component;

import android.app.Activity;

import com.ecardero.learningdagger.domain.CharacterRepository;
import com.ecardero.learningdagger.presentation.di.module.ActivityModule;
import com.ecardero.learningdagger.presentation.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by ecardero on 6/02/17.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {
                ActivityModule.class,
        }
)
public interface ActivityComponent {
    void inject(Activity activity);

    Activity activity();
}
