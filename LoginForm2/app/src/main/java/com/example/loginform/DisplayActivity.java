package com.example.loginform;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);
        tv=findViewById(R.id.textView);

        Intent inte = getIntent();
        String uname=inte.getStringExtra("username");

        tv.setText("welcome ,"+uname);

    }
}