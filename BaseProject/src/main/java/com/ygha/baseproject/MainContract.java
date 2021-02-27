package com.ygha.baseproject;

import android.content.Context;

import com.ygha.baseproject.base.BasePresenter;
import com.ygha.baseproject.base.BaseView;
import com.ygha.baseproject.model.SampleImageRepository;

public interface MainContract {

    interface View extends BaseView {
        void showToast(String title);
        void updateRefresh();
    }

    interface Presenter extends BasePresenter<View> {

        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);
        void setImageAdapterView(ImageAdapterContract.View adapterView);

        void setSampleImageData(SampleImageRepository sampleIamgeData);
        void updateData(Context context, boolean isUpdate);
    }


}
