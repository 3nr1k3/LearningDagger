package com.ecardero.learningdagger.mvp.main.presenter;

import android.support.annotation.NonNull;

import com.ecardero.learningdagger.mvp.common.model.database.CharacterEntity;
import com.ecardero.learningdagger.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.mvp.main.view.MainActivity;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by ecardero on 3/02/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter<MainActivity> {

    MainActivityContract.View mView;

    @Inject List<CharacterEntity> mCharacters;

    @Inject Realm mRealm;

    @Inject
    public MainActivityPresenter() {
    }

    @Override
    public void searchCharactersByName(String name) {
        if(name.length() > 3)
            mView.updateCharactersList(mCharacters);
    }

    @Override
    public void attachView(@NonNull MainActivity view) {
        mView = view;
    }
}
