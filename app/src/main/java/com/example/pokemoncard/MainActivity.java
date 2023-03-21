package com.example.pokemoncard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pokemon pk  []= {
                new Pokemon("pk1",R.drawable._02),
                new Pokemon("pk1",R.drawable._03),
                new Pokemon("pk1",R.drawable._04),
                new Pokemon("pk1",R.drawable._07)
        };
        GridAdapter ga = new GridAdapter(MainActivity.this,pk);

        GridView gv;
        gv=(GridView)findViewById(R.id.gridview);
        gv.setAdapter(ga);
    }
}