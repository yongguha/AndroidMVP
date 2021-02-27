package com.commax.mvp_pattern_2;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SampleImageLocalDataSource implements SampleImageSource {


    @Override
    public void getImages(Context context, int size, LoadImageCallback loadImageCallback) {
        ArrayList<ImageItem> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int random = (int) (Math.random() * 15);
            final String name = String.format("sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        if (loadImageCallback != null) {
            loadImageCallback.onImageLoaded(items);
        }
    }

}
