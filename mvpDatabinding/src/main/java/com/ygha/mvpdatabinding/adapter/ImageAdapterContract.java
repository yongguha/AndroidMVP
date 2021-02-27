package com.ygha.mvpdatabinding.adapter;


import com.ygha.mvpdatabinding.utils.OnItemClickListener;

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

        void addItems(ArrayList<Integer> imageItems);

        void updateItems(ArrayList<Integer> items);

        void clearItem();

        int getItem(int position);
    }
}
