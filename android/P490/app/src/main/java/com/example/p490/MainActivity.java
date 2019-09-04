package com.example.p490;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button, button2 ,button3;
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar=  findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        progressDialog = new ProgressDialog(this);
        button2.setEnabled(false);


    }
    public void clikcbt(View v){
        myTask = new MyTask(20);
        myTask.execute();
        button2.setEnabled(true);
    }
    public void clikcbt2(View v){
        myTask.cancel(true);
        button2.setEnabled(false);
    }
    public void clikcbt3(View v){
        myTask = new MyTask(20);
        myTask.execute();
    }
    class MyTask extends AsyncTask<Integer , Integer, String>{
        //3가지 generic 사용 <argument , 쓰레드 동작중의 발생 타입 , 리턴 타입>
        int cnt;
        public MyTask(int cnt) {
            this.cnt = cnt;
        }
        @Override
        protected void onPreExecute() { // 실행 전 처리
            progressBar.setMax(cnt);
            button.setEnabled(false);
            textView.setText("Start Task");
        /*    progressDialog.setTitle("pre");
            progressDialog.show();
            progressDialog.setCancelable(false);*/
        }
        @Override
        protected String doInBackground(Integer... integers) { //Thread가 동작하는 부분
            String str = "";
            int sum = 0;
            for(int i=0;i<=cnt;i++){
                if(isCancelled() == true)
                    break;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=i;
                publishProgress(i); // onProgressUpdate 에게 변수를 던져준다.
            }
            str+=sum;
            return str;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {// Thread 에 의해 발생하는 내용 처리
            progressBar.setProgress(values[0].intValue());
        }
        @Override
        protected void onPostExecute(String s) { // 실행 후 처리
            button.setEnabled(true);
            textView.setText("End Task "+s);
            progressDialog.dismiss();
        }

    }
}
