package com.sonerdmrci.weatherapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sonerdmrci.weatherapp.Domains.Hourly;
import com.sonerdmrci.weatherapp.R;

import java.util.ArrayList;

public class HourlyAdapters extends RecyclerView.Adapter<HourlyAdapters.viewHolder> {
    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapters(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HourlyAdapters.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly,parent,false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapters.viewHolder holder, int position) {
        holder.hourText.setText(items.get(position).getHour());
        holder.tempText.setText(items.get(position).getTemp()+"°");

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(),
                "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView hourText, tempText;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            hourText = itemView.findViewById(R.id.hourTextView);
            tempText = itemView.findViewById(R.id.tempTextView);
            imageView = itemView.findViewById(R.id.pictureView);
        }
    }
}
