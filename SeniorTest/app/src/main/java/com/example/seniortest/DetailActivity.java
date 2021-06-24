package com.example.seniortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
        int stringId = previousIntent.getIntExtra("char_id",0);
        character = MainActivity.characters.get(stringId -1);
    }
    private void setValues(){
        TextView name = (TextView) findViewById(R.id.detail_name);
        TextView occupation = (TextView) findViewById(R.id.occupation_detail);
        TextView Status = (TextView) findViewById(R.id.status_detail);
        TextView portrayed = (TextView) findViewById(R.id.portrayed_detail);
        ImageView image = (ImageView) findViewById(R.id.detail_image);

        name.setText(character.getName());
        occupation.setText(character.getOccupation().toString());
        Status.setText(character.getStatus());
        portrayed.setText(character.getPortrayed());
        Picasso.get().load(character.getImg()).into(image);

    }

    /*private String setListAsString(List<String> list){
        String listAsString = list.get(0)

        for(String s: list){

        }
    }*/
}