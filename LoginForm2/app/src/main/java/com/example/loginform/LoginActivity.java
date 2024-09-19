package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    Button btn;
    EditText edtUn,edtPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn=findViewById(R.id.button);
        edtUn=findViewById(R.id.username);
        edtPw=findViewById(R.id.password);

        btn.setOnClickListener(v -> {
            String username=edtUn.getText().toString();
            String password=edtPw.getText().toString();

            if(username.equals("Prajwal") && password.equals("12345")) {
                Intent inte = new Intent(getApplicationContext(), DisplayActivity.class);
                inte.putExtra("username", username);
                startActivity(inte);
            }
            else{
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        });
    }
}