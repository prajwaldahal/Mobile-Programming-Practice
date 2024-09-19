package com.example.simpleinterest;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleActivity extends AppCompatActivity {
    EditText principle, rate, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        principle=findViewById(R.id.principle);
        rate=findViewById(R.id.rate);
        time=findViewById(R.id.time);

        Double p=Double.parseDouble(principle.getText().toString());
        Double r=Double.parseDouble(rate.getText().toString());
        Double t=Double.parseDouble(time.getText().toString());

        double result=p*t*r/100;

        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Result");
        alertDialogBuilder.setMessage("Simple Interest"+result);
        alertDialogBuilder.setNeutralButton("Ok", (dialog, which) -> {
            dialog.dismiss();
        });

    }
}