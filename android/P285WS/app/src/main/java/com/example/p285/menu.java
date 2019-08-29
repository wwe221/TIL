package com.example.p285;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void logoutEx(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        finish();
    }
    public void logout(View v){
        logoutEx();
    }

    public void btClick(View v){
        Intent i = new Intent(getApplicationContext(),custom.class);
        switch (v.getId()){
            case R.id.button:{
                i.putExtra("title","고객관리");
                break;
            }
            case R.id.button2:{
                i.putExtra("title","매출관리");
                break;
            }
            case R.id.button3:{
                i.putExtra("title","상품관리");
                break;
            }
        }
        startActivityForResult(i,100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            if(resultCode==RESULT_OK) {
                Toast.makeText(this, "this is from " + data.getStringExtra("from"), Toast.LENGTH_SHORT).show();
                logoutEx();
            }
            else if(resultCode==-127){
                Toast.makeText(this, "this is from " + data.getStringExtra("from"), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
