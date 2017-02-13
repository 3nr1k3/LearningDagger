package com.ecardero.learningdagger.di.module;

import android.content.Context;

import com.ecardero.learningdagger.constants.Constants;
import com.ecardero.learningdagger.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ecardero on 3/02/17.
 */
@Module
public class DatabaseModule {
    private final long mSchemaVersion = Constants.Database.REALM_MIGRATION_VERSION;
    private final String mSchemaName = Constants.Database.REALM_MIGRATION_NAME;
    private final Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }

    @Provides
    @ApplicationScope
    public Realm provideRealm(RealmConfiguration realmConfiguration){
        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getDefaultInstance();
    }

    @Provides
    @ApplicationScope
    public RealmConfiguration provideRealmConfiguration(){
        Realm.init(context);
        return new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(mSchemaVersion)
                .name(mSchemaName)
                .build();
    }
}
