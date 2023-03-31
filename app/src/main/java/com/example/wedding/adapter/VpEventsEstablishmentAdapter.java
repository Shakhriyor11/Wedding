package com.example.wedding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.R;

public class VpEventsEstablishmentAdapter extends RecyclerView.Adapter<VpEventsEstablishmentAdapter.ViewHolder> {

    int[] establishmentImgs;
    String[] establishmentTitle;

    public VpEventsEstablishmentAdapter(int[] establishmentImgs, String[] establishmentTitle) {
        this.establishmentImgs = establishmentImgs;
        this.establishmentTitle = establishmentTitle;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.establishment_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.establishmentImgs.setBackgroundResource(establishmentImgs[position]);
        holder.establishmentTitle.setText(establishmentTitle[position]);
    }

    @Override
    public int getItemCount() {
        return establishmentImgs.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView establishmentImgs;
        TextView establishmentTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            establishmentImgs = itemView.findViewById(R.id.ivEstablishment);
            establishmentTitle = itemView.findViewById(R.id.tvEstablishment);
        }
    }
}
