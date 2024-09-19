package com.example.calcbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleInterestActivity extends AppCompatActivity {
    Button showResult;
    EditText principle,time,rate;
    TextView simpleInterest;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);
        setTitle("Simple Interest");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponent();
    }

    private void initComponent() {
        back=findViewById(R.id.imagebutton1);
        principle=findViewById(R.id.principle);
        rate=findViewById(R.id.rate);
        time=findViewById(R.id.time);
        simpleInterest=findViewById(R.id.simple_interest_textview);
        showResult=findViewById(R.id.show_result);
        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResultActionPerformed();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleInterestActivity.super.onBackPressed();
            }
        });
    }

    private void showResultActionPerformed() {
    try {
        double principleV = Double.valueOf(principle.getText().toString());
        double rateV = Double.valueOf(rate.getText().toString());
        double timeV = Double.valueOf(time.getText().toString());
        double interest=principleV*rateV*timeV/100;

        Bundle bundle = new Bundle();
        bundle.putDouble("interest",interest);

        ShowResultDialogFragment showResultDialogFragment=new ShowResultDialogFragment();
        showResultDialogFragment.setArguments(bundle);
        showResultDialogFragment.show(interest);
        showResultDialogFragment.show(getSupportFragmentManager(),"showResultFragment");

    }catch (Exception e){
        Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show();
        System.out.println(e);
    }

    }
}