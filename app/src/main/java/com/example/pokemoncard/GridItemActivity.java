package com.example.pokemoncard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



    public class GridItemActivity extends AppCompatActivity {

        ImageView img;
        private TextView txt;
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            System.out.println("Im here  eeeeeeeeeeee");
            setContentView(R.layout.grid_item);
            img = (ImageView) findViewById(R.id.item_img);
            txt = (TextView) findViewById(R.id.item_text);
            Intent intent = getIntent();
            img.setImageResource(intent.getIntExtra("imgPok", 0));
            txt.setText(intent.getStringExtra("textPok"));
        }

}
