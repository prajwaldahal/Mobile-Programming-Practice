package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class RegisterFragment extends Fragment {

    Button login,register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        login=view.findViewById(R.id.signin_button);
        register=view.findViewById(R.id.register_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmenttransaction = getParentFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container,new LoginFragment());
                fragmenttransaction.commit();
                fragmenttransaction.addToBackStack("login");
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.showMessage("from register fragment passing to mainactivity");

            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putStringSet("user",)
                editor.apply();
            }
        });
        return view;
    }
}