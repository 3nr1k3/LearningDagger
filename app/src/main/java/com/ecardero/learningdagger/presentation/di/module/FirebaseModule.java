package com.ecardero.learningdagger.presentation.di.module;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ecardero.learningdagger.constants.Constants;
import com.ecardero.learningdagger.presentation.di.scope.ApplicationScope;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crash.FirebaseCrash;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

//region Copyright
/*
 * _MMMMM`
 * __MMMMMMMMM`       J        openTrends Solucions i Sistemes, S.L.
 * JMMMMMMMMMMMMF       JM         http://www.opentrends.net
 * MMMMMMMMMMF       _JMM`         info@opentrends.net
 * MMMMMMMF`    .JMMMMF`
 * """")    _JMMMMMMF`
 * _MMMMMMMMMMMMMMM`      .M)      Barcelona, 08020
 * MMMMMMMMMMMMMF`     .JMM`       Spain
 * MMMMMMMMMM"     _MMMMMF
 * M4MMM""`   ._MMMMMMMM`          *************************************
 * _______MMMMMMMMMMMF             LearningDagger
 * MMMMMMMMMMMMMMMM"               *************************************
 * MMMMMMMMMMMMF"                  Copyright (C) 2017 ecardero, Tots els drets reservats
 * MMMMMMMM""                      Copyright (C) 2017 ecardero, All Rights Reserved
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
//endregion

@Module(includes = AppModule.class)
public class FirebaseModule {

    @Provides
    @ApplicationScope
    FirebaseAnalytics provideFirebaseAnalytics(@Named("AppContext") Context context){
        return FirebaseAnalytics.getInstance(context);
    }

    @Provides
    @ApplicationScope
    FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    @Provides
    @ApplicationScope
    FirebaseAuth.AuthStateListener provideFirebaseAuthStateListener(FirebaseAuth firebaseAuthUser, FirebaseAnalytics firebaseAnalytics){
        return firebaseAuth -> {
            if(firebaseAuthUser.getCurrentUser() != null){
                Bundle b = new Bundle();
                b.putString(Constants.CustomFirebase.Params.USER_UID, firebaseAuthUser.getCurrentUser().getUid());
                firebaseAnalytics.logEvent(Constants.CustomFirebase.Event.USER_LOGIN, b);

                FirebaseCrash.log("User logged in: " + firebaseAuthUser.getCurrentUser().getDisplayName());
            }else{

                firebaseAnalytics.logEvent(Constants.CustomFirebase.Event.USER_LOGOUT, null);
                FirebaseCrash.log("User logged out");
            }
        };
    }
}
