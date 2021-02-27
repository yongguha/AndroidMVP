package com.ygha.mvpdatabinding.model;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.Single;

public interface SampleImageSource {

    Single<ArrayList<Integer>> getImages(Context context, int size);

}
