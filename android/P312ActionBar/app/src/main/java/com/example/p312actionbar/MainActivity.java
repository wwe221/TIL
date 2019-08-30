package com.example.p312actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.drm.DrmStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.sky);
        actionBar.setTitle("hiroo");
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.cat){
            Toast.makeText(this, "cat", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.dog){
            Toast.makeText(this, "dog", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.itzy){
            Toast.makeText(this, "itzy", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }
}
