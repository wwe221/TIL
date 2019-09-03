package com.example.p485;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    myThread myThread;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        myThread = new myThread();
        handler = new myHandler();
    }
    class myHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int a = bundle.getInt("cnt");
            Toast.makeText(MainActivity.this, a+"", Toast.LENGTH_SHORT).show();
        }
    }
    class myThread extends Thread{
        int cnt;
        public myThread() {
        }
        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        @Override
        public void run() {
            // run 호출하지 않는다.( .start() 안한다.)
//            Looper.prepare();
//            Looper.loop();
            for(int i=0;i<cnt;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tv.setText(""+i);
                Bundle bundle = new Bundle();
                Message message = handler.obtainMessage();
                bundle.putInt("cnt", i);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }
    }
    public void btclick(View v){
        myThread.setCnt(10);
        myThread.start();
    }

}
