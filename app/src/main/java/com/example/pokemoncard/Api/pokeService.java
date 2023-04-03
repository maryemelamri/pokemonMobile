package com.example.pokemoncard.Api;

import com.example.pokemoncard.entities.PokemonInfo;
import com.example.pokemoncard.repository.PokemonRepository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface pokeService {
    @GET("pokemon")
    Call<PokemonRepository> listPoke (@Query("limit") int limit,@Query("offset") int offset);

//    @GET("pokemon/{name}")
//    Call<PokemonInfo> pokemonInfo(@Path("name") String name);
}