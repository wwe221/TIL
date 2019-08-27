package com.example.p168;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView upimg, downimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();

    }

    private void setUi() {
        upimg =findViewById(R.id.upimg);
        upimg.setImageResource(R.drawable.itzy);
        downimg =findViewById(R.id.downimg);
        downimg.setImageResource(R.drawable.itzy);
        disable();
    }
    public void disable(){
        upimg.setVisibility(View.INVISIBLE);
        downimg.setVisibility(View.INVISIBLE);
    }
    public void btclick(View v){
        int vid = v.getId();
        if(vid==R.id.up){
            upimg.setVisibility(View.VISIBLE);
            downimg.setVisibility(View.INVISIBLE);
        }
        else if(vid==R.id.down){
            upimg.setVisibility(View.INVISIBLE);
            downimg.setVisibility(View.VISIBLE);
        }
    }
}
