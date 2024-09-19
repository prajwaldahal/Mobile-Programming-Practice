package com.example.myinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RecyclerViewHolder> {

    Context context;
    ArrayList<Information> infos;

    public CustomAdapter(Context context, ArrayList<Information> infos) {
        this.context=context;
        this.infos = infos;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(context).inflate(R.layout.custom_view,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Information information=infos.get(position);
        holder.hobbies.setText(information.getHobbies());
        holder.skills.setText(information.getSkills());
    }


    @Override
    public int getItemCount() {
        return infos.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView hobbies,skills;
       public RecyclerViewHolder(@NonNull View itemView) {
           super(itemView);
           hobbies=itemView.findViewById(R.id.hobbies);
           skills=itemView.findViewById(R.id.skill);

       }
   }
}
