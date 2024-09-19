package com.example.gridview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Picture> Pictures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);
        Pictures=getPictures();
        PictureAdapter pictureAdapter=new PictureAdapter(this,Pictures);
        gridView.setAdapter(pictureAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Picture picture=Pictures.get(position);
            Bundle bundle=new Bundle();
            bundle.putString("imgurl",picture.getUrl());
            CustomFragment customFragment=new CustomFragment();
            customFragment.setArguments(bundle);
            customFragment.setCancelable(true);
            customFragment.show(getSupportFragmentManager(),"custom");
        });
    }

    private ArrayList<Picture> getPictures() {
        ArrayList<Picture>pictures= new ArrayList<>();

        String []name={
                "Ship",
                "Violin",
                "Light House",
                "Bridge",
                "Whale",
                "Bird",
                "Apple",
                "Cat"
        };
        String[] url ={


                "https://farm7.staticflickr.com/6089/6115759179_86316c08ff_z_d.jpg",

                "https://farm2.staticflickr.com/1090/4595137268_0e3f2b9aa7_z_d.jpg",

                "https://farm3.staticflickr.com/2220/1572613671_7311098b76_z_d.jpg",

                "https://i.imgur.com/OnwEDW3.jpg",

                "https://farm9.staticflickr.com/8505/8441256181_4e98d8bff5_z_d.jpg",

                "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg",


                "https://farm8.staticflickr.com/7377/9359257263_81b080a039_z_d.jpg",

                "https://i.imgur.com/CzXTtJV.jpg"

        };


        for(int i=0;i< name.length;i++){
            Picture picture=new Picture(url[i],i+1,name[i]);
            pictures.add(picture);
        }
        return pictures;
    }


}