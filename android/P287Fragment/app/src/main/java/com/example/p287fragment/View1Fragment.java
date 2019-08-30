package com.example.p287fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class View1Fragment extends Fragment {
    Button bt4, bt5;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup=
                (ViewGroup) inflater.inflate(R.layout.fragment_view1, container, false);
        bt4=viewGroup.findViewById(R.id.button4);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity main = new MainActivity();
                main.setbt();
            }
        });
        bt5=viewGroup.findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Testing is progressing");
            }
        });
        textView=viewGroup.findViewById(R.id.textView);

        return viewGroup;
    }
    public void sett(){
        textView.setText("hihihihi");
    }
}
