package br.com.daniel.mapaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMapNormal = findViewById(R.id.mapaNormal);
        buttonMapNormal.setOnClickListener(this);
        Button buttonMapHibrido = findViewById(R.id.mapaHibrido);
        buttonMapHibrido.setOnClickListener(this);
        Button buttonMapTerreno = findViewById(R.id.mapaTerreno);
        buttonMapTerreno.setOnClickListener(this);
        Button buttonMapSatelite = findViewById(R.id.mapaSatelite);
        buttonMapSatelite.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        int mapType = 0;
        
        if(id == R.id.mapaNormal){
            mapType = GoogleMap.MAP_TYPE_NORMAL;
        }else if(id == R.id.mapaHibrido){
            mapType = GoogleMap.MAP_TYPE_HYBRID;
        }else if(id == R.id.mapaTerreno){
            mapType = GoogleMap.MAP_TYPE_TERRAIN;
        }else if(id == R.id.mapaSatelite){
            mapType = GoogleMap.MAP_TYPE_SATELLITE;
        }

        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("TYPE", mapType);
        startActivity(intent);
    }
}
