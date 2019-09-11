package com.example.p674;

import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    double lat , lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);// 이때 onMapReady 자동으로 실행됨

    String [] permissions = {
            Manifest.permission.ACCESS_FINE_LOCATION
    };
        ActivityCompat.requestPermissions(this, permissions, 101);
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
            Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                lat = location.getLatitude();
                lng = location.getLongitude();
            }

            GPSListener gpsListener = new GPSListener();
            long minTime = 10000; //10초마다
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
        lat = location.getLatitude();
        lng = location.getLongitude();
    }

    public void onProviderDisabled(String provider) { }

    public void onProviderEnabled(String provider) { }

    public void onStatusChanged(String provider, int status, Bundle extras) { }
}

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));

    }
}
