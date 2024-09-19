package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChildActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
         Intent intent= getIntent();
        bt = findViewById(R.id.button);

        bt.setOnClickListener(v -> {
            String name=intent.getStringExtra("name");
            int date=intent.getIntExtra("date",0);
            int age=2080-date;
            String msg="hello "+name+",your age is"+age;
            Toast.makeText(ChildActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
        setResult(RESULT_OK,intent);
    }
}