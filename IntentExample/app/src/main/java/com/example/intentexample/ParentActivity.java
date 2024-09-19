package com.example.intentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ParentActivity extends AppCompatActivity {
    EditText edtdate,edtname;
    Button calc,redirect;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        edtdate=findViewById(R.id.birth_date);
        edtname=findViewById(R.id.name);
        calc=findViewById(R.id.calc_birth);
        redirect=findViewById(R.id.second_actiivty);

        intent= new Intent(this,ChildActivity.class);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtname.getText().toString();
                int date =Integer.parseInt(edtdate.getText().toString());
                intent.putExtra("name",name);
                intent.putExtra("date",date);
                startActivityForResult(intent,111);
            }
        });

        redirect.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),SecondChildActivity.class);
                intent.putExtra("val","#ffff");
                startActivityForResult(intent,121);
            }
        }));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111){
            String msg ="call from child activity with value="+data.getStringExtra("name");
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
        else if(requestCode==121){
            String msg ="call from Second child activity with value="+data.getStringExtra("value");
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        edtdate.setText("");
        edtname.setText("");
    }
}