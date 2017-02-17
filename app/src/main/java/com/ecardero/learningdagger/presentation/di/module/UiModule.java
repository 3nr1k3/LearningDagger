package com.ecardero.learningdagger.presentation.di.module;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ecardero on 9/02/17.
 */

@Module(includes = AppModule.class)
public class UiModule {


    public UiModule(){}

    @Provides
    @ApplicationScope
    public Picasso providePicasso(
            @Named("AppContext") Context context,
            OkHttp3Downloader okHttp3Downloader
    ){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build()
                .with(context);
    }


    @Provides
    @ApplicationScope
    public GlideBuilder provideGlideBuilder(
            @Named("AppContext") Context context
    ){
        return new GlideBuilder(context);
    }
}
