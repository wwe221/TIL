package com.example.p228;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
    }
    public void pbar(View v){
        int a = progressBar.getProgress();
        if(v.getId() == R.id.button){
            progressBar.setProgress(a+10);
        }else{
            progressBar.setProgress(a-10);
        }
    }
    public void pdia(View v){
        if(v.getId() == R.id.button3){
            progressDialog= new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("progressing...");
            progressDialog.setButton(progressDialog.BUTTON_NEGATIVE, "canclse", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    progressDialog.dismiss();
                }
            });
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }
}
