package com.example.p427;
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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
                ImageView im = myView.findViewById(R.id.imageView);
                TextView tv1 = myView.findViewById(R.id.textView);
                TextView tv2 = myView.findViewById(R.id.textView2);
                int l = alist.size()-1;
                tv1.setText(alist.get(l - i).name);
                tv2.setText(alist.get(l - i).phone);
                im.setImageResource(alist.get(l - i).imgId);
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

    private void getData() {
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
