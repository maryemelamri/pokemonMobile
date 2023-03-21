package com.example.pokemoncard;

public class Pokemon {

    private String name;
    private int img;

    public Pokemon(String name, int url)  {
        this.name= name;
        this.img= url;
    }

    public int getUrl() {
        return img;
    }

    public void setUrl(int url) {
        this.img = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()  {
        return name;
    }
}
