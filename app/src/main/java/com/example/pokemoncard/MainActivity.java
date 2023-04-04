package com.example.pokemoncard;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.pokemoncard.Api.PokeService;
import com.example.pokemoncard.entities.Pokemon;
import com.example.pokemoncard.entities.ListPoke;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private RecyclerView recView;
    private listpokemonAdapter listAdapter;
    private int offset;
    private boolean done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recView = findViewById(R.id.gridview);
        listAdapter = new listpokemonAdapter(this);
        recView.setAdapter(listAdapter);
        recView.setHasFixedSize(true);
        GridLayoutManager gridManager = new GridLayoutManager(this,2);
        recView.setLayoutManager(gridManager);
        //add scroll methode katb9a tzad kolma scrollina

        recView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy >0){
                    int visibleItemCount = gridManager.getChildCount();
                    int totalItemCount = gridManager.getItemCount();
                    int pastVisibileItems = gridManager.findFirstVisibleItemPosition();

                    if (done){
                        if((visibleItemCount+ pastVisibileItems)>= totalItemCount)
                            Log.e("info","++ End of List ++");
                            done = false;
                            offset+=20;
                            getData(offset);
                    }
                }
            }
        });


        /*Pokemon[] pk = new Pokemon[]{

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
        });*/
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build(); done=true;
        Log.i("Info", "onCreate: 9bal data");
        offset =0;
        getData(offset);

        Log.i("Info", "onCreate: data jat");
        recView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        Intent intent = new Intent(MainActivity.this, GridItemActivity.class);
                        intent.putExtra("id", position+1);// put url data in Intent
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }
    //charge data
    private void getData(int offset){
        //so we could could variable service
    PokeService service = retrofit.create(PokeService.class );

    Call<ListPoke> ListPokeCall = service.listPoke(20,offset);

    ListPokeCall.enqueue(new Callback<ListPoke>() {
        @Override
        public void onResponse(Call<ListPoke> call, Response<ListPoke> response) {
            done=true;
            if (response.isSuccessful()){
                ListPoke pkrepo = response.body();
                ArrayList<Pokemon> listPk = pkrepo.getArrayPoke();
               listAdapter.dragdata(listPk);

            }else {
                Log.e("info","on response: "+response.body());
            }
        }

        @Override
        public void onFailure(Call<ListPoke> call, Throwable t) {
            done=true;
            Log.e("info","on failure: "+t.getMessage());
        }
    });
    }
}