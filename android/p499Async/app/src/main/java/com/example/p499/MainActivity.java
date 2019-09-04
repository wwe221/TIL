package com.example.p499;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    spTask spTask;
    rpmTask rpmTask;
    Button button;
    TextView speedT, rpmT, statusT;
    Random random;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speedT=  findViewById(R.id.speed);
        rpmT = findViewById(R.id.rpm);
        statusT = findViewById(R.id.average);
        progressBar= findViewById(R.id.progressBar);
        button = findViewById(R.id.Start);
        random = new Random();
    }
    public void startBt(View v){
        button.setEnabled(false);
        spTask = new spTask(0);
        spTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
        rpmTask = new rpmTask(0);
        rpmTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    class spTask extends AsyncTask<Integer,Integer,String>{
        int speed;
        public spTask(int speed) {
            this.speed=speed;
        }
        public int getSpeed() {
            return speed;
        }
        @Override
        protected void onPreExecute() {
            speedT.setText(0+"");
            progressBar.setMax(220);
        }
        @Override
        protected String doInBackground(Integer... integers) {
            String str = "";
            while(true) {
                int sppp = speed;
                int ran = random.nextInt(8);
                if (sppp > 220)
                    sppp -= ran;
                else if (sppp <= 0)
                    sppp += ran;
                else if (ran < 4)
                    sppp -= ran;
                else
                    sppp += ran;
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.speed=sppp;
                publishProgress(sppp);
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            String s ="";
            int a = values[0].intValue();
            speedT.setText(s+a);
            progressBar.setProgress(a);
            if(a<60) {
                statusT.setText("저속");
                statusT.setTextColor(Color.YELLOW);
            }
            else if(a<120) {
                statusT.setText("정속");
                statusT.setTextColor(Color.GREEN);
            }
            else {
                statusT.setText("과속");
                statusT.setTextColor(Color.RED);
            }
        }
        @Override
        protected void onPostExecute(String s) {
        }
    }
    class rpmTask extends AsyncTask<Integer, Integer, String>{
        int rpm;
        public rpmTask(int rpm) {
            this.rpm = rpm;
        }
        @Override
        protected void onPreExecute() {
            rpmT.setText(0+"");

        }
        @Override
        protected String doInBackground(Integer... integers) {
            while(true) {
                int speed = spTask.getSpeed();
                int ran = random.nextInt(speed+80);
                int rpp = this.rpm;
                if (rpp > 3000)
                    rpp -= ran;
                else
                    rpp += ran;
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(rpp);
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            int a = values[0].intValue();
            rpmT.setText(a+"");
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
