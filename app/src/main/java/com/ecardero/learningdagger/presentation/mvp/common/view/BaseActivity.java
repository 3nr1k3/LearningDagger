package com.ecardero.learningdagger.presentation.mvp.common.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.constants.Constants;
import com.ecardero.learningdagger.presentation.di.component.AppComponent;
import com.ecardero.learningdagger.presentation.mvp.common.contract.BaseContract;
import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

/**           _MMMMM`
 *     __MMMMMMMMM`       J        openTrends Solucions i Sistemes, S.L.
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
 *
 *                                 This program is free software; you can redistribute it and/or modify
 *                                 it under the terms of the GNU General Public License as published by
 *                                 the Free Software Foundation; either version 2 of the License, or
 *                                 (at your option) any later version.
 *
 *                                 This program is distributed in the hope that it will be useful,
 *                                 but WITHOUT ANY WARRANTY; without even the implied warranty of
 *                                 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *                                 GNU General Public License for more details.
 *
 *                                 You should have received a copy of the GNU General Public License along
 *                                 with this program; if not, write to the Free Software Foundation, Inc.,
 *                                 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

public abstract class BaseActivity<P extends BaseContract.Presenter, V extends BaseContract.View> extends AppCompatActivity implements BaseContract.View {

    @Inject protected P mPresenter;
    @Inject protected FirebaseAnalytics mFirebaseAnalytics;

    protected void onCreate(@Nullable Bundle savedInstanceState, Activity activity){
        super.onCreate(savedInstanceState);

        Bundle bundle = new Bundle();
        bundle.putString(Constants.CustomFirebase.Params.ACTIVITY_NAME, activity.getClass().getSimpleName());
        mFirebaseAnalytics.logEvent(Constants.CustomFirebase.Event.ACTIVITY_START, bundle);
    }

    protected void initializeDependencies(Activity activity){
        this.getAppComponent().inject(activity);
    }

    protected void initializePresenter(V view){
        mPresenter.attachView(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    private AppComponent getAppComponent(){
        return ((DaggerApp)getApplication()).getAppComponent();
    }
}
