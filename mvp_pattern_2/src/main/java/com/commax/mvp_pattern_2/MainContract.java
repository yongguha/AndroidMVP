package com.commax.mvp_pattern_2;

import android.content.Context;

public interface MainContract {

    interface View{
        void showToast(String title);
    }

    interface Presenter{
        void attachView(View v);
        void detachView();

        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);
        void setImageAdapterView(ImageAdapterContract.View adapterView);

        void setSampleImageData(SampleImageRepository sampleIamgeData);
        void loadItems(Context context, boolean isClear);
    }


}
