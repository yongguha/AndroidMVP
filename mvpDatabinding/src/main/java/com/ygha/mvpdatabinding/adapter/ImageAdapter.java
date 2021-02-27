package com.ygha.mvpdatabinding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ygha.mvpdatabinding.R;
import com.ygha.mvpdatabinding.utils.ImageUtils;
import com.ygha.mvpdatabinding.utils.OnItemClickListener;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> implements  ImageAdapterContract.Model, ImageAdapterContract.View {

    private Context mContext;
    private OnItemClickListener onItemClickListener;
    private ArrayList<Integer> imageItems;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageUtils.load(mContext, imageItems.get(position), holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    @Override
    public int getItem(int position) {
        return imageItems.get(position);
    }

    @Override
    public void setOnClickListener(OnItemClickListener clickListener) {
        this.onItemClickListener = clickListener;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }


    @Override
    public void addItems(ArrayList<Integer> items) {
        if (imageItems == null) {
            imageItems = new ArrayList<>();
        }

        imageItems.addAll(items);
    }

    @Override
    public void updateItems(ArrayList<Integer> items) {
        imageItems=items;
    }

    @Override
    public void clearItem() {
        imageItems.clear();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_view);
        }


    }
}
