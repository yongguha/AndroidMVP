package com.ygha.mvpfishtracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ygha.mvpfishtracker.databinding.ActivityMainBinding;

/**
 * Displays the Main screen.
 */
public class MainActivity extends AppCompatActivity implements MainContract.MvpView {

    private MainPresenter mPresenter;
    private Button mSignInButton;

    ActivityMainBinding mBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        mBinding.setPresenter(mPresenter);
    }


    @Override
    public void navigateToSignIn() {
        Toast.makeText(this,"Taking user to the Sign in screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToSignUp() {
        Toast.makeText(this,"Taking user to the Sign up screen", Toast.LENGTH_SHORT).show();
    }
}
