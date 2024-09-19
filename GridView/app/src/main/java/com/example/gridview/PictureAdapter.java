package com.example.gridview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

public class PictureAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Picture> pictures;
    Context context;

    public PictureAdapter(Context context, ArrayList<Picture> pictures) {
        this.layoutInflater = LayoutInflater.from(context);
        this.pictures = pictures;
        this.context=context;
    }

    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public Object getItem(int position) {
        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pictures.get(position).getId();
    }

    @SuppressLint("CheckResult")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView name;
        ImageView img;

        Picture picture= (Picture) getItem(position);

        if(convertView==null)
            convertView=layoutInflater.inflate(R.layout.custom_layout,parent,false);


        name=convertView.findViewById(R.id.name);
        img=convertView.findViewById(R.id.image);

        Animation animation=AnimationUtils.loadAnimation(context,android.R.anim.slide_out_right);
        img.setAnimation(animation);
        name.setText(picture.getName());

        Glide.with(convertView).load(picture.getUrl()).into(img);

        return convertView;
    }
}
