package com.example.p233;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ProgressBar progressBar;
    TextView textView , textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar= findViewById(R.id.seekBar);
        progressBar= findViewById(R.id.progressBar2);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.editText2);
        textView2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(textView2.getText()!=null && !textView2.getText().toString().equals("")) {
                    int k = Integer.parseInt(textView2.getText().toString());
                    progressBar.setProgress(k);
                    seekBar.setProgress(k);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    progressBar.setProgress(i);
                    textView2.setText(""+i);
                }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
