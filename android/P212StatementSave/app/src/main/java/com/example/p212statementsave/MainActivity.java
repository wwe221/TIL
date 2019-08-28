package com.example.p212statementsave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    String appid;
    Button bt , bt2;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
        bt = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appid = text.getText().toString();
                //savedInstanceState.putString("save",appid);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data =null;
                if(savedInstanceState != null) {
                    data= savedInstanceState.getString("ID");
                }else
                    data="empty";

                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) { // 화면 전환 또는 프로세스 전환시 호출
        super.onSaveInstanceState(outState);
        Toast.makeText(this, "onSaveInstanceState Executed", Toast.LENGTH_SHORT).show();
        outState.putString("ID",appid);

    }
}
