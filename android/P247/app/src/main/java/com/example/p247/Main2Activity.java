package com.example.p247;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    String name;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.imageView);
        Intent i = getIntent();
        img = i.getIntExtra("img",0);
        textView = findViewById(R.id.textView2);
        textView.setText(img);
        name = textView.getText().toString();
        name = name.substring(13,name.length());
        textView.setText(name);
        imageView.setImageResource(img);
    }
    public void bt(View v){
        Intent i  = new Intent();
        i.putExtra("str",name);
        setResult(RESULT_OK,i);
        finish();
    }
}
