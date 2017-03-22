package com.ecardero.learningdagger.presentation.mvp.login.presenter;

import android.app.Activity;

import com.ecardero.learningdagger.presentation.mvp.common.presenter.BasePresenter;
import com.ecardero.learningdagger.presentation.mvp.login.contract.LoginContract;
import com.ecardero.learningdagger.presentation.mvp.login.view.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;

import javax.inject.Inject;

/**
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

public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginContract.Presenter<LoginActivity> {
    private LoginContract.View mView;

    @Inject FirebaseAuth mFirebaseAuth;
    @Inject FirebaseAuth.AuthStateListener mFirebaseAuthStateListener;

    @Inject
    public LoginPresenter(){
    }

    public void login(Activity activity, String login, String password) {
        mView = (LoginContract.View) super.getView();

        mView.showLoadingSpinner(true);
        mFirebaseAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener(activity, task -> {
                    if(!task.isSuccessful()){
                        FirebaseCrash.log("Authentication failed.");
                        mView.showMessage("Authentication failed");
                    }else{
                        mView.showMessage("Welcome " + task.getResult().getUser().getEmail());
                        mView.loginSuccessful();
                    }
                    mView.showLoadingSpinner(false);
                });
    }
}
