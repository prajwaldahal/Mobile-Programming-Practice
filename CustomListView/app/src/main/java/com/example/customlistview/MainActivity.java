package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 ListView listView;
 ArrayList<Person>persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_contacts);
        persons=getPersons();
        PersonAdapter personAdapter= new PersonAdapter(this,persons);

        listView.setAdapter(personAdapter);


    }

    private ArrayList<Person> getPersons() {
        ArrayList<Person> tmpContacts = new ArrayList<>();
        String[] names = {
                "John Smith",
                "Mary Jones",
                "Peter Brown",
                "Susan Green",
        };

        String[] emails = {
                "john.smith@gmail.com",
                "mary.jones@yahoo.com",
                "peter.brown@hotmail.com",
                "susan.green@aol.com",
        };

        String[] phoneNumbers = {
                "9841234567",
                "9851234567",
                "9861234567",
                "9871234567"
        };

        int[] avatars = {
               R.drawable.baseline_person_3_24,
               R.drawable.baseline_person_4_24,
               R.drawable.baseline_person_24,
                R.drawable.baseline_person_outline_24
        };

        for (int i = 0; i < names.length; i++) {
            Person person = new Person(i+1, names[i], phoneNumbers[i], emails[i], avatars[i]);
            tmpContacts.add(person);
        }

        return tmpContacts;

    }
}