package com.example.p536;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView textView , title;
    TextView dates , contents;
    DatabaseHelper dbHelper;
    SQLiteDatabase database;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        textView=findViewById(R.id.textView);
        textView.setText(pref.getString("id",""));
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        title = findViewById(R.id.editText);
        dates = findViewById(R.id.textView2);
        contents = findViewById(R.id.editText2);
        items=  new ArrayList<>();
        create();
    }
    public void calenderBt(View v){
        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
        startActivityForResult(intent,101);
    }
    public void saveBt(View v){
        String t = title.getText().toString();
        String d = dates.getText().toString();
        String c = contents.getText().toString();
        insert(t,d,c);
    }
    public void listBt(View v){
        select();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String date = data.getStringExtra("data");
        dates.setText(date);
    }

    public void create (){
        String name = "dia";
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();
        if (database == null) {
            return;
        }
        database.execSQL("create table if not exists " + name + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " title text, "
                + " date text, "
                + " contents text)");
    }
    public void insert (String a, String b, String c){
        if (database == null) {
            return;
        }
        String query ="insert into dia"
                + "(title, date, contents) values "
                + "('" + a + " ' , ' " +  b + " ' , ' " + c + " ' ) ";
        Log.i("qqq",query);
        database.execSQL(query);
    }
    public void select (){
        Cursor cursor = database.rawQuery("select _id, title, date, contents from dia", null);
        int recordCount = cursor.getCount();
        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            String mobile = cursor.getString(3);
            Item it = new Item(name, age, mobile);
            items.add(it);
        }
        cursor.close();
        Intent intent = new Intent(Main2Activity.this,diary_List.class);
        intent.putExtra("item",items);
        startActivity(intent);
    }
    public void jsonClick(View v){
        Intent i = new Intent(getApplicationContext(),jsonAc.class);
        startActivity(i);
    }
}
