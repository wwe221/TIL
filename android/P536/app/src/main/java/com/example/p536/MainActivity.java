package com.example.p536;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView idText, pwdText , result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idText=findViewById(R.id.idText);
        pwdText=findViewById(R.id.pwdText);
        result = findViewById(R.id.result);

    }
    public void btclick(View v){
        String id = idText.getText().toString();
        String pwd = pwdText.getText().toString();
        getData(id,pwd);
    }
    private void getData(String id , String pwd){
        String url = "http://70.12.60.100/hello/login.jsp";
        Log.i("inputtest",url);
        HttpTask httpTask = new HttpTask(url,id,pwd);
        httpTask.execute();
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("save", true);
        editor.putString("id",id);
        editor.putString("pwd",pwd);
        editor.commit();
    }
    class HttpTask extends AsyncTask<String,Void,String> {
        String url;
        String id , pwd;
        public HttpTask(String url){
            this.url = url;
        }
        public HttpTask(String url, String id, String pwd) {
            this.url = url+"?id="+id+"&pwd="+pwd;

        }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected String doInBackground(String... strings) {
            Log.i("backGroundtest",url);
            String str = HttpHandler.getString(url);
            Log.i("backGroundtest",str+"");
            return str;
        }
        @Override
        protected void onPostExecute(String str) {
            if(str.equals("0")) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
            else
                result.setText("나가");

        }
    }
}
