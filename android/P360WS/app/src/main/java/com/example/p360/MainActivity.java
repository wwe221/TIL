package com.example.p360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MyService ms;
    ProgressBar progressBar;
    SeekBar seekBar;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.myBinder mb = (MyService.myBinder) iBinder;
            ms = mb.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= findViewById(R.id.progressBar);
        seekBar=findViewById(R.id.seekBar);
        progressBar.setMax(30);
        seekBar.setMax(15);
        Intent i = new Intent(this , MyService.class);
        bindService(i , conn, Context.BIND_AUTO_CREATE);

    }

    public void btclick(View v){
        ms.method1();
    }
    public void btclick2(View v){
        ms.method2();
    }
    @Override
    protected void onNewIntent(Intent intent) {
        process(intent);
    }
    public void process(Intent intent){
        if(intent!=null){
        int data= intent.getIntExtra("cmd",0);
        int data2= intent.getIntExtra("cmd2",0);
        progressBar.setProgress(data);
        seekBar.setProgress(data2);
    }
}
}
