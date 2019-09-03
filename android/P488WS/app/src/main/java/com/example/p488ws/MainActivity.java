package com.example.p488ws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView speed , rpm, average;
    float spp, rp, avg;
    int ran;
    Random random;
    ProgressBar progressBar ;
    Handler handler , rhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.Start);
        speed= findViewById(R.id.speed);
        rpm= findViewById(R.id.rpm);
        average = findViewById(R.id.average);
        random = new Random();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(220);
        handler =new speedHandelr();
        rhandler = new rpmHander();
    }
    class speedHandelr extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            spp  = bundle.getInt("spp");
            progressBar.setProgress((int) spp);
            speed.setText((int) spp+"");
        }
    }
    class rpmHander extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            rp  = bundle.getInt("rpm");
            rpm.setText((int)rp+"");
        }
    }
    Runnable r1 = new Runnable() {//speed
        @Override
        public void run() {
            while(true) {
                int sppp = Integer.parseInt(speed.getText().toString());
                ran= random.nextInt(8);
                if(sppp>220)
                    sppp-=ran;
                else if(sppp<=0)
                    sppp+=ran;
                else if(ran<4)
                    sppp-=ran;
                else
                    sppp +=ran;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int a = sppp;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Bundle bundle = new Bundle();
                        Message message = handler.obtainMessage();
                        bundle.putInt("spp", a);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                });
            }
        }
    };
    Runnable r2 = new Runnable() {//rpm
        @Override
        public void run() {
            while(true) {
                ran=random.nextInt((int) spp+80);
                int rpp= Integer.parseInt(rpm.getText().toString());
                if(rpp>3000)
                    rpp-=ran;
                else
                    rpp +=ran;
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int a = rpp;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Bundle bundle = new Bundle();
                        Message message = rhandler.obtainMessage();
                        bundle.putInt("rpm", a);
                        message.setData(bundle);
                        rhandler.sendMessage(message);
                    }
                });
            }
        }
    };
    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            while(true){
                if(spp!=0) {
                    avg=rp/spp;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        average.setText((int) avg+"");
                    }
                });
            }
        }
    };
    public void startBt(View v){
        b.setText("STOP");
        b.setEnabled(false);
        Thread t1= new Thread(r1);
        t1.start();
        t1 = new Thread(r2);
        t1.start();
        t1 = new Thread(r3);
        t1.start();
    }
}
