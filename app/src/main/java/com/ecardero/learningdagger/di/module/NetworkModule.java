package com.ecardero.learningdagger.di.module;

import android.content.Context;

import com.ecardero.learningdagger.di.scope.ApplicationScope;
import com.ecardero.learningdagger.helper.Md5Helper;
import com.ecardero.learningdagger.service.MarvelService;
import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.joda.time.DateTime;

import java.io.File;
import java.util.Date;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static com.ecardero.learningdagger.constants.Constants.MarvelService.PRIVATE_API_KEY;
import static com.ecardero.learningdagger.constants.Constants.MarvelService.PUBLIC_API_KEY;
import static com.ecardero.learningdagger.constants.Constants.MarvelService.SERVICE_URL;

/**
 * Created by ecardero on 3/02/17.
 */
@Module(includes = AppModule.class)
public class NetworkModule {
    private static final String mApiKey = PUBLIC_API_KEY;
    private static final String mPrivateKey = PRIVATE_API_KEY;

    @Provides
    @ApplicationScope
    @Named("Marvel")
    public MarvelService provideMarvelService(Retrofit retrofit){
        return retrofit.create(MarvelService.class);
    }

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofitBuilder(
            @Named("interceptor_client") OkHttpClient okHttpClient,
            GsonConverterFactory gsonConverterFactory,
            RxJava2CallAdapterFactory callAdapterFactory
            ){
        return new Retrofit.Builder()
                .baseUrl(SERVICE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    @Named("interceptor_client")
    public OkHttpClient provideOkHttpClient(Interceptor apiInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(apiInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @ApplicationScope
    public Cache provideCache(File file){
        return new Cache(file, 10 * 1000 * 1000);
    }

    @Provides
    @ApplicationScope
    public File provideFile(@Named("AppContext") Context context){
        File cacheFile = new File(context.getCacheDir(), "okhttp_cache");
        cacheFile.mkdirs();
        return cacheFile;
    }

    @Provides
    @ApplicationScope
    public OkHttp3Downloader provideOkHttp3Downloader(
            @Named("picasso_client") OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    @ApplicationScope
    @Named("picasso_client")
    public OkHttpClient provideOkHttpClientPicasso(){
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @ApplicationScope
    public Interceptor provideInterceptor(){
        return chain -> {
            Request request = chain.request();
            request.newBuilder().addHeader("Content-Type", "application/json").build();

            Date now = new Date();
            String timeStamp = String.valueOf(now.getTime());

            HttpUrl url = request.url().newBuilder()
                    .addEncodedQueryParameter("apikey", mApiKey)
                    .addEncodedQueryParameter("ts", timeStamp)
                    .addEncodedQueryParameter("hash", Md5Helper.hash(mApiKey, mPrivateKey, timeStamp))
                    .build();

            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        };
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor(message -> {
            Timber.i(message);
            //Logger.
        });
    }

    @Provides
    @ApplicationScope
    public GsonConverterFactory provideGsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @ApplicationScope
    public Gson provideGson(){

        return new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTimeConverter())
                .create();
    }

    @Provides
    @ApplicationScope
    public RxJava2CallAdapterFactory provideRxJavaAdapterFactory(@Named("executor_thread") Scheduler scheduler){
        return RxJava2CallAdapterFactory.createWithScheduler(scheduler);
    }


    @Provides
    @Named("ui_thread")
    public Scheduler provideUiScheduler(){
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @ApplicationScope
    @Named("executor_thread")
    public Scheduler provideScheduler(){
        return Schedulers.newThread();
    }
}
