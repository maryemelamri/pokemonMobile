package com.example.pokemoncard;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listpokemonAdapter  extends RecyclerView.Adapter<listpokemonAdapter.ViewHolder> {
    ArrayList<Pokemon> listPk ;

    public listpokemonAdapter() {
        listPk = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p = listPk.get(position);
       holder.item_name.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return listPk.size();
    }

    public void dragdata(ArrayList<Pokemon> list) {

        listPk.addAll(list);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView grid_imag;
        private TextView item_name;

        public ViewHolder(View itemView){
            super(itemView);

            grid_imag = (ImageView) itemView.findViewById(R.id.grid_image);
            item_name = (TextView) itemView.findViewById(R.id.grid_text);

}

}



}
