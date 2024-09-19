package com.example.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondChildActivity extends AppCompatActivity {
    Button shw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_child);

        Intent intent=getIntent();

        shw=findViewById(R.id.btn);
        shw.setOnClickListener(v -> {
            String s=intent.getStringExtra("val");
            Toast.makeText(SecondChildActivity.this, "from main activity with value="+s, Toast.LENGTH_SHORT).show();
        });
        Intent i = new Intent();
        i.putExtra("value","1234567");

        setResult(RESULT_OK,i);
    }
}