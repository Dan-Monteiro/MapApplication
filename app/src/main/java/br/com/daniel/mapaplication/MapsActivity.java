package br.com.daniel.mapaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {

    private SupportMapFragment  mapFragment;
    private int mapType;

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        Intent i = getIntent();
        mapType = i.getIntExtra("TYPE",0);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                iniciarMapa(googleMap, mapType);
            }
        });
    }

    private void iniciarMapa(GoogleMap map, int mapType) {

        map.setMapType(mapType);

        int icon = 0;

            if(mapType % 2 == 0){
                icon = R.drawable.dart_board;
            }else{
                icon = R.drawable.objective;
            }

        LatLng localizacao = new LatLng(-8.295195, -35.979096);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(icon);
        map.addMarker(new MarkerOptions().position(localizacao)
                .title("Minha Rua"))
                .setIcon(bitmapDescriptor);

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(localizacao, 20);
        map.animateCamera(update);
        }
    }
