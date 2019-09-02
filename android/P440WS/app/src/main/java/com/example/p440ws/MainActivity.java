package com.example.p440ws;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<Item> items;
    ArrayList<Integer> images;
    LinearLayout container;
    ListView listView;
    itemAdapter it;
    TextView name , phone, cnt;
    Spinner spinner;
    int selectedImg = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt = findViewById(R.id.textView4);
        container = findViewById(R.id.container);
        name = findViewById(R.id.editText);
        phone = findViewById(R.id.editText2);
        listView=  findViewById(R.id.listview);
        spinner = findViewById(R.id.spinner);
        name.setHint("이름");
        phone.setHint("전화번호");
        getData();
        String [] permissions = {
                Manifest.permission.CALL_PHONE
        };
        ActivityCompat.requestPermissions(this, permissions, 101);
        ArrayAdapter<Integer> adapter2;
        adapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,images);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(this);
        it = new itemAdapter(items);
        listView.setAdapter(it);
        refresh();
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedImg = images.get(i);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
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
            ImageView im = myView.findViewById(R.id.imageView);
            TextView tv1 = myView.findViewById(R.id.textView);
            TextView tv2 = myView.findViewById(R.id.textView2);
            RatingBar ratingBar = myView.findViewById(R.id.ratingBar);
            int l = alist.size()-1;
            tv1.setText(alist.get(l - i).name);
            tv2.setText(alist.get(l - i).phone);
            ratingBar.setRating(alist.get(l-i).rating);
            im.setImageResource(alist.get(l - i).imgId);
            final int a= l - i;
            final String phone ="tel:";
            final String numb = tv2.getText().toString();
               myView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int check = PermissionChecker.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.CALL_PHONE);
                        Intent intent = null;
                        if (check == PermissionChecker.PERMISSION_GRANTED) {
                            intent = new Intent(Intent.ACTION_CALL, Uri.parse(phone + numb));
                            startActivity(intent);
                            alist.get(a).Ratingplus();
                            refresh();
                        } else {
                            Toast.makeText(getApplicationContext(), "No Permission", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            return myView;
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
    }
    public void add(View v){
        String a , b;
        int img;
        a = name.getText().toString();
        b= phone.getText().toString();
        img = selectedImg;
        Item item = new Item(a,b,img);
        it.addItem(item);
        refresh();
    }
    public void refresh(){
        it.notifyDataSetChanged(); // 새로고침 느낌
        cnt.setText(""+items.size());

    }
    private void getData() {
        items = new ArrayList<>();
        images = new ArrayList<>();
        items.add(new Item("일경헌","01011112222",R.drawable.it01));
        items.add(new Item("이경헌","01012345678",R.drawable.it02));
        items.add(new Item("삼경헌","01098765432",R.drawable.it03));
        items.add(new Item("사경헌","01074125896",R.drawable.it04));
        images.add(R.drawable.it01);
        images.add(R.drawable.it02);
        images.add(R.drawable.it03);
        images.add(R.drawable.it04);
        images.add(R.drawable.it05);
        images.add(R.drawable.it06);
        images.add(R.drawable.it07);
        images.add(R.drawable.it08);
        images.add(R.drawable.itzy);
    }
}
