package com.ecardero.learningdagger.presentation.mvp.main.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.data.entity.database.CharacterEntity;
import com.ecardero.learningdagger.data.entity.service.StarWarsApi.Character;
import com.ecardero.learningdagger.presentation.di.component.DaggerCharacterComponent;
import com.ecardero.learningdagger.presentation.di.module.ActivityModule;
import com.ecardero.learningdagger.presentation.mvp.common.view.BaseActivity;
import com.ecardero.learningdagger.presentation.mvp.main.adapter.CharacterAdapter;
import com.ecardero.learningdagger.presentation.mvp.main.adapter.CharacterAdapterCallback;
import com.ecardero.learningdagger.presentation.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.presentation.mvp.main.presenter.MainActivityPresenter;
import com.google.firebase.crash.FirebaseCrash;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MainActivity extends BaseActivity<MainActivityPresenter, MainActivityContract.View> implements MainActivityContract.View, CharacterAdapterCallback {

    @Inject Picasso mPicasso;
    @Inject Activity mActivity;

    @Inject CharacterAdapter mAdapter;
    
    //region Butterknife declarations
    @BindView(R.id.et_characters_name) EditText mCharacterName;
    @BindView(R.id.rv_characters_list) RecyclerView mCharacterListRecycler;
    //endregion


    @Override
    @SuppressLint("MissingSuperCall")
    protected void onCreate(Bundle savedInstanceState) {
        initializeDependencies(this);
        super.onCreate(savedInstanceState, this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initializePresenter(this);
        initializeAdapter();

        FirebaseCrash.log("MainActivity created");
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void initializeDependencies(Activity activity) {
        super.initializeDependencies(activity);

        DaggerApp app = (DaggerApp) getApplication();

        DaggerCharacterComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(app.getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void initializePresenter(MainActivityContract.View view) {
        super.initializePresenter(view);
    }

    @Override
    public void initializeAdapter() {
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mCharacterListRecycler.setLayoutManager(layoutManager);
        mCharacterListRecycler.setAdapter(mAdapter);
    }

    @OnTextChanged(
            value = R.id.et_characters_name,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED
    )
    void onHeroNameChanged(Editable editable){
        super.mPresenter.searchCharactersByName(editable.toString());
    }

    @Override
    public void updateCharactersList(List<Character> characters) {
        mAdapter.updateCharacters(characters);
        mAdapter.notifyDataSetChanged();
        showMessage(characters.get(0).getName());
    }

    @Override
    public void showMessage(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickCharacter(Character item) {
        Logger.d(item);
    }
}
