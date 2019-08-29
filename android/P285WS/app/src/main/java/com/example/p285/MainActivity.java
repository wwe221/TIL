package com.example.p285;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView id, pwd;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.idtext);
        pwd = findViewById(R.id.pwdtext);
        checkBox=findViewById(R.id.checkBox);
        if(logincheck()){
            login();
        }
    }
    public boolean logincheck(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref!=null)&& pref.contains("save")){
            if(pref.getBoolean("save",false)){
                return true;
            }
        }
        return false;
    }
    public void loginbt(View v) {
        String ID = id.getText().toString();
        String PWD = pwd.getText().toString();
        if (ID.equals("aaa") && PWD.equals("1234")) {
            if (checkBox.isChecked()) {
                SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("save", true);
                editor.putString("id",ID);
                editor.putString("pwd",PWD);
                editor.commit();
            }
            login();
        }else{
            Toast.makeText(this, "틀렸어!", Toast.LENGTH_SHORT).show();
        }

    }
    public void login(){
            Intent i = new Intent(getApplicationContext(),menu.class);
            startActivity(i);
        }


}

