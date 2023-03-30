package com.example.pokemoncard.repository;

import com.example.pokemoncard.Pokemon;

import java.util.ArrayList;

public class PokemonRepository {
    //Pokemon listpoke();
    ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
