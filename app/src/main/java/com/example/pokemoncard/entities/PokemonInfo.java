package com.example.pokemoncard.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonInfo {
@SerializedName("name")
    private String name;

    @SerializedName("stats")
    private List<StatesPoke> stats;
    @SerializedName("types")
    private List<TypesPoke> types;

    @SerializedName("height")
    private int height;


    public String heightFormatted;

    @SerializedName("weight")
    private int weight;

    public String getName() {
        return name;
    }

    public List<StatesPoke> getStats() {
        return stats;
    }

    public List<TypesPoke> getTypes() {
        return types;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public PokemonInfo(String name, List<StatesPoke> stats, List<TypesPoke> types, int height, int weight) {
        this.name = name;
        this.stats = stats;
        this.types = types;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PokemonInfo{" +
                "name='" + name + '\'' +
                ", stats=" + stats +
                ", types=" + types +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
