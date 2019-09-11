package com.example.p675;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {
    public static String getString(String urlstr){
        String result = null;
        URL url = null;
        HttpURLConnection hcon = null;
        InputStream is = null;
        try {
            url = new URL(urlstr);
            hcon = (HttpURLConnection)url.openConnection();
            hcon.setConnectTimeout(10000);
            hcon.setRequestMethod("GET");
            is = new BufferedInputStream(hcon.getInputStream());
            result = convertStr(is);
            Log.i("handlertest",result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hcon.disconnect();
        }
        return result;
    }

    public static String convertStr(InputStream is){
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String temp;
        try{
            while((temp = br.readLine()) != null){
                sb.append(temp);
                Log.i("temptest",temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
