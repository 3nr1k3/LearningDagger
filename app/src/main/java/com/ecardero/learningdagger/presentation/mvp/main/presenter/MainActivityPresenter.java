package com.ecardero.learningdagger.presentation.mvp.main.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.ecardero.learningdagger.data.entity.service.StarWarsApi.Character;
import com.ecardero.learningdagger.presentation.mvp.common.presenter.BasePresenter;
import com.ecardero.learningdagger.presentation.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.presentation.mvp.main.view.MainActivity;
import com.ecardero.learningdagger.presentation.service.StarWarsService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crash.FirebaseCrash;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.realm.Realm;

/**
 * Created by ecardero on 3/02/17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivity> implements MainActivityContract.Presenter<MainActivity> {

    MainActivityContract.View mView;

    //region Injected in constructor properties
    @Inject Realm mRealm;

    @Inject StarWarsService mStarWarsService;

    @Inject FirebaseAuth mFirebaseAuth;
    @Inject FirebaseAuth.AuthStateListener mFirebaseAuthStateListener;

    @Inject @Named("UiThread") Scheduler mUiThread;
    @Inject @Named("ExecutorThread") Scheduler mExecutorThread;
    //endregion

    FirebaseUser mFirebaseUser;


    @Inject
    public MainActivityPresenter(
    ) {
    }

    @Override
    public void searchCharactersByName(String name) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("containsName", name);

        mStarWarsService.getCharacters(headerMap)
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread)
                .subscribe(
                        c -> {
                                if(!c.isEmpty() && c.size() > 1)
                                    mView.showMessage(String.format("%s +%d", c.get(0).getName(), c.size()-1));
                                else if(c.size() == 1)
                                    mView.showMessage(c.get(0).getName());
                                else
                                    mView.showMessage("None found");
                            },
                        FirebaseCrash::report // will throw this error into Firebase if none is returned
                );

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
