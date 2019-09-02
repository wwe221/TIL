package com.example.p436;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ArrayList<String> list;
    ArrayList<Integer> list2;
    Spinner spinner;
    ImageView imageView;
    RatingBar ratingBar;
    float rating =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner2);
        imageView = findViewById(R.id.imageView);
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setMax(5);
        ratingBar.setNumStars(5);
        ratingBar.setStepSize(1);
        ratingBar.setRating(0);
        getData();
        /*ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/
        ArrayAdapter<Integer> adapter2;
        adapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(this);

    }

    private void getData() {
        list = new ArrayList<>();
        list.add("010123450");
        list.add("0101111118");
        list.add("0102222227");
        list.add("0103453152");
        list.add("0100659843");
        list.add("0106857496");
        list2 = new ArrayList<>();
        list2.add(R.drawable.it01);
        list2.add(R.drawable.it02);
        list2.add(R.drawable.it03);
        list2.add(R.drawable.it04);
        list2.add(R.drawable.it05);
        list2.add(R.drawable.it06);
        list2.add(R.drawable.it07);
        list2.add(R.drawable.it08);
        list2.add(R.drawable.itzy);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //String str = list.get(i);
        //Toast.makeText(this, " "+str, Toast.LENGTH_SHORT).show();
        int id = list2.get(i);
        Toast.makeText(this, " "+id, Toast.LENGTH_SHORT).show();
        imageView.setImageResource(id);
        rating++;
        ratingBar.setRating(rating);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

