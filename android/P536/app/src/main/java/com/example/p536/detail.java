package com.example.p536;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class detail extends AppCompatActivity {
    TextView title, date, contents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.detailTitle);
        date = findViewById(R.id.detailDate);
        contents=findViewById(R.id.detailContents);
        Intent i = getIntent();
        String titleT , dateT, contentsT;
        titleT = i.getStringExtra("title");
        dateT = i.getStringExtra("date");
        contentsT = i.getStringExtra("content");
        title.setText(titleT);
        date.setText(dateT);
        contents.setText(contentsT);

    }
}
