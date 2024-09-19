package com.example.identity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class IdentityActivity extends AppCompatActivity {
    ImageView img;
    TextView name,age,phone,address;
    Button update;

    ActivityResultLauncher<Intent> updateLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            int resultCode = result.getResultCode();
            Intent data = result.getData();

            if (resultCode == RESULT_OK && data != null) {
                name.setText(data.getStringExtra("name"));
                age.setText(data.getStringExtra("age"));
                address.setText(data.getStringExtra("address"));
                phone.setText(data.getStringExtra("phone"));
            }
            else if(data==null){
                System.out.println("hello");
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity);

        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);

        update=findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String ad = address.getText().toString();
                String a = age.getText().toString();
                String p = phone.getText().toString();
                Intent intent = new Intent(getApplicationContext(), UpdateDetailActivity.class);
                intent.putExtra("name", n);
                intent.putExtra("address", ad);
                intent.putExtra("age", a);
                intent.putExtra("phone", p);
                updateLauncher.launch(intent);
            }
        });

        img=findViewById(R.id.img);
        img.setOnClickListener(v -> {

        });

    }
}