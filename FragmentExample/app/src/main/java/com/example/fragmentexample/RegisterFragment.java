package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class RegisterFragment extends Fragment {

    Button login;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        login=view.findViewById(R.id.signin_button);
        login.setOnClickListener(v -> {

            FragmentTransaction fragmenttransaction = getParentFragmentManager().beginTransaction();
            fragmenttransaction.replace(R.id.fragment_container,new LoginFragment());
            fragmenttransaction.commit();
            fragmenttransaction.addToBackStack("login");
            MainActivity mainActivity= (MainActivity) getActivity();
            mainActivity.showMessage("from register fragment passing to mainactivity");

        });
        Bundle  bundle = getArguments();
        System.out.println(bundle.getString("value"));
        return view;
    }
}