package com.example.myinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
    private ArrayList<Information> informations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        informations=getInfos();
        CustomAdapter customAdapter=new CustomAdapter(MainActivity.this,informations);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(customAdapter);
    }

    private ArrayList<Information> getInfos(){
        ArrayList<Information>temp=new ArrayList<>();
        String []hobbies={
                "singing",
                "reading",
                "dancing",
        };
        String[]skill={
          "Communication",
           "problem solving",
           "coding"
        };

        for (int i = 0; i < hobbies.length; i++) {
            Information information=new Information(hobbies[i],skill[i]);
            temp.add(information);
        }

        return temp;
    }
}