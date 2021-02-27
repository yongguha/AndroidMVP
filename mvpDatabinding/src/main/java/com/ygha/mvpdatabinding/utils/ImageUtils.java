package com.ygha.mvpdatabinding.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

/**
 * Created by juyounglee on 2017. 11. 3..
 */

public class ImageUtils {
    public static void load(@NonNull Context context, @NonNull Integer resourceId, @NonNull ImageView targetView) {
        Glide
                .with(context)
                .load(resourceId)
                .centerCrop()
                .into(targetView);
    }

}
