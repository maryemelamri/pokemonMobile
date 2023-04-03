package com.example.pokemoncard.entities;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    private int id;
@SerializedName("name")
    private String name;
    @SerializedName("name")
    private String url;
    private int img;

    public Pokemon(String name, int url)  {
        this.name= name;
        this.img= url;
    }

    public int getUrl() {
        return img;
    }

    public int getId() {
        String [] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length-1]);

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
