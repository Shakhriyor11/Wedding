package com.example.wedding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Image;
import com.example.wedding.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Image> images;

    public ImageAdapter(Context context, List<Image> images) {
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.image_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        Image image = images.get(position);
        holder.imageView.setImageResource(image.getImgResource());
        holder.imageView1.setImageResource(image.getImgResource1());
        holder.imageView2.setImageResource(image.getImgResource2());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final ImageView imageView1;
        final ImageView imageView2;

        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.mainImg);
            imageView1 = view.findViewById(R.id.img1);
            imageView2 = view.findViewById(R.id.img2);
        }
    }
}
