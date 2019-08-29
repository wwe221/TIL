package com.example.p246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void clickbt(View v){
        Intent i  = new Intent();
        i.putExtra("nn",222);
        i.putExtra("st","Hi hello");
        setResult(RESULT_OK,i);
        finish();
    }
}
