package com.example.p353;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent i;
    TextView tv;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        imageView= findViewById(R.id.imageView);
    }
    public void btclick(View v){
        i=  new Intent(this,MyService.class);

        startService(i);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        process(intent);

    }
    public void process(Intent intent){
        if(intent!=null){
            int data= intent.getIntExtra("cmd",0);
            tv.setText(""+data);
            if(data%2==0){
                imageView.setImageResource(R.drawable.dog1);
            }else
                imageView.setImageResource(R.drawable.itzy);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(i != null){
            stopService(i);
        }
    }
}
