package com.example.p247;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
    }
    public void btclick(View v){
        int id = v.getId();
        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
        switch (id){
            case R.id.button: {
                i.putExtra("img",R.drawable.cat1);
                break;
            }
            case R.id.button2: {
                i.putExtra("img",R.drawable.dog1);
                break;
            }
            case R.id.button3: {
                i.putExtra("img",R.drawable.itzy);
                break;
            }
        }
        startActivityForResult(i,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode== RESULT_OK){
            textView.setText(data.getStringExtra("str"));
        }
    }
}
