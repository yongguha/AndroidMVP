package com.ygha.mvpdatabinding;

import android.content.Context;

import com.ygha.mvpdatabinding.adapter.ImageAdapterContract;

public interface MainContract {

    interface View{
        void showToast(String title);
        void updateRefresh();
    }

    interface Presenter {

        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);
        void setImageAdapterView(ImageAdapterContract.View adapterView);
        void updateData(Context context, boolean isUpdate);
    }


}
