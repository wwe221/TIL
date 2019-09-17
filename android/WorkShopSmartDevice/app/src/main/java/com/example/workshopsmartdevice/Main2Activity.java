package com.example.workshopsmartdevice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    SupportMapFragment mapFragment;
    GoogleMap map;
    double lat , lng;
    MarkerOptions myLocationMarker;
    Location location;
    ArrayList<LatLng> locats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        locats= new ArrayList<>();
        ActivityCompat.requestPermissions(this, permissions, 101);
        setContentView(R.layout.activity_main2);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d("Map", "지도 준비됨.");
                map = googleMap;
                map.setMyLocationEnabled(true);
            }
        });
        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int check = PermissionChecker.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (check == PermissionChecker.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Yes Permission", Toast.LENGTH_SHORT).show();
            startLocationService();
        } else {
            Toast.makeText(getApplicationContext(), "No Permission", Toast.LENGTH_SHORT).show();
        }
    }
    public void startLocationService() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                lat = location.getLatitude();
                lng = location.getLongitude();
                getData(lat,lng);
            }
            GPSListener gpsListener = new GPSListener();
            long minTime = 3000; //1 초마다
            float minDistance = 0; // 위치가 1이라도 바뀌면
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER , //NETWORK_PROVIDER
                    minTime, minDistance, gpsListener);
            Toast.makeText(getApplicationContext(), "mylocation",
                    Toast.LENGTH_SHORT).show();
        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }
class GPSListener implements LocationListener {
    public void onLocationChanged(Location location) {
        getData(lat,lng);
    }
    public void onProviderDisabled(String provider) { }
    public void onProviderEnabled(String provider) { }
    public void onStatusChanged(String provider, int status, Bundle extras) { }
}
    private void showLocationLists(ArrayList<LatLng> list){
        int l = list.size();
        map.clear();
        for(int i=0;i<l;i++){
            myLocationMarker = new MarkerOptions();
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            myLocationMarker.position(list.get(i));
            map.addMarker(myLocationMarker);
        }
    }
    public void getData(double lat, double lng){
        String url = "http://70.12.60.100/hello/mylocation2.jsp?lat="+lat+"&lng="+lng;
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
        Log.i("backGroundtest",url);
        String str = HttpHandler.getString(url);
        Log.i("backGroundtest",str+"");
        return str;
    }
    @Override
    protected void onPostExecute(String str) {
        JSONArray ja = null;
        try {
            ja = new JSONArray(str);
            for(int i=0;i <ja.length();i++){
                JSONObject jo = ja.getJSONObject(i);
                double latt = jo.getDouble("lat");
                double lngg = jo.getDouble("lng");
                LatLng a = new LatLng(latt,lngg);
                locats.add(a);
                Log.i("JSONtest",a.latitude+"");
            }
            LatLng cur = new LatLng(lat,lng);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(cur, 13));
            showLocationLists(locats);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
}
