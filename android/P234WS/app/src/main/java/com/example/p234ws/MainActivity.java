package com.example.p234ws;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ProgressBar progressBar;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        progressBar= findViewById(R.id.progressBar);
        bt=findViewById(R.id.button);
    }
    public void dialog(View v){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select your pick");
        LayoutInflater inflater = getLayoutInflater();
        final View tview = inflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.diaLay));
        final RadioGroup rg = tview.findViewById(R.id.radio);
        builder.setView(tview);
        final AlertDialog ap = builder.create();
        ap.show();
        Button bt2 = tview.findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.radioButton:{
                        imageView.setImageResource(R.drawable.cat1);
                        break;
                    }
                    case R.id.radioButton2:{
                        imageView.setImageResource(R.drawable.dog1);
                        break;
                    }
                    case R.id.radioButton3:{
                        imageView.setImageResource(R.drawable.itzy);
                        break;
                    }
                }//end switch
                TextView ta = tview.findViewById(R.id.editText2);
                if(ta.getText()!=null && !ta.getText().toString().equals("")) {
                    int k = Integer.parseInt(ta.getText().toString());
                    progressBar.setProgress(k);
                }
                ap.dismiss();
            }
        });
    }
}
