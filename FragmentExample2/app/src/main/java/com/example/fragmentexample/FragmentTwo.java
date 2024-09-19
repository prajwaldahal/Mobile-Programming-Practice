package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        TextView textViewFragmentTwo = view.findViewById(R.id.textViewFragmentTwo);
        Bundle args = getArguments();
        if (args != null) {
            String data = args.getString("dataKey", "");
            textViewFragmentTwo.setText(data);
        }
        return view;
    }
}
