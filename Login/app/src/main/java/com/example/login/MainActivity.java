package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("value","hello");
        loginFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       // fragmentTransaction.addToBackStack("login1");
        fragmentTransaction.add(R.id.fragment_container,loginFragment);
        fragmentTransaction.commit();
    }
    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager= getSupportFragmentManager();
        System.out.println(fragmentManager.getBackStackEntryCount());
        if(fragmentManager.getBackStackEntryCount()>0)
            fragmentManager.popBackStack();
        else
            super.onBackPressed();
    }
}