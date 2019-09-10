package com.example.p536;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class diary_List extends AppCompatActivity {
    ArrayList<Item> items;
    LinearLayout container;
    ListView listView;
    itemAdapter it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary__list);
        Intent i = getIntent();
        items = (ArrayList<Item>) i.getSerializableExtra("item");
        it = new itemAdapter(items);
        listView=findViewById(R.id.listview);
        listView.setAdapter(it);
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
            TextView tv1 = myView.findViewById(R.id.miniDate);
            TextView tv2 = myView.findViewById(R.id.miniTitle);
            int l = alist.size()-1;
            final String title = alist.get(l - i).title;
            final String date = alist.get(l - i).date;
            final String contents =alist.get(l - i).content;
            tv1.setText(title);
            tv2.setText(date);
            myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),detail.class);
                    i.putExtra("title",title);
                    i.putExtra("date",date);
                    i.putExtra("content",contents);
                    startActivity(i);
                }
            });
            return myView;
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
    }
}
