package com.example.p169;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView output;
    TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        input = findViewById(R.id.input);
        output = findViewById(R.id.count);
    }
    public void btclick(View v){
        int l = input.length();
        int vid = v.getId();
        if(vid==R.id.send){
            output.setText(l+"text");
            Toast.makeText(this, input.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(vid==R.id.close){

        }
    }

}
