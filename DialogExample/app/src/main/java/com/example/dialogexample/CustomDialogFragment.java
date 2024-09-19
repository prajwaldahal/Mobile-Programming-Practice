package com.example.dialogexample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    public View onCreateView(LayoutInflater inflater,  ViewGroup parent, Bundle savedInstanceState) {
        Button yes,no;
        View view = inflater.inflate(R.layout.fragment_custom_dialog,parent,false);
        yes=view.findViewById(R.id.yesf);
        no=view.findViewById(R.id.nof);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        yes.setOnClickListener(v -> {
            getDialog().dismiss();
            Toast.makeText(getContext(), "you close dialog", Toast.LENGTH_SHORT).show();
        });
        no.setOnClickListener(v -> Toast.makeText(getContext(), "you clicked no ", Toast.LENGTH_SHORT).show());
        return view;
    }
}
