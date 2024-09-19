package com.example.sqllitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TAG = "Database Helper";
    private static final String DB_NAME = "phone_directory_db";
    private static final int DB_VERSION = 1;
    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE contacts(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, email TEXT)";
        db.execSQL(CREATE_TABLE_QUERY);
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS contacts";
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    public boolean saveContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", contact.getId());
        values.put("name", contact.getName());
        values.put("phone", contact.getPhone());
        values.put("email", contact.getEmail());

        long result = db.insert("contacts", null, values);
        db.close();
        return result > -1;
    }



    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contactList = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM contacts", null);

        String[] columns = {"id", "name", "email", "phone"};
        String[] args = {"Ram", "2"};
        Log.d(TAG, "getAllContacts: " + Arrays.toString(columns));
        Cursor cursor1 = database.query("contacts", columns, null, null, null, null, null);


        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int emailIndex = cursor.getColumnIndex("email");
            int phoneIndex = cursor.getColumnIndex("phone");


            do {
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                String email = emailIndex != -1 ? cursor.getString(emailIndex) : null;
                String phone = phoneIndex != -1 ? cursor.getString(phoneIndex) : null;

                Contact contact = new Contact(id, name, email, phone);
                contactList.add(contact);
            } while (cursor.moveToNext());

            cursor.close();
        }

        database.close();
        return contactList;
    }
}
