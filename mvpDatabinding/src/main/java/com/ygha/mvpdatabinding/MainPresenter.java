package com.ygha.mvpdatabinding;

import android.content.Context;


import com.ygha.mvpdatabinding.adapter.ImageAdapterContract;
import com.ygha.mvpdatabinding.model.SampleImageRepository;
import com.ygha.mvpdatabinding.utils.OnItemClickListener;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements OnItemClickListener,MainContract.Presenter
{


    private MainContract.View view;

    private ImageAdapterContract.Model adapterModel;
    private ImageAdapterContract.View adapterView;

    private SampleImageRepository sampleImageData;

    public MainPresenter(MainContract.View view, SampleImageRepository repository) {
        this.view = view;
        sampleImageData = repository;
    }

    @Override
    public void setImageAdapterModel(ImageAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageAdapterContract.View adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {

    }


    @Override
    public void updateData(Context context, final boolean isUpdate) {

        sampleImageData.getImages(context, 10)
                .doOnSuccess(x->{
                    if (!isUpdate) {
                        adapterModel.addItems(x);
                    } else {
                        adapterModel.updateItems(x);
                    }
                } )
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        x->{
                            // adapterView UI 갱신 이벤트 전달.
                            adapterView.notifyAdapter();
                            // view에 UI 갱신 이벤트 전달.
                           // view.updateRefresh();
                        });
    }


    private Consumer<ArrayList<Integer>> updateView() {
        return (x)->{
            // adapterView UI 갱신 이벤트 전달.
            adapterView.notifyAdapter();
            // view에 UI 갱신 이벤트 전달.
            view.updateRefresh();
        };
    }
    private Consumer<ArrayList<Integer>>addItems(final boolean isUpdate){
        return (x)->{
            if (!isUpdate) {
                adapterModel.addItems(x);
            } else {
                adapterModel.updateItems(x);
            }
        };
    }




}
