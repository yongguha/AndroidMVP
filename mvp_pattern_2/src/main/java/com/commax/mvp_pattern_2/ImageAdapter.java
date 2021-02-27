package com.commax.mvp_pattern_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements  ImageAdapterContract.Model, ImageAdapterContract.View {

    private OnItemClickListener onItemClickListener;

    private ArrayList<ImageItem> imageItems;

    @Override
    public void addItems(ArrayList<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public void clearItem() {
        if (imageItems != null) {
            imageItems.clear();
        }
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return imageItems != null ? imageItems.size() : 0;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.onBind(getItem(position), position);
    }

    @Override
    public void setOnClickListener(OnItemClickListener clickListener) {
        this.onItemClickListener = clickListener;
    }

    @Override
    public ImageItem getItem(int position) {
        return imageItems.get(position);
    }
}
