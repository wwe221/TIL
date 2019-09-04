package com.example.p511;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {

    public static String getString(String url){
        String result ="";
        URL u = null;
        HttpURLConnection hcon = null;
        InputStream is = null;
        try {
            u = new URL(url);
            hcon = (HttpURLConnection) u.openConnection();
            hcon.setConnectTimeout(10000);
            hcon.setRequestMethod("GET");

            is = new BufferedInputStream(hcon.getInputStream());
            result = converStr(is);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            hcon.disconnect();
        }
        return result;
    }

    public static String converStr(InputStream inputStream){
        BufferedReader bf = null;

        bf=  new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb =new StringBuilder();
        String temp;

        try{
            while((temp = bf.readLine()) != null){
                sb.append(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
