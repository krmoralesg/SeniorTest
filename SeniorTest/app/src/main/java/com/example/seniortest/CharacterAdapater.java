package com.example.seniortest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seniortest.model.BreakingBadCharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapater extends ArrayAdapter<BreakingBadCharacter> {

    public CharacterAdapater(Context context, int resource, List<BreakingBadCharacter> character ){
        super(context,resource,character);
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

        name.setText(character.getName());
        surName.setText(character.getNickname());
        Log.d("info2","gave adapter values");
        Picasso.get().load(character.getImg()).into(image);

        return converView;
    }
}
