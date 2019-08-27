package com.example.p170;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageView upimg, downimg;
    TextView input , output;
    LinearLayout first, second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }
    private void setUi() {
        first=findViewById(R.id.firstS);
        second=findViewById(R.id.secondS);
        upimg =findViewById(R.id.upimg2);
        upimg.setImageResource(R.drawable.itzy);
        downimg =findViewById(R.id.downimg2);
        downimg.setImageResource(R.drawable.itzy);
        input = findViewById(R.id.input);
        output = findViewById(R.id.count);
        input.addTextChangedListener(tw);
        disable();
    }
    TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            int l = input.length();
            output.setText(l+" 글자");
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void disable() {
        second.setVisibility(View.INVISIBLE);
        upimg.setVisibility(View.INVISIBLE);
        downimg.setVisibility(View.INVISIBLE);
    }
    public void btclick(View v){
        int vid = v.getId();
        if(vid==R.id.up){
            upimg.setVisibility(View.VISIBLE);
            downimg.setVisibility(View.INVISIBLE);
        }
        else if(vid==R.id.down){
            upimg.setVisibility(View.INVISIBLE);
            downimg.setVisibility(View.VISIBLE);
        }
        else if(vid==R.id.first){
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.INVISIBLE);
        }
        else if(vid==R.id.second){
            first.setVisibility(View.INVISIBLE);
            second.setVisibility(View.VISIBLE);
        }
        else if(vid==R.id.send){
            Toast.makeText(this, input.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(vid==R.id.close){
            input.setText("");
        }
    }
}
