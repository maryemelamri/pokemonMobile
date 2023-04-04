package com.example.pokemoncard.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListPoke {
    @SerializedName("results")
    private ArrayList<Pokemon> arrayPoke;

    public ArrayList<Pokemon> getArrayPoke() {
        return arrayPoke;
    }


}
