package com.example.identity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDetailActivity extends AppCompatActivity {
    EditText name,address,phone,age;
    Intent intent2;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_detail);

        name=findViewById(R.id.nameedt);
        address=findViewById(R.id.addressedt);
        age=findViewById(R.id.ageedt);
        phone=findViewById(R.id.phonedt);
        bt=findViewById(R.id.update_data);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=name.getText().toString();
                String ad=address.getText().toString();
                String a=age.getText().toString();
                String p=phone.getText().toString();
                intent2=new Intent();
                intent2.putExtra("name",n);
                intent2.putExtra("address",ad);
                intent2.putExtra("age",a);
                intent2.putExtra("phone",p);
                setResult(RESULT_OK,intent2);
                finish();

            }
        });

       Intent intent =getIntent();

       name.setText(intent.getStringExtra("name"));
       address.setText(intent.getStringExtra("address"));
       age.setText(intent.getStringExtra("age"));
       phone.setText(intent.getStringExtra("phone"));

    }
}