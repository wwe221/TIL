package com.example.p115;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt2= findViewById(R.id.button25);
    }
    public void btc(View v){
        bt2.setBackgroundColor(Color.RED);
        bt2.setText("Changed");
    }
}
