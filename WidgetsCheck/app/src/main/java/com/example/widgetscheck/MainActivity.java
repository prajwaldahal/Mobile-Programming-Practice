package com.example.widgetscheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[]object={"ktm","bkt","lalitpur"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,object);
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);


        RadioGroup radioGroup=findViewById(R.id.gender);

        Button button=findViewById(R.id.button);

        TextView textView=findViewById(R.id.result);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) spinner.getSelectedItem();
                textView.setText("currently selected:"+text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(v -> {
            String text= (String) spinner.getSelectedItem();
            int radioButtonId=radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton=findViewById(radioButtonId);
            textView.setText("submitted"+radioButton.getText()+""+text);
        });

    }
}