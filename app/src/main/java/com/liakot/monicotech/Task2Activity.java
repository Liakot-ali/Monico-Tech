package com.liakot.monicotech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Task2Activity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        map = findViewById(R.id.map);
        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng loc1 = new LatLng(23.81426279756788, 90.40413862620731);
        LatLng loc2 = new LatLng(23.808106397946844, 90.40328323667977);
        LatLng loc3 = new LatLng(23.798141522836097, 90.40168671183021);
        LatLng loc4 = new LatLng(23.78979393341548, 90.40020439868736);
        LatLng loc5 = new LatLng(23.77941034563629, 90.39837976942222);

        this.gMap = googleMap;
        this.gMap.addMarker(new MarkerOptions().position(loc1).title("Location 1"));
        this.gMap.addMarker(new MarkerOptions().position(loc2).title("Location 2"));
        this.gMap.addMarker(new MarkerOptions().position(loc3).title("Location 3"));
        this.gMap.addMarker(new MarkerOptions().position(loc4).title("Location 4"));
        this.gMap.addMarker(new MarkerOptions().position(loc5).title("Location 5"));

        LatLng dhaka = new LatLng(23.777176, 90.399452);
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(dhaka));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(13);
        gMap.animateCamera(zoom);
    }
}