package com.example.p511;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressDialog progressDialog;
    HttpTask httpTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressDialog = new ProgressDialog(this);
    }
    public void clickBt(View view){
        httpTask = new HttpTask("http://www.naver.com");
        httpTask.execute();
    }

    class HttpTask extends AsyncTask<String,Void,String>{
        String url;
        public HttpTask(String url){
            this.url = url;
        }
        @Override
        protected void onPreExecute() {
            progressDialog.setTitle("Http Connecting ..");
            progressDialog.setMessage("Please Wait ..");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String str = HttpHandler.getString(url);
            return str;
        }

        @Override
        protected void onPostExecute(String str) {
            progressDialog.dismiss();
            textView.setText(str);
        }
    }
}




