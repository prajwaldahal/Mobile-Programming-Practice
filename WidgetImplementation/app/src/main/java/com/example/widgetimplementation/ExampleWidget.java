package com.example.widgetimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class ExampleWidget extends AppCompatActivity {
    VideoView vv;
    CalendarView cv;

    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_widget);
        vv=findViewById(R.id.video_one);
        String path="android.resource://"+getPackageName()+"/"+R.raw.test;
        Uri uri = Uri.parse(path);
        vv.setVideoURI(uri);

        MediaController mdc = new MediaController(this);
        vv.setMediaController(mdc);
        mdc.setAnchorView(vv);

        cv=findViewById(R.id.calendar_view);
        long y = cv.getDate();
        System.out.println(y+"hello");

        sv=findViewById(R.id.searchv);
        String s = (String) sv.getQuery();


    }
}