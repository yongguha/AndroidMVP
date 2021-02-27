package com.ygha.baseproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.ygha.baseproject.adapter.ImageAdapter;
import com.ygha.baseproject.base.BaseActivity;
import com.ygha.baseproject.databinding.ActivityMainBinding;
import com.ygha.baseproject.model.SampleImageRepository;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View{

    RecyclerView recyclerView;
    private ImageAdapter imageAdapter;

    SwipeRefreshLayout refreshLayout;

    protected MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter();
        mPresenter.setView(this);

        initPresenter();
        setupRefreshLayout();
        setUpRecyclerView();
    }



    private void initPresenter(){

        imageAdapter = new ImageAdapter(this);
        //mPresenter.setView(this);
        mPresenter.setImageAdapterModel(imageAdapter);
        mPresenter.setImageAdapterView(imageAdapter);

        mPresenter.setSampleImageData(SampleImageRepository.getInstance());

    }

    private void setUpRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageAdapter);
        mPresenter.updateData(this, false);
    }

    private void setupRefreshLayout() {
        /*
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Presenter로 데이터 요청 이벤트 전달.
                mPresenter.updateData(MainActivity.this, true);
            }
        });

         */
    }

    @Override
    public void updateRefresh() {
        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }



}
