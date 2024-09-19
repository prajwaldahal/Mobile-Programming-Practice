package com.example.sqllitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<Contact> contacts;
    private int previousPosition = -1;

    RecyclerViewAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        return new RecyclerViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.tvName.setText(contact.getName());
        holder.tvEmail.setText(contact.getEmail());
        holder.tvPhone.setText(contact.getPhone());

        animateItems(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    private void animateItems(View view, int position) {
        if (position > previousPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            previousPosition = position;
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout llContactItem;
        private ImageView ivImage;
        private TextView tvName, tvEmail, tvPhone;

        RecyclerViewHolder(View item) {
            super(item);
            llContactItem = item.findViewById(R.id.ll_contact_item);
            ivImage = item.findViewById(R.id.contact_image);
            tvName = item.findViewById(R.id.contact_name);
            tvEmail = item.findViewById(R.id.contact_email);
            tvPhone = item.findViewById(R.id.contact_phone);
        }
    }
}
