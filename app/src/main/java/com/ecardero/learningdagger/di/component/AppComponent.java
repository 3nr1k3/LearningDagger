package com.ecardero.learningdagger.di.component;

import android.app.Activity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.di.module.AppModule;
import com.ecardero.learningdagger.di.module.DatabaseModule;
import com.ecardero.learningdagger.di.module.NetworkModule;
import com.ecardero.learningdagger.di.module.UiModule;
import com.ecardero.learningdagger.di.scope.ApplicationScope;
import com.ecardero.learningdagger.mvp.common.view.BaseActivity;
import com.ecardero.learningdagger.mvp.main.view.MainActivity;
import com.ecardero.learningdagger.service.MarvelService;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by ecardero on 3/02/17.
 */
@ApplicationScope
@Component(modules = {
        AppModule.class,
        DatabaseModule.class,
        NetworkModule.class,
        UiModule.class
})
public interface AppComponent {
    void inject(Activity activity);

    DaggerApp application();

    Realm realm();

    Picasso picasso();

    @Named("Marvel")
    MarvelService marvelService();
}