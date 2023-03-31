package com.example.wedding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.R;
import com.example.wedding.VpEvents;

import java.util.ArrayList;

public class VpEventsAdapter extends RecyclerView.Adapter<VpEventsAdapter.ViewHolder> {

    private ArrayList<VpEvents> events;
    private OnCheckedListener listener;

    public VpEventsAdapter(ArrayList<VpEvents> events, OnCheckedListener listener) {
        this.events = events;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(events.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvTitle;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            checkBox = itemView.findViewById(R.id.vpCheckBox);
        }

        public void onBind(final VpEvents events, OnCheckedListener listener) {
            imageView.setImageResource(events.getImgs());
            tvTitle.setText(events.getTitle());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickChecked(events);
                }
            });

        }
    }

    public interface OnCheckedListener {
        void onClickChecked(VpEvents events);
    }
}
