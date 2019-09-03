package com.example.p474;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.RunnableFuture;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    Button b1, b2;
    boolean f1 = false, f2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
    }
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(300);
                    Log.d("[t]","-------" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tv1.setText(""+i);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    b1.setEnabled(true);
                }
            });
        }
    };
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(300);
                    Log.d("[t2]","========" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int a = i ;
                tv2.setText(""+ a);

            }
            runOnUiThread(new Runnable() {
                // 서브 스레드가 메인 스레드의 ui에 접근할 수 있게 해 주는 녀석
                @Override
                public void run() {

                    b2.setEnabled(true);
                }
            });

        }
    };


    public void clickB(View v){
        b1.setEnabled(false);
        Thread t = new Thread(r1);
        t.start();

    }
    public void clickB2(View v){
        b2.setEnabled(false);
        Thread t = new Thread(r2);
        t.start();
    }
}
