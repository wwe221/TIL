package com.example.p217;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toast(View v){ // Toast 에 새로 만든 화면을 붙이기
        LayoutInflater inflater = getLayoutInflater();
        View tview = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.tLayout));
        Toast toast = new Toast(this);
        toast.setView(tview);
        toast.setDuration(Toast.LENGTH_LONG);
        TextView view = tview.findViewById(R.id.textView);
        view.setText("Itzy is exist");
        toast.show();
    /*Toast toastView= Toast.makeText(this,"위치가 바뀐다",Toast.LENGTH_LONG);
    toastView.setGravity(Gravity.TOP|Gravity.TOP,150,300);
    toastView.show();*/

    }
    public void snack(View v){
    }
    public void dialog(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("new Dialog");
        builder.setMessage("message 1 2 3 ");
        builder.setIcon(R.drawable.itzy);
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "nonono", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "yesyesyes", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        LayoutInflater inflater = getLayoutInflater();
        View tview = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.tLayout));
        builder.setView(tview);
        TextView view = tview.findViewById(R.id.textView);
        view.setText("어플리케이션을 나가겠심?");
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }
    public void progress(View v){

    }
}
