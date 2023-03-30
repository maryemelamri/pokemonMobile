package com.example.pokemoncard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.pokemoncard.Api.pokeService;
import com.example.pokemoncard.repository.PokemonRepository;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pokemon[] pk = new Pokemon[]{

                new Pokemon("pk1",R.drawable._02),
                new Pokemon("pk1",R.drawable._03),
                new Pokemon("pk1",R.drawable._04),
                new Pokemon("pk1",R.drawable._07)
        };
        int [] imgs = {R.drawable._02,R.drawable._03,R.drawable._04,R.drawable._07,};

        GridAdapter ga = new GridAdapter(MainActivity.this,pk,imgs);

        GridView gv;
        gv=(GridView)findViewById(R.id.gridview);
        gv.setAdapter(ga);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,GridItemActivity.class);
                System.out.println("pk "+pk[i].getUrl());
                System.out.println("img "+imgs[i]);
                intent.putExtra("textPok",pk[i].getName());
                intent.putExtra("imgPok",imgs[i]);
                startActivity(intent);
            }
        });
        retrofit = new Retrofit.Builder()
                .baseUrl("pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



    }
    //charge data
    private void getData(){
        //so we could could variable service
    pokeService service = retrofit.create(pokeService.class );
    Call<PokemonRepository> PokemonRepositoryCall= service.listPoke();
    PokemonRepositoryCall.enqueue(new Callback<PokemonRepository>() {
        @Override
        public void onResponse(Call<PokemonRepository> call, Response<PokemonRepository> response) {
            if (response.isSuccessful()){

            }
        }

        @Override
        public void onFailure(Call<PokemonRepository> call, Throwable t) {

        }
    });
    }
}