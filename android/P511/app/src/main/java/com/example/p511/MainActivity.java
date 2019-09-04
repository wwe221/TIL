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
    httpTask httpTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        progressDialog= new ProgressDialog(this);
    }

    public void clickBt(View v){
        httpTask = new httpTask("http://www.google.com");
        httpTask.execute();
    }

    class httpTask extends AsyncTask<String, Void, String> {
        String url = "";
        public httpTask(String url) {
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.setTitle("http connecting");
            progressDialog.setMessage("plz wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            return  HttpHandler.getString(url);
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
            progressDialog.dismiss();
        }
    }
}
