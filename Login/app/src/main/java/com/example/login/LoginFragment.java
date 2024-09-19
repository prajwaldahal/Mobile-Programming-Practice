package com.example.login;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    Button register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        register=view.findViewById(R.id.signup_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegisterFragment registerFragment = new RegisterFragment();
                FragmentTransaction fragmenttransaction = getParentFragmentManager().beginTransaction();
                fragmenttransaction.addToBackStack("regiserfragment");
                fragmenttransaction.replace(R.id.fragment_container,registerFragment);
                fragmenttransaction.commit();

            }
        });

        return view;

    }
}