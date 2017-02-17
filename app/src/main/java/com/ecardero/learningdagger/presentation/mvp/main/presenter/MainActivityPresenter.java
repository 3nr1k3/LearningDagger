package com.ecardero.learningdagger.presentation.mvp.main.presenter;

import android.support.annotation.NonNull;
import android.util.Log;


import com.ecardero.learningdagger.data.entity.database.CharacterEntity;
import com.ecardero.learningdagger.domain.CharacterRepository;
import com.ecardero.learningdagger.domain.interactor.GetCharactersByName;
import com.ecardero.learningdagger.presentation.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.presentation.mvp.main.view.MainActivity;
import com.google.firebase.crash.FirebaseCrash;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by ecardero on 3/02/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter<MainActivity> {
    private final String TAG = getClass().getSimpleName();

    MainActivityContract.View mView;

    @Inject Realm mRealm;

    @Inject
    public MainActivityPresenter() {
    }

    @Override
    public void searchCharactersByName(String name) {
        if(name.length() > 3)
            mView.showMessage(name);

    }

    @Override
    public void attachView(@NonNull MainActivity view) {
        mView = view;
    }
}
