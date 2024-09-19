package com.example.sqllitedemo;

import android.view.View;

public interface OnContactClickListener {
    void onContactClickListener(int position);
    void onContactLongClickListener(int position, View item);
}
