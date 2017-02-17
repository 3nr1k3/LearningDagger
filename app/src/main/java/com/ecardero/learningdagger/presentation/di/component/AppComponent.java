package com.ecardero.learningdagger.presentation.di.component;

import android.app.Activity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.domain.CharacterRepository;
import com.ecardero.learningdagger.presentation.di.module.AppModule;
import com.ecardero.learningdagger.presentation.di.module.DatabaseModule;
import com.ecardero.learningdagger.presentation.di.module.FirebaseModule;
import com.ecardero.learningdagger.presentation.di.module.NetworkModule;
import com.ecardero.learningdagger.presentation.di.module.UiModule;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;
import com.ecardero.learningdagger.service.MarvelService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Component;
import io.reactivex.Scheduler;
import io.realm.Realm;

/**
 * Created by ecardero on 3/02/17.
 */
@ApplicationScope
@Component(modules = {
        AppModule.class,
        DatabaseModule.class,
        NetworkModule.class,
        UiModule.class,
        FirebaseModule.class
})
public interface AppComponent {
    void inject(DaggerApp app);

    void inject(Activity activity);

    DaggerApp application();

    Realm realm();

    Picasso picasso();

    FirebaseAnalytics firebaseAnalytics();
    //CharacterRepository characterRepository();

    //region Services region
    @Named("Marvel")            MarvelService marvelService();
    //endregion

    //region Threading region
    @Named("UiThread")          Scheduler uiThread();
    @Named("ExecutorThread")    Scheduler executorThread();
    //endregion

}