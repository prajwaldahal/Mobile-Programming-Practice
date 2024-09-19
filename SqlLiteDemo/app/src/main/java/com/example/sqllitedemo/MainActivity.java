package com.example.sqllitedemo;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView rvContacts;
    private LinearLayoutManager layoutManager;
    private ArrayList<Contact> contacts;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContacts = findViewById(R.id.rv_quotes);
        layoutManager = new LinearLayoutManager(this);
        rvContacts.setLayoutManager(layoutManager);


        dbHelper = new DatabaseHelper(this);


        saveSomeTempContacts();


        contacts = dbHelper.getAllContacts();

        recyclerViewAdapter = new RecyclerViewAdapter(this , contacts);
        rvContacts.setAdapter(recyclerViewAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_view_option_menu,menu);
        return true;
    }
    private void saveSomeTempContacts(){
        String[] names = {
                "John Smith",
                "Mary Jones",
                "Peter Brown",
                "Susan Green",
                "David Williams",
                "Sarah Davis",
                "Michael Carter",
                "Jessica Garcia",
                "William Hernandez",
                "Linda Lopez"
        };

        String[] emails = {
                "john.smith@gmail.com",
                "mary.jones@yahoo.com",
                "peter.brown@hotmail.com",
                "susan.green@aol.com",
                "david.williams@outlook.com",
                "sarah.davis@icloud.com",
                "michael.carter@msn.com",
                "jessica.garcia@yahoo.com",
                "william.hernandez@gmail.com",
                "linda.lopez@hotmail.com"
        };

        String[] phoneNumbers = {
                "9841234567",
                "9851234567",
                "9861234567",
                "9871234567",
                "9881234567",
                "9891234567",
                "9841234567",
                "9851234567",
                "9861234567",
                "9871234567",
        };

        for (int i = 0; i < names.length; i++) {
            Contact contact = new Contact(i + 1, names[i], phoneNumbers[i], emails[i]);
            dbHelper.saveContact(contact);
        }
    }
}