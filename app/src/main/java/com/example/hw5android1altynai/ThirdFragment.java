package com.example.hw5android1altynai;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ThirdFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    iFragment iFragment;
    Button button;
    EditText editText;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iFragment = (iFragment) context;
    }

    public ThirdFragment() {

    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_third, container, false);
         button = view.findViewById(R.id.btn_addList);
         editText = view.findViewById(R.id.etText);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
          String etText = editText.getText().toString();
          MainActivity mainActivity = (MainActivity) getActivity();
                 assert mainActivity != null;
                 mainActivity.editText(etText);
             }
         });

         return view;
    }
}