package com.ecardero.learningdagger.mvp.main.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.di.component.DaggerCharacterComponent;
import com.ecardero.learningdagger.di.module.ActivityModule;
import com.ecardero.learningdagger.di.module.CharacterModule;
import com.ecardero.learningdagger.mvp.common.model.database.CharacterEntity;
import com.ecardero.learningdagger.mvp.common.view.BaseActivity;
import com.ecardero.learningdagger.mvp.main.contract.MainActivityContract;
import com.ecardero.learningdagger.mvp.main.presenter.MainActivityPresenter;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends BaseActivity<MainActivityPresenter, MainActivityContract.View> implements MainActivityContract.View {



    @Inject Picasso mPicasso;

    @BindView(R.id.bt_main)
    Button mMainButton;

    @BindView(R.id.iv_character_thumb)
    ImageView mCharacterThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initializeDependencies(this);
        initializePresenter(this);
    }

    @Override
    protected void initializeDependencies(Activity activity) {
        super.initializeDependencies(activity);

        DaggerApp app = (DaggerApp) getApplication();

        DaggerCharacterComponent.builder()
                .activityModule(new ActivityModule(this))
                .characterModule(new CharacterModule())
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
        Logger.d(characters.get(0).getName());
        mPicasso.with(this).load(characters.get(0).getThumbnail()).centerCrop().fit().into(mCharacterThumbnail);
        showMessage(characters.get(0).getThumbnail());
    }

    @Override
    public void showMessage(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
