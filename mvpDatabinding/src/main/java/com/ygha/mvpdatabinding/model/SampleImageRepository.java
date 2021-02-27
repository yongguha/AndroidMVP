package com.ygha.mvpdatabinding.model;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.Single;

public class SampleImageRepository implements SampleImageSource{

    private static SampleImageRepository sampleImageRepository;

    public static SampleImageRepository getInstance() {
        if (sampleImageRepository == null) {
            sampleImageRepository = new SampleImageRepository();
        }
        return sampleImageRepository;
    }

    private SampleImageLocalDataSource sampleImageLocalDataSource;

    private SampleImageRepository() {
        sampleImageLocalDataSource = new SampleImageLocalDataSource();
    }

    @Override
    public Single<ArrayList<Integer>> getImages(Context context, int size) {
        return sampleImageLocalDataSource.getImages(context,size );
    }
}
