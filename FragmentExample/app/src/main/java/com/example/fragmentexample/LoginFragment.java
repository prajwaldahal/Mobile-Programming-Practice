package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LoginFragment extends Fragment {
    Button register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        register=view.findViewById(R.id.signup_button);
        register.setOnClickListener(v -> {
            RegisterFragment registerFragment = new RegisterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("value","from login fragment to register fragment");
            registerFragment.setArguments(bundle);
            FragmentTransaction fragmenttransaction = getParentFragmentManager().beginTransaction();
            fragmenttransaction.addToBackStack("regiserfragment");
            fragmenttransaction.replace(R.id.fragment_container,registerFragment);
            fragmenttransaction.commit();
        });
        Bundle bundle=getArguments();
        if(bundle!=null) {
                Toast.makeText(getContext(), bundle.getString("value") , Toast.LENGTH_SHORT).show();
        }
        return view;

    }
}