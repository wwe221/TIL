package com.example.p427;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
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
        listView.setOnItemClickListener(this);
        String [] permissions = {
                Manifest.permission.CALL_PHONE
        };
        ActivityCompat.requestPermissions(this, permissions, 101);
        items = new ArrayList<>();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Item item = items.get(items.size()-i-1);
        int check = PermissionChecker.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE);
        Intent intent = null;
        if(check == PermissionChecker.PERMISSION_GRANTED) {
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+item.getPhone()));
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "No Permission", Toast.LENGTH_SHORT).show();
        }
    }

    class itemAdapter extends BaseAdapter {
            //리스트 뷰에 데이터와 UI를 바로 붙이는게 불가능하기 때문에 어댑터를 이용해서 리스트 뷰에 넣는다.
            ArrayList<Item> alist;
            public itemAdapter() {
            }
            public itemAdapter(ArrayList<Item> list) {
                this.alist = list;
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
            public View getView(int i, View view, ViewGroup viewGroup) {
                View myView = null;
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                myView = inflater.inflate(R.layout.mylayout, container,true);
                TextView tv1 = myView.findViewById(R.id.textView);
                TextView tv2 = myView.findViewById(R.id.textView2);
                tv1.setText(alist.get(i).name);
                tv2.setText(alist.get(i).phone);
                String imgname = alist.get(i).img;
                imgname="http://70.12.60.100/hello/"+imgname;
                final ImageView im = myView.findViewById(R.id.imageView);
                final String finalImgname = imgname;
                Thread t= new Thread(new Runnable() {
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
                                    im.setImageBitmap(bm);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
                final String phone ="tel:";
                final String numb = tv2.getText().toString();
               /* myView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int check = PermissionChecker.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.CALL_PHONE);
                        Intent i = null;
                        if(check == PermissionChecker.PERMISSION_GRANTED) {
                            i = new Intent(Intent.ACTION_CALL, Uri.parse(phone+numb));
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No Permission", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
                return myView;
            }
            public void setImg(ImageView view , String url){
                try {
                    URL u = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public long getItemId(int i) {
                return i;
            }
        }
    public void clickBt(View v){
        getData();
        it = new itemAdapter(items);
        listView.setAdapter(it);
    }
    public void clickBt2(View v){
        it.addItem(new Item("새로운이름","0111155555",R.drawable.itzy));
        it.notifyDataSetChanged(); // 새로고침 느낌
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
            Log.d("[asdfasdfasdf][]",str);
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
    private void getDataOg() {
        items = new ArrayList<>();
        items.add(new Item("일경헌","01011112222",R.drawable.it01));
        items.add(new Item("이경헌","01012345678",R.drawable.it02));
        items.add(new Item("삼경헌","01098765432",R.drawable.it03));
        items.add(new Item("사경헌","01074125896",R.drawable.it04));
        items.add(new Item("오경헌","01032165497",R.drawable.it05));
        items.add(new Item("김경헌","01074185296",R.drawable.it06));
        items.add(new Item("박경헌","01014725836",R.drawable.it07));
        items.add(new Item("조경헌","01001010101",R.drawable.it08));
    }
}
