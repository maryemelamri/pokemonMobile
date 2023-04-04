package com.example.pokemoncard.entities;

import com.google.gson.annotations.SerializedName;

public class StatesPoke {
    @SerializedName("base_stat")
    private String baseStat;

    @SerializedName("stat")
    public StatesPoke.State state;

   private String nameState;

    public static class State {

        @SerializedName("name")
        public String name;

        public String getName() {
            return name;
        }
    }

    public String getNameState() {
        return nameState;
    }

    public String getBaseStat() {
        return baseStat;
    }

    public State getState() {
        return state;
    }

    public StatesPoke(String nameState,String baseStat) {
        this.baseStat = baseStat;
        this.nameState = nameState;
    }
}
