package com.ecardero.learningdagger.mvp.common.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.di.component.AppComponent;
import com.ecardero.learningdagger.mvp.common.contract.BaseContract;
import com.ecardero.learningdagger.mvp.main.contract.MainActivityContract;

import javax.inject.Inject;

/**
 * Created by ecardero on 6/02/17.
 */

public abstract class BaseActivity<P extends BaseContract.Presenter, V extends BaseContract.View> extends AppCompatActivity implements BaseContract.View {

    @Inject protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initializeDependencies(Activity activity){
        this.getAppComponent().inject(activity);
    }

    protected void initializePresenter(V view){
        mPresenter.attachView(view);
    }

    protected AppComponent getAppComponent(){
        return ((DaggerApp)getApplication()).getAppComponent();
    }
}
