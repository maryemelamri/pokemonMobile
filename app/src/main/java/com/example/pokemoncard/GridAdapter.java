package com.example.pokemoncard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokemoncard.entities.Pokemon;

public class GridAdapter extends BaseAdapter {

    Context context;
    Pokemon[] pokemons;
    int [] image;
    LayoutInflater inflater;

    public GridAdapter(Context context, Pokemon[] pokemons, int []image){
        this.context = context;
        this.pokemons = pokemons;
        this.image = image;
    }


    @Override
    public int getCount() {
        return pokemons.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            convertView = inflater.inflate(R.layout.main_item,null);

        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_text);

        imageView.setImageResource(pokemons[position].getUrl());
        textView.setText(pokemons[position].getName());

        return convertView;
    }
}

