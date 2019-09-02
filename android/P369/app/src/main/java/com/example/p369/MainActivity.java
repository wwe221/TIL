package com.example.p369;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        // action 추가
        BroadcastReceiver bReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                ConnectivityManager connectivityManager = null;
                NetworkInfo mobile = null;
                NetworkInfo wifi = null;
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    if (mobile != null && mobile.isConnected()) {
                        Toast.makeText(context, "MOBILE", Toast.LENGTH_SHORT).show();
                    } else if (wifi != null && wifi.isConnected()) {
                        Toast.makeText(context, "WIFI", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "NO CONN", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        registerReceiver(bReceiver, intentFilter);
        // intentFilter 가 가진 action 발생시 , bReceiver 가 처리한다.
        String [] permissions = {
                Manifest.permission.CALL_PHONE
        };
        ActivityCompat.requestPermissions(this, permissions, 101);
    }// end onCreate

    public void clicktext( View view){
        int check = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        Intent i = null;
        if(check == PermissionChecker.PERMISSION_GRANTED) {
            i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01012345678"));
            startActivity(i);
        }
        else{
            Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
        }


    }
}
