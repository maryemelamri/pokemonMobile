package com.example.pokemoncard.entities;

import com.google.gson.annotations.SerializedName;

public class TypesPoke {
    public String nameType;

    public TypesPoke(String nameType) {
        this.nameType = nameType;
    }

    public String getNameType() {
        return nameType;
    }

    @SerializedName("type")
    public Type type;

    public Type getType() {
        return type;
    }

    public static class Type {

        @SerializedName("name")
        public String name;

        public String getName() {
            return name;
        }
    }

    @Override
    public String toString() {
        return "TypesResponse{" +
                "nameType='" + nameType + '\'' +
                '}';
    }
}
