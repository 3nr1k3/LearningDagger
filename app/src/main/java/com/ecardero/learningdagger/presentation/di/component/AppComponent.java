package com.ecardero.learningdagger.presentation.di.component;

import android.app.Activity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.presentation.di.module.AppModule;
import com.ecardero.learningdagger.presentation.di.module.DatabaseModule;
import com.ecardero.learningdagger.presentation.di.module.FirebaseModule;
import com.ecardero.learningdagger.presentation.di.module.NetworkModule;
import com.ecardero.learningdagger.presentation.di.module.UiModule;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;
import com.ecardero.learningdagger.presentation.service.MarvelService;
import com.ecardero.learningdagger.presentation.service.StarWarsService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
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

    //region Firebase Components
    FirebaseAnalytics firebaseAnalytics();
    FirebaseAuth firebaseAuth();
    FirebaseAuth.AuthStateListener firebaseAuthStateListener();
//    FirebaseUser firebaseUser();
    //endregion

    //CharacterRepository characterRepository();

    //region Services region
    MarvelService marvelService();
    StarWarsService starWarsService();
    //endregion

    //region Threading region
    @Named("UiThread")          Scheduler uiThread();
    @Named("ExecutorThread")    Scheduler executorThread();
    //endregion

    @Named("LoggingGson")       Gson gson();

}