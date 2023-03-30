package com.example.pokemoncard.Api;

import com.example.pokemoncard.Pokemon;
import com.example.pokemoncard.repository.PokemonRepository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface pokeService {
    @GET("pokemon")
    Call<PokemonRepository> listPoke ();
}