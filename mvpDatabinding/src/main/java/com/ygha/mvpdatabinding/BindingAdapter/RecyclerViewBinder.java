package com.ygha.mvpdatabinding.BindingAdapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ygha.mvpdatabinding.adapter.ImageAdapter;


public class RecyclerViewBinder {

    @BindingAdapter("recyclerView")
    public static void setRecyclerViews(RecyclerView view, String dummy){
        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
        if(layoutManager==null)
            view.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ImageAdapter adapter = (ImageAdapter)view.getAdapter();
        if(adapter==null){
            adapter = new ImageAdapter(view.getContext());
            view.setAdapter(adapter);
        }
    }
}
