package com.ygha.baseproject.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.ygha.baseproject.adapter.ImageItem;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SampleImageLocalDataSource implements SampleImageSource {

    @Override
    public Single<ArrayList<Integer>> getImages(Context context, int size) {
        return Observable.range(0, size)
                .map(i ->convertData(context))
                .toList()
                .doOnSuccess(s-> Log.e("doOnSuccess","doOnSuccess in getImages"))
                .map(ArrayList::new);
    }

    @NonNull
    private Integer convertData(Context context) {
        int randomIndex = (int) (Math.random() * 30) + 1;
        String resourceName = String.format("resource_%02d", randomIndex);
        return context.getResources().getIdentifier(resourceName, "drawable", context.getApplicationContext().getPackageName());
    }



}
