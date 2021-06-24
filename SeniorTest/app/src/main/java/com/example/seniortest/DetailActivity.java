package com.example.seniortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seniortest.dao.FavoriteDB;
import com.example.seniortest.model.BreakingBadCharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    BreakingBadCharacter character;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSelectedCharacter();
        setValues();

    }

    private void getSelectedCharacter(){
        Intent previousIntent = getIntent();
        int stringId = previousIntent.getIntExtra("positionId",0);
        character = MainActivity.characters.get(stringId -1);
    }
    private void setValues(){
        final FavoriteDB favoriteDB = new FavoriteDB(getApplicationContext());
        TextView name = (TextView) findViewById(R.id.detail_name);
        TextView occupation = (TextView) findViewById(R.id.occupation_detail);
        TextView Status = (TextView) findViewById(R.id.status_detail);
        TextView portrayed = (TextView) findViewById(R.id.portrayed_detail);
        ImageView image = (ImageView) findViewById(R.id.detail_image);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButtonDetail);

        name.setText(character.getName());
        occupation.setText(character.getOccupation().toString());
        Status.setText(character.getStatus());
        portrayed.setText(character.getPortrayed());
        Picasso.get().load(character.getImg()).into(image);
        if(favoriteDB.isFavorite(Integer.toString(character.getChar_id()))){
            imageButton.setImageResource(R.drawable.ic_baseline_favorite_24);
        }else{
            imageButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }
        Log.d("info2","nailed it");

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("info2","on click listener");
                if(favoriteDB.isFavorite(Integer.toString(character.getChar_id()))){
                    favoriteDB.removeFromFavorite(Integer.toString(character.getChar_id()));
                    imageButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }else{
                    favoriteDB.addToFavorite(Integer.toString(character.getChar_id()));
                    imageButton.setImageResource(R.drawable.ic_baseline_favorite_24);
                }
                Log.d("info2","did querys");
            }
        } );

    }


    /*private String setListAsString(List<String> list){
        String listAsString = list.get(0)

        for(String s: list){

        }
    }*/
}