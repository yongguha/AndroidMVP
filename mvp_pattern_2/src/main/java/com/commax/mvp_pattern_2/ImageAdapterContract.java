package com.commax.mvp_pattern_2;

import java.util.ArrayList;



/**
 * Created by tae-hwan on 12/27/16.
 */
public interface ImageAdapterContract {

    interface View {

        void setOnClickListener(OnItemClickListener clickListener);

        void notifyAdapter();
    }

    interface Model {

        void addItems(ArrayList<ImageItem> imageItems);

        void clearItem();

        ImageItem getItem(int position);
    }
}
