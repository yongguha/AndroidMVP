package com.ygha.mvpdatabinding;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.ygha.mvpdatabinding.adapter.ImageAdapter;
import com.ygha.mvpdatabinding.databinding.ActivityMainBinding;
import com.ygha.mvpdatabinding.model.SampleImageRepository;

import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends AppCompatActivity implements MainContract.View{

    ActivityMainBinding mBinding;
    MainPresenter mPresenter;
    SampleImageRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setActivity(this);


        repository = SampleImageRepository.getInstance();
        ImageAdapter imageAdapter = new ImageAdapter(this);

        mPresenter = new MainPresenter(this, repository);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(imageAdapter);


        mPresenter.setImageAdapterModel(imageAdapter);
        mPresenter.setImageAdapterView(imageAdapter);


        setupRefreshLayout();
        updateRecyclerView();
    }


    private void updateRecyclerView(){
        mPresenter.updateData(this, false);
    }

    private void setupRefreshLayout() {

        mBinding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Presenter로 데이터 요청 이벤트 전달.
                mPresenter.updateData(MainActivity.this, true);
            }
        });

    }

    @Override
    public void updateRefresh() {
        if (mBinding.swipeRefreshLayout.isRefreshing()) {
            mBinding.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }



}
