package com.example.p213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt, bt2;
    SharedPreferences sp; // 환경설정 등의 정보를 저장가능
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View view){
        if (view.getId()==R.id.button){
            sp =getSharedPreferences("ma",MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("key1","id01");
            editor.commit();
        }
        else if(view.getId()==R.id.button2){
        sp =getSharedPreferences("ma",MODE_PRIVATE);
        String id = sp.getString("key1","default");
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        }
    }

}
