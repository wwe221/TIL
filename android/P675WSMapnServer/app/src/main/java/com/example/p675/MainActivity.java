package com.example.p675;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {
    SupportMapFragment mapFragment;
    GoogleMap map;
    double lat , lng;
    MarkerOptions myLocationMarker;
    TextView textView;
    Location location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String [] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        ActivityCompat.requestPermissions(this, permissions, 101);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.textView);
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
        if(check == PermissionChecker.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Yes Permission", Toast.LENGTH_SHORT).show();
            startLocationService();
        }
        else{
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
    private void showCurrentLocation(Double latitude, Double longitude) {
        LatLng curPoint = new LatLng(latitude, longitude);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 8));
    }
    private void showMyLocationMarker(LatLng curPoint) {
        if (myLocationMarker == null) {
            myLocationMarker = new MarkerOptions();
            myLocationMarker.position(curPoint);
            myLocationMarker.title("● 내 위치\n");
            myLocationMarker.snippet("● GPS로 확인한 위치");
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            map.addMarker(myLocationMarker);
        } else {
            myLocationMarker = new MarkerOptions();
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            myLocationMarker.position(curPoint);
            map.clear();
            map.addMarker(myLocationMarker);
        }
    }
    public void getData(double lat, double lng){
        String url = "http://70.12.60.100/hello/mylocation.jsp?lat="+lat+"&lng="+lng;
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
            Log.i("Posttest",str+"");
            JSONArray ja = null;
            try {
                ja = new JSONArray(str);
                for(int i=0;i <ja.length();i++){
                    JSONObject jo = ja.getJSONObject(i);
                    double latt = jo.getDouble("lat");
                    double lngg = jo.getDouble("lng");
                    lat = latt;
                    lng = lngg;
                }
                    Log.i("latlat",lat+"");
                LatLng curPoint = new LatLng(lat, lng);
                location.setLatitude(lat);
                location.setLatitude(lng);
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 11));
                showMyLocationMarker(curPoint);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
