package com.example.seniortest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seniortest.dao.FavoriteDB;
import com.example.seniortest.model.BreakingBadCharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapater extends ArrayAdapter<BreakingBadCharacter> {


    final FavoriteDB favoriteDB;

    public CharacterAdapater(Context context, int resource, List<BreakingBadCharacter> character ){
        super(context,resource,character);
        favoriteDB = new FavoriteDB(context);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        Log.d("info2","getview de adapter");
        BreakingBadCharacter character =getItem(position);
        if (converView == null){
            converView = LayoutInflater.from(getContext()).inflate(R.layout.list_cell,parent,false);
        }
        Log.d("info2","converview");
        TextView name = (TextView) converView.findViewById(R.id.name);
        TextView surName = (TextView) converView.findViewById(R.id.surName);
        ImageView image = (ImageView) converView.findViewById(R.id.imagen1);

        Log.d("info2","set adapter classes");
        ImageButton imageButton = (ImageButton) converView.findViewById(R.id.imageButtonDetail);
        Log.d("info2","set databeses classes");

        name.setText(character.getName());
        surName.setText(character.getNickname());
        Log.d("info2","gave adapter values");
        Picasso.get().load(character.getImg()).into(image);
        Log.d("info2","if  favorites");
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



        return converView;
    }


    private boolean isCharacter(int char_id){
        try{
            if(char_id != 0 ){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
}
