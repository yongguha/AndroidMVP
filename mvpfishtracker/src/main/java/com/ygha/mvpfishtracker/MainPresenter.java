package com.ygha.mvpfishtracker;

import android.view.View;

/**
 * Handles actions from the View and updates the UI as needed.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.MvpView mView;

    public MainPresenter(MainContract.MvpView mView) {
        this.mView = mView;
    }

    @Override
    public void handleSignInButtonClick(View view) {
        mView.navigateToSignIn();

    }

    @Override
    public void handleSignUpButtonClick(View view) {
        mView.navigateToSignUp();

    }
}
