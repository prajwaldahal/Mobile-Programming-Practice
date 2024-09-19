package com.example.loginform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText name,email,phone;
    Spinner district;
    RadioGroup gender;
    RadioButton valueg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name_txt);
        email=findViewById(R.id.email_txt);
        phone=findViewById(R.id.phone_txt);

        CheckBox[] checkBoxes= new CheckBox[]{findViewById(R.id.guitar),findViewById(R.id.dancing),findViewById(R.id.cricket), findViewById(R.id.football),findViewById(R.id.singing)};



        district=findViewById(R.id.select_district);

        gender=findViewById(R.id.radio_grp);


        btn=findViewById(R.id.Submit);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String hobbies=" ";
               String nametxt=name.getText().toString();
               String phonetxt=phone.getText().toString();
               String emialtxt=email.getText().toString();
               String disvalue=(String)district.getSelectedItem();

                int id1= gender.getCheckedRadioButtonId();
                valueg=findViewById(id1);
               String genderv=valueg.getText().toString();

                for (CheckBox x:checkBoxes
                     ) {
                    if(x.isChecked()){
                        hobbies=hobbies+"\n "+x.getText().toString();
                        x.setChecked(false);
                    }
                }
                String show="Name: "+nametxt+"\ngender: "+genderv+"\nphone: "+phonetxt+"\nEmail: "+emialtxt+"\nBirth District: "+disvalue+"\nhobbies: "+hobbies;
                Toast.makeText(v.getContext(),show,Toast.LENGTH_LONG).show();

                name.setText("");
                phone.setText("");
                email.setText("");
                gender.clearCheck();
                district.setSelection(0);

            }
        });
    }

    public static class ManualActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
}