package com.example.calcbox;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ShowResultDialogFragment extends DialogFragment {
    Button okay;
    TextView result;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.show_result_dialog_fragment,container,false);
        initComponent(view);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().setCancelable(false);
        return view;
    }

    private void initComponent(View view) {

        okay=view.findViewById(R.id.okay);
        result=view.findViewById(R.id.result);
        Bundle bundle=getArguments();
        Double interest=bundle.getDouble("interest",-1);

        result.setText("your result is "+interest);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }

    public void show(double x){
        //result=view.findViewById(R.id.result);
        //result.setText("your result is "+x);
    }
}
