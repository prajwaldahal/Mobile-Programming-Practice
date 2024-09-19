package com.example.layoutexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WidgetAccessModification extends AppCompatActivity {
    private TextView tvName;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_access_modification);
        btn=findViewById(R.id.Btn);
        tvName=findViewById(R.id.mytextView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(v.getContext(),"Text Updated",Toast.LENGTH_LONG);

            }
        });
    }
}