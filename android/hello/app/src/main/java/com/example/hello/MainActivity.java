package com.example.hello;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Paused", Toast.LENGTH_LONG).show();
    }

    public void clickButton(View view){
        Toast.makeText(this, "ooho ohohoh ", Toast.LENGTH_LONG).show();
        Log.d("d for DEBUG@@@@","clickButton");
        Log.i("i for Info#####","bangga");
        Log.e("e for Error","error");
    }

}
