package com.example.p246;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btclick(View v){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        //Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        intent.putExtra("key",500);
        intent.putExtra("str","String is good to go");
        startActivity(intent);


    }
}
