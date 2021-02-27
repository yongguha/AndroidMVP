package com.commax.mvp_pattern_2;

/**
 * Created by tae-hwan on 10/23/16.
 */
public class ImageItem {

    private int imageRes;
    private String title;

    public ImageItem(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getTitle() {
        return title;
    }
}
