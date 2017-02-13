package com.ecardero.learningdagger.di.component;

import android.app.Activity;

import com.ecardero.learningdagger.di.module.ActivityModule;
import com.ecardero.learningdagger.di.scope.ActivityScope;
import com.ecardero.learningdagger.mvp.main.view.MainActivity;

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
    Activity activity();

}
