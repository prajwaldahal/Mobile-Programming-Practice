package com.example.dialogexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button one,multi,custom,dialogFragmentbtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=findViewById(R.id.one_button_dialog);
        multi=findViewById(R.id.multi_button_dialog);
        custom=findViewById(R.id.custom_dialog);
        dialogFragmentbtn=findViewById(R.id.dialog_frgment);

        one.setOnClickListener(v -> {
                AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("press ok");
                alertDialog.setMessage("this is single button");
                alertDialog.setCancelable(false);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", (dialog, which) -> Toast.makeText(MainActivity.this, "you just finished  single button test", Toast.LENGTH_SHORT).show());
                alertDialog.show();
        });

        multi.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("multi button check");
            alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setMessage("this is three");
            alertDialogBuilder.setPositiveButton("yes", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "you just press yes button ", Toast.LENGTH_SHORT).show();
                System.out.println(which);
            });
            alertDialogBuilder.setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "you just press No button ", Toast.LENGTH_SHORT).show();
                System.out.println(which);
            });

            alertDialogBuilder.setNeutralButton("cancel", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "you just press cancel button ", Toast.LENGTH_SHORT).show();
                System.out.println(which);
            });
            alertDialogBuilder.show();
        });
        custom.setOnClickListener(v -> {
            Button yes,no;
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.activity_custom_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            yes=dialog.findViewById(R.id.yes);
            no=dialog.findViewById(R.id.no);
            yes.setOnClickListener(v1 -> {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "you close dialog", Toast.LENGTH_SHORT).show();
            });
            no.setOnClickListener(v12 -> Toast.makeText(MainActivity.this, "you clicked no ", Toast.LENGTH_SHORT).show());
            dialog.show();
        });

        dialogFragmentbtn.setOnClickListener(v -> {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            customDialogFragment.setCancelable(false);
            customDialogFragment.show(getSupportFragmentManager(),"dialog");
        });


    }

}