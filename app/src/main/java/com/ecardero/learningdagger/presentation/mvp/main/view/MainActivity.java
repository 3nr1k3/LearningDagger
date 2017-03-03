package com.ecardero.learningdagger.presentation.mvp.main.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.data.entity.User;
import com.ecardero.learningdagger.data.entity.database.CharacterEntity;
import com.ecardero.learningdagger.presentation.Layout.AvatarView;
import com.ecardero.learningdagger.presentation.di.component.DaggerCharacterComponent;
import com.ecardero.learningdagger.presentation.di.module.ActivityModule;
import com.ecardero.learningdagger.presentation.mvp.common.view.BaseActivity;
import com.ecardero.learningdagger.presentation.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.presentation.mvp.main.presenter.MainActivityPresenter;
import com.google.firebase.crash.FirebaseCrash;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends BaseActivity<MainActivityPresenter, MainActivityContract.View> implements MainActivityContract.View {

    @Inject Picasso mPicasso;
    @Inject Activity mActivity;

    //region Butterknife declarations
    @BindView(R.id.bt_main)             Button mMainButton;
    @BindView(R.id.iv_character_thumb)  ImageView mCharacterThumbnail;
    //endregion


    @Override
    @SuppressLint("MissingSuperCall")
    protected void onCreate(Bundle savedInstanceState) {
        initializeDependencies(this);
        super.onCreate(savedInstanceState, this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initializePresenter(this);

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

    @OnClick(R.id.bt_main)
    void clickTestButton(){
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(
            value = R.id.et_character_name,
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED
    )
    void onHeroNameChanged(Editable editable){
        super.mPresenter.searchCharactersByName(editable.toString());
    }

    @Override
    public void updateCharactersList(List<CharacterEntity> characters) {
        mPicasso.load(characters.get(0).getThumbnail()).centerCrop().fit().into(mCharacterThumbnail);
        showMessage(characters.get(0).getThumbnail());
    }

    @Override
    public void showMessage(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
