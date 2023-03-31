package com.example.wedding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Image;
import com.example.wedding.Image2;
import com.example.wedding.R;

import java.util.List;

public class ImageAdapter2 extends RecyclerView.Adapter<ImageAdapter2.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Image2> images2;


    public ImageAdapter2(Context context, List<Image2> images2) {
        this.images2 = images2;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ImageAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.image_item2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter2.ViewHolder holder, int position) {
        Image2 image2 = images2.get(position);
        holder.imgView.setImageResource(image2.getImageResource());
    }

    @Override
    public int getItemCount() {
        return images2.size();
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder {
        final ImageView imgView;
        ViewHolder(View view) {
            super(view);
            imgView = view.findViewById(R.id.image_view2);
        }
    }
}
