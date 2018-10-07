package br.com.daniel.mapaplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {

    private SupportMapFragment  mapFragment;

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                iniciarMapa(googleMap);
            }
        });
    }

    private void iniciarMapa(GoogleMap map) {
        LatLng fafica = new LatLng(-8.295195, -35.979096);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(fafica, 20);
        map.animateCamera(update);
        }
    }
