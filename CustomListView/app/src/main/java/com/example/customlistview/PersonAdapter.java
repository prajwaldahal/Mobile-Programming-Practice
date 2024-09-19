package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    private ArrayList<Person>persons;
    LayoutInflater layoutInflater;

    public PersonAdapter(Context context, ArrayList<Person> persons) {
        this.persons = persons;
        layoutInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return persons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView name, email, phone;
        ImageView pp;
        Person person = (Person) getItem(position);
        if(convertView==null)
            convertView=layoutInflater.inflate(R.layout.person_layout,parent,false);

        name=convertView.findViewById(R.id.contact_name);
        email=convertView.findViewById(R.id.contact_email);
        phone=convertView.findViewById(R.id.contact_phone);
        pp=convertView.findViewById(R.id.contact_image);

        name.setText(person.getName());
        email.setText(person.getEmail());
        phone.setText(person.getPhone());
        pp.setImageResource(person.getPp());

        return convertView;
    }
}
