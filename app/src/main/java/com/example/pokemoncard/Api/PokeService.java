package com.example.pokemoncard.Api;

import com.example.pokemoncard.entities.ListPoke;
import com.example.pokemoncard.entities.PokemonInfo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeService {
    @GET("pokemon")
    Call<ListPoke> listPoke (@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<PokemonInfo> pokemonInfo(@Path("id") int id);
}