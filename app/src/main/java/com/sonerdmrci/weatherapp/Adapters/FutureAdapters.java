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
import com.sonerdmrci.weatherapp.Domains.FutureDomain;
import com.sonerdmrci.weatherapp.R;

import java.util.ArrayList;

public class FutureAdapters extends RecyclerView.Adapter<FutureAdapters.viewHolder> {
    ArrayList<FutureDomain> items;
    Context context;

    public FutureAdapters(ArrayList<FutureDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FutureAdapters.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutholder_future,parent,false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapters.viewHolder holder, int position) {

        holder.dayTextView.setText(items.get(position).getDay());
        holder.statusTextView.setText(items.get(position).getStatus());
        holder.lowTextView.setText(items.get(position).getLowTemp()+"");
        holder.highTextView.setText(items.get(position).getHighTemp()+"°");

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicturePath(),
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
        TextView dayTextView, statusTextView, lowTextView, highTextView ;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            dayTextView = itemView.findViewById(R.id.dayTextView);
            statusTextView = itemView.findViewById(R.id.statusText);
            lowTextView = itemView.findViewById(R.id.lowTextView);
            highTextView = itemView.findViewById(R.id.highTextView);
            imageView = itemView.findViewById(R.id.pictureImg);
        }
    }
}
