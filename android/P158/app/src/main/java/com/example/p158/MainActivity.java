package com.example.p158;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgv;
    ConstraintLayout logL, regiL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        imgv=findViewById(R.id.imgv);
        logL=findViewById(R.id.loginl);
        regiL=findViewById(R.id.registl);
        disable();
    }
    public void disable(){
        logL.setVisibility(View.INVISIBLE);
        regiL.setVisibility(View.INVISIBLE);
    }
    public void clickb(View v){
        int vid = v.getId();
        if(vid==R.id.bt1){
            imgv.setImageResource(R.drawable.dog1);
        }
        else if(vid==R.id.bt2){
            imgv.setImageResource(R.drawable.cat1);
        }
        else if(vid==R.id.bt3){
            logL.setVisibility(View.INVISIBLE);
            regiL.setVisibility(View.VISIBLE);
        }
        else if(vid==R.id.bt4){
            logL.setVisibility(View.VISIBLE);
            regiL.setVisibility(View.INVISIBLE);
        }
    }

}
