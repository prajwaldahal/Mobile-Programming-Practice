package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RecyclerViewViewHolder> {
    Context context;
    View itemView;
    ArrayList<Information>informations;

    public CustomAdapter(Context context, ArrayList<Information> informations) {
        this.context=context;
        this.informations = informations;
    }

    @NonNull
    @Override

    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false);
        return new RecyclerViewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        Information information= informations.get(position);
        holder.textView.setText(information.getInfo());
        Glide.with(itemView).load(information.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return informations.size();
    }

    public  class RecyclerViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            textView=itemView.findViewById(R.id.textview);
        }
    }
}
