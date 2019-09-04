package com.example.p535;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<Item> items;
    ListView listView;
    LinearLayout container;
    itemAdapter it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        listView = findViewById(R.id.listView);
        items = new ArrayList<>();


    }
    public void clickBt(View v){
        getData();
        it = new itemAdapter(items);
        listView.setAdapter(it);
        it.notifyDataSetChanged();
    }
    class itemAdapter extends BaseAdapter {
        ArrayList<Item> alist;

        public itemAdapter(ArrayList<Item> alist) {
            this.alist = alist;
        }
        public void addItem(Item item){
            alist.add(item);
        }
        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int i) {
            return alist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView = null;
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.mylayout, container,true);
            TextView tv1 = myView.findViewById(R.id.textView);
            TextView tv2 = myView.findViewById(R.id.textView2);
            tv1.setText(alist.get(i).name);
            tv2.setText(alist.get(i).nation);
            String imgname = alist.get(i).img;
            imgname="http://70.12.60.100/hello/"+imgname;
            final ImageView iv = myView.findViewById(R.id.imageView);
            final String finalImgname = imgname;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    URL u =null;
                    try {
                        InputStream is = null;
                        u = new URL(finalImgname);
                        is=u.openStream();
                        final Bitmap bm = BitmapFactory.decodeStream(is);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                iv.setImageBitmap(bm);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            return myView;
        }
    }
    private void getData(){
        String url = "http://70.12.60.100/hello/Item.jsp";
        HttpTask httpTask = new HttpTask(url);
        httpTask.execute();
    }
    class HttpTask extends AsyncTask<String,Void,String> {
        String url;
        public HttpTask(String url){
            this.url = url;
        }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected String doInBackground(String... strings) {
            String str = HttpHandler.getString(url);
            return str;
        }
        @Override
        protected void onPostExecute(String str) {
            JSONArray ja = null;
            try {
                ja = new JSONArray(str);
                for(int i=0;i <ja.length();i++){
                    JSONObject jo = ja.getJSONObject(i);
                    String name = jo.getString("name");
                    String phone = jo.getString("nation");
                    String img = jo.getString("img");
                    Log.i("[JSON}}",name + " " + phone + " "+img);
                    Item item = new Item(name, phone,img);
                    items.add(item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
