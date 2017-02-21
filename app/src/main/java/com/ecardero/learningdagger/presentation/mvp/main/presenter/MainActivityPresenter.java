package com.ecardero.learningdagger.presentation.mvp.main.presenter;

import android.support.annotation.NonNull;

import com.ecardero.learningdagger.presentation.mvp.common.presenter.BasePresenter;
import com.ecardero.learningdagger.presentation.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.presentation.mvp.main.view.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by ecardero on 3/02/17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivity> implements MainActivityContract.Presenter<MainActivity> {

    MainActivityContract.View mView;

    //region Injected in constructor properties
    @Inject Realm mRealm;
    @Inject FirebaseAuth mFirebaseAuth;
    @Inject FirebaseAuth.AuthStateListener mFirebaseAuthStateListener;
    //endregion

    FirebaseUser mFirebaseUser;


    @Inject
    public MainActivityPresenter(
    ) {
    }

    @Override
    public void searchCharactersByName(String name) {

        if(name.length() > 3)
            mView.showMessage(name);
    }

    @Override
    public void onStart() {
        super.onStart();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
    }

    @Override
    public void attachView(@NonNull MainActivity view) {
        mView = view;
    }
}
