package com.example.pokemoncard;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokemoncard.Api.pokeService;
import com.example.pokemoncard.entities.Pokemon;
import com.example.pokemoncard.repository.PokemonRepository;

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
    }
    //charge data
    private void getData(int offset){
        //so we could could variable service
    pokeService service = retrofit.create(pokeService.class );
    Call<PokemonRepository> PokemonRepositoryCall= service.listPoke(20,offset);

    PokemonRepositoryCall.enqueue(new Callback<PokemonRepository>() {
        @Override
        public void onResponse(Call<PokemonRepository> call, Response<PokemonRepository> response) {
            done=true;
            if (response.isSuccessful()){
                PokemonRepository pkrepo = response.body();
                ArrayList<Pokemon> listPk = pkrepo.getResults();
               listAdapter.dragdata(listPk);

            }else {
                Log.e("info","on response: "+response.body());
            }
        }

        @Override
        public void onFailure(Call<PokemonRepository> call, Throwable t) {
            done=true;
            Log.e("info","on failure: "+t.getMessage());
        }
    });
    }
}