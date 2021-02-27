package com.commax.mvp_pattern_2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View{

   // @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ImageAdapter imageAdapter;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ButterKnife.bind(this);

        imageAdapter = new ImageAdapter();
        recyclerView.setAdapter(imageAdapter);

        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.setImageAdapterModel(imageAdapter);
        mainPresenter.setImageAdapterView(imageAdapter);
        mainPresenter.setSampleImageData(SampleImageRepository.getInstance());


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.loadItems(this, false);


    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mainPresenter.detachView();
    }

}
