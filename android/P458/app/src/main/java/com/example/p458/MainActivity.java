package com.example.p458;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new JS(),"js");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        textView = findViewById(R.id.textView);
        webView.loadUrl("http://m.naver.com");
    }
    class JS{
        JS(){}
        @android.webkit.JavascriptInterface
        public void webclick(String str){
            textView.setText(str);
            Toast.makeText(MainActivity.this,
                    ""+str, Toast.LENGTH_SHORT).show();
        }
    }
    public void clickBt(View view){
        if(view.getId() == R.id.button){
            webView.loadUrl("http://www.daum.net");
        }else if(view.getId() == R.id.button2){
            webView.loadUrl("http://70.12.60.90/webview");
        }else if(view.getId() == R.id.button3){
            webView.loadUrl("javascript:s('cmd')");
        }
    }
}
