package com.example.p478;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    countHandler ch;
    Button b;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.textView);
        ch= new countHandler();
        b= findViewById(R.id.button);
        handler = new Handler(); // 메인쓰레드의 handler
    }
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Bundle bundle = new Bundle();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    Log.d("[t]", "========" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int a = i;
                Message message = ch.obtainMessage();
                bundle.putInt("cnt", i);
                message.setData(bundle);
                ch.sendMessage(message);
                //서브 스레드에서 메인스레드로 값을 전달
            }
            handler.post(new Runnable() {// 메인 쓰레드의 핸들러이기 때문에  직접 ui 제어가 가능하다.
                @Override
                public void run() {
                    b.setEnabled(true);
                }
            });
        }
    };
    class countHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int value = bundle.getInt("cnt");
            tv.setText(value+"");
        }
    }
    public void clickB(View v ){
        b.setEnabled(false);
        Thread t= new Thread(r);
        t.start();
    }
    public void clickB2(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("dialog");
        builder.setMessage("Do you wanna build a snow man?");
        final ProgressDialog  pb= new ProgressDialog(MainActivity.this);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pb.show();
                handler.postDelayed(new Runnable() {
                // 3초후 실행
                    @Override
                    public void run() {
                        pb.dismiss();
                        Toast.makeText(MainActivity.this, "Okay bye...", Toast.LENGTH_SHORT).show();
                    }
                },1000);
            }
        });
        builder.show();
    }
}
