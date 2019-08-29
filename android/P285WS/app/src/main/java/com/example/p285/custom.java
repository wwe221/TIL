package com.example.p285;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class custom extends AppCompatActivity {
    Button tomenu, tologin;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        textView=findViewById(R.id.textView3);
        tomenu=findViewById(R.id.tomenu);
        tologin=findViewById(R.id.tologin);
        Intent i = getIntent();
        final String title = i.getStringExtra("title");
        textView.setText(title);
        tomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent();
                i.putExtra("from",title);
                setResult(-127,i);
                finish();
            }
        });
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent();
                i.putExtra("from",title);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
