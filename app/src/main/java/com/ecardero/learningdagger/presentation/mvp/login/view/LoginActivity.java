package com.ecardero.learningdagger.presentation.mvp.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ecardero.learningdagger.DaggerApp;
import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.presentation.di.component.DaggerLoginComponent;
import com.ecardero.learningdagger.presentation.di.module.ActivityModule;
import com.ecardero.learningdagger.presentation.mvp.common.view.BaseActivity;
import com.ecardero.learningdagger.presentation.mvp.login.contract.LoginContract;
import com.ecardero.learningdagger.presentation.mvp.login.presenter.LoginPresenter;
import com.ecardero.learningdagger.presentation.mvp.main.view.MainActivity;
import com.google.firebase.crash.FirebaseCrash;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginContract.View> implements LoginContract.View {

    //region Butterknife properties
    @BindView(R.id.etEmail) EditText mEditEmail;
    @BindView(R.id.etPassword) EditText mEditPassword;
    @BindView(R.id.btLogin) Button mBtnLogin;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeDependencies(this);
        super.onCreate(savedInstanceState, this);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        initializePresenter(this);

        FirebaseCrash.log("LoginActivity created");
    }

    @Override
    protected void initializeDependencies(Activity activity) {
        super.initializeDependencies(activity);

        DaggerApp app = (DaggerApp) getApplication();

        DaggerLoginComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(app.getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void initializePresenter(LoginContract.View view) {
        super.initializePresenter(view);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mPresenter.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mPresenter.onStop();
//    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btLogin)
    protected void loginClick(){
        mPresenter.login(this, mEditEmail.getText().toString(), mEditPassword.getText().toString());
    }
}
