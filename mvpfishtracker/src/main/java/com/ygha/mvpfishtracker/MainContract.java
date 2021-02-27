package com.ygha.mvpfishtracker;

import android.view.View;

/**
 * Defines the contract between the View {@link MainActivity} and the Presenter
 * {@link MainPresenter}
 */

public interface MainContract {
    interface MvpView {
        void navigateToSignIn();

        void navigateToSignUp();
    }
    interface Presenter {
        void handleSignInButtonClick(View view);

        void handleSignUpButtonClick(View view);
    }
}
