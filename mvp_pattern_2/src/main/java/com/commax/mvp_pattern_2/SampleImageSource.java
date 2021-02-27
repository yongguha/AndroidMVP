package com.commax.mvp_pattern_2;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.Single;

public interface SampleImageSource {

    interface LoadImageCallback{
        void onImageLoaded(ArrayList<ImageItem> list);
    }

    void getImages(Context context, int size, LoadImageCallback loadImageCallback);


}
