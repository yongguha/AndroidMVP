package com.commax.mvp_pattern_2;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter, OnItemClickListener
{


    private MainContract.View view;

    private ImageAdapterContract.Model adapterModel;
    private ImageAdapterContract.View adapterView;

    private SampleImageRepository sampleImageData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setSampleImageData(SampleImageRepository sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {

        sampleImageData.getImages(context, 10, new SampleImageSource.LoadImageCallback() {
            @Override
            public void onImageLoaded(ArrayList<ImageItem> list) {
                if (list != null) {
                    if (isClear) {
                        adapterModel.clearItem();
                    }
                    adapterModel.addItems(list);
                    adapterView.notifyAdapter();
                }
            }
        });


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
        ImageItem imageItem = adapterModel.getItem(position);
        view.showToast(imageItem.getTitle());
    }
}
