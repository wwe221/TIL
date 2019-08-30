package com.example.p258;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] permissions = {
                Manifest.permission.CALL_PHONE
        };

        checkPermissions(permissions);

    }

    public void checkPermissions(String[] permissions) {
        ArrayList<String> targetList = new ArrayList<String>();

        for (int i = 0; i < permissions.length; i++) {
            String curPermission = permissions[i];
            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, curPermission + " 권한 있음.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, curPermission + " 권한 없음.", Toast.LENGTH_LONG).show();
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)) {
                    Toast.makeText(this, curPermission + "권한 설명 필요함", Toast.LENGTH_LONG).show();
                } else {
                    targetList.add(curPermission);
                }
            }
        }

        String[] targets = new String[targetList.size()];
        targetList.toArray(targets);

        ActivityCompat.requestPermissions(this, targets, 101);

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
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
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
