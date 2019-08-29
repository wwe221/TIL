package com.example.p258;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onReStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDesproy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder d= new AlertDialog.Builder(this);
        d.setTitle("hello");
        d.setMessage("what's up today?");
        d.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 finish();
            }
        });
        d.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        AlertDialog dpp = d.create();
        dpp.show();
    }

    public void btclick(View v){
        Intent i = null;
        switch (v.getId()){
            case R.id.button1:{
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                //default browser가 뜨면서 이동
                break;
            }
            case R.id.button2:{
                i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:01045418273"));
                break;
            }
            case R.id.button3:{
                i= new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01045418273"));
                break;
            }
        }
        startActivity(i);
    }
}
