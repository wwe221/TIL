package com.example.p178;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt;
    RadioButton radioButton, radioButton2;
    CheckBox checkBox, checkBox2;
    Switch aSwitch;
    ToggleButton toggleButton;
    TextView textView , textView2 , textView3, textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt= findViewById(R.id.button);
        bt.setOnClickListener(this); // 버튼에 이벤트가 들어오면~ MainActivity 가 처리한다. -> onClick 함수가 처리한다.

        radioButton = findViewById(R.id.radioButton);
        radioButton2= findViewById(R.id.radioButton2);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        aSwitch = findViewById(R.id.switch1);
        toggleButton=findViewById(R.id.toggleButton);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                if (b)
                    bt.setBackgroundColor(Color.BLUE);
                else
                    bt.setBackgroundColor(Color.RED);

            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    bt.setBackgroundColor(Color.BLACK);
                else
                    bt.setBackgroundColor(Color.WHITE);

            }
        });
        textView = findViewById(R.id.editText);
        textView2 = findViewById(R.id.editText2);
        textView3 = findViewById(R.id.autoCompleteTextView);
        textView2.setFocusable(true);
        textView2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    view.setBackgroundColor(Color.RED);
                    textView2.setHint("");
                }
                else {
                    view.setBackgroundColor(Color.GRAY);
                    textView2.setHint("type here!!");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(this, "Click" +checkBox.isChecked(), Toast.LENGTH_SHORT).show();
    }
}
