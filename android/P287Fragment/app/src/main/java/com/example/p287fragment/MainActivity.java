package com.example.p287fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View1Fragment v1;
    View2Fragment v2;
    view3Fragment v3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1= (View1Fragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        v2=new View2Fragment();
        v3=new view3Fragment();

    }
    public void setbt(){
        Log.i("@안녕@","this is log");
    }
    public void btclick (View v){
        switch (v.getId()){
            case R.id.button:{
                fragmentChg(1);
                break;
            }
            case R.id.button2:{
                fragmentChg(2);
                break;
            }
            case R.id.button3:{
                fragmentChg(3);
                break;
            }
        }
    }
    public void fragmentChg(int index){
        if(index == 1 ){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container,v1
            ).commit();
        }
        else if (index == 2 ){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container,v2
            ).commit();
        }
        else{
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container,v3
            ).commit();
        }
    }
}
