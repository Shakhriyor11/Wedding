package com.example.wedding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.R;
import com.example.wedding.Services;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private final List<Services> services;
    private OnItemTouchClickListener listener;

    public ServiceAdapter(List<Services> services, OnItemTouchClickListener listener) {
        this.services = services;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(services.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView servicesImg;
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvPrice;
        final AppCompatButton button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            servicesImg = itemView.findViewById(R.id.ivServices);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            button = itemView.findViewById(R.id.button_select);

        }

        public void onBind(final Services services, OnItemTouchClickListener listener) {
            servicesImg.setImageResource(services.getServicesImg());
            tvTitle.setText(services.getServicesTitle());
            tvDescription.setText(services.getServicesDescription());
            tvPrice.setText(services.getServicesPrice());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(services);
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onButtonClick(services);
                }
            });

        }


    }


    public interface OnItemTouchClickListener {
        void onItemClick(Services services);
        void onButtonClick(Services services);
    }
}


