package com.ygha.baseproject.model;

import android.content.Context;

import com.ygha.baseproject.adapter.ImageItem;

import java.util.ArrayList;

import io.reactivex.Single;

public interface SampleImageSource {

    Single<ArrayList<Integer>> getImages(Context context, int size);

}
