package com.example.calcbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {
    Button simpleInterest,unitConversion,calculator,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setTitle("Dashboard");
        initComponent();

    }

    private void initComponent() {

        simpleInterest=findViewById(R.id.simple_interest);
        unitConversion=findViewById(R.id.unit_conversion);
        calculator=findViewById(R.id.calculator);
        bmi=findViewById(R.id.bmi);


        simpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               simpleInterestActionPerformed();
            }
        });

        unitConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogBox();
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogBox();
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogBox();
            }
        });
    }

    private void showDialogBox() {
        Button okay;
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialogue_layout);
        okay=dialog.findViewById(R.id.button_okay);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void simpleInterestActionPerformed() {
        Intent intent = new Intent(DashBoard.this,SimpleInterestActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit CalcuBox");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(R.drawable.baseline_exit_to_app_24);
        alertDialogBuilder.setMessage("are you sure you want to close the app");
        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exitApp();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.show();
    }

    private void exitApp() {
        super.onBackPressed();
    }
}