package com.example.p200;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {
    View view1, view2;
    TextView textView;
    GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }
    private void setUi() {
        view1 =findViewById(R.id.view);
        view2 =findViewById(R.id.view2);
        textView = findViewById(R.id.textView);
        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                print("ondown");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                print("onShow");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                print("onSingletapup");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                print("onScroll"+ v+" "+ v1);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                print("LongPress");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                print("FLING"+ v+" "+ v1);
                return false;
            }
        });
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if(action == MotionEvent.ACTION_DOWN){ // 눌렸을 때
                    print("Down"+ x +" "+ y);
                    view.setBackgroundColor(Color.BLACK);
                }
                else if(action == MotionEvent.ACTION_UP){ // 뗐을 때
                    print("Up"+ x +" "+ y);
                    view.setBackgroundColor(Color.RED);

                }
                else if(action == MotionEvent.ACTION_MOVE){//눌린 상태로 움직일 때
                    print("Move"+ x +" "+ y);
                    view.setBackgroundColor(Color.BLUE);

                }
                return true;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }
    private void print(String str){
        textView.setText(str+"\n"+textView.getText());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 핸드폰의 버튼이 눌렸을 때
        if(keyCode== KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {// 가로/세로 방향이 바뀌었을때
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            show("Landscape 방향쓰");
        }
        else if(newConfig.orientation ==Configuration.ORIENTATION_PORTRAIT){
            show("Portrait 방향쓰");
        }
    }
    public void show(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
