package com.ecardero.learningdagger;

import android.app.Application;

import com.ecardero.learningdagger.di.component.AppComponent;
import com.ecardero.learningdagger.di.component.DaggerAppComponent;
import com.ecardero.learningdagger.di.module.AppModule;
import com.ecardero.learningdagger.di.module.DatabaseModule;

/**
 * Created by ecardero on 3/02/17.
 */

public class DaggerApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return this.appComponent;
    }

    private void initializeLeakDetection(){
        if(BuildConfig.DEBUG){
            //LeakCanary.install(this);
        }
    }
}