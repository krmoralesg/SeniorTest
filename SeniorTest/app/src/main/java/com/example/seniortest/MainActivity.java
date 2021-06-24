package com.example.seniortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.seniortest.dao.FavoriteDB;
import com.example.seniortest.model.BreakingBadCharacter;
import com.example.seniortest.svc.rest.BreakingBadRest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    ListView list;
    public static ArrayList<BreakingBadCharacter> characters = new ArrayList<BreakingBadCharacter>();


    CharacterAdapater arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView simpleImageView=(ImageView) findViewById(R.id.imageView2);
        //simpleImageView.setImageResource(R.drawable.);//set the source in java class

        /*titles.add("aqui hay uno");
        titles.add("aqui hay otro");*/
        Log.d("info2","trying to characters");
        getBreakingBadCharacters();

        list = (ListView) findViewById(R.id.list);
        arrayAdapter = new CharacterAdapater(getApplicationContext(),0,characters);
        Log.d("info2","arrayadapter done");



        list.setAdapter(arrayAdapter);
        setUpOnClickListener();

        //
    }


    private void getBreakingBadCharacters() {
        try{
            final FavoriteDB favoriteDB = new FavoriteDB(getApplicationContext());
            Log.d("info2","create gson");
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Log.d("info2","into get characters");
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.breakingbadapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            Log.d("info2","build retrofit ");
            BreakingBadRest postService = retrofit.create(BreakingBadRest.class);
            Log.d("info2","build postService");
            Call<List<BreakingBadCharacter>> call = postService.getCharacter();
            Log.d("info2","build call ");

            call.enqueue(new Callback<List<BreakingBadCharacter>>() {
                @Override
                public void onResponse(Call<List<BreakingBadCharacter>> call, Response<List<BreakingBadCharacter>> response) {
                    Log.d("info2","into enqueue " + gson.toJson(response.body()));
                    int counter =  0;
                    for(BreakingBadCharacter character : response.body()) {
                        if (favoriteDB.isFavorite(Integer.toString(character.getChar_id()))){
                            counter ++;
                            character.setPositionId(counter);
                            characters.add(character);


                        }
                    }
                    for(BreakingBadCharacter character : response.body()) {
                        if (!favoriteDB.isFavorite(Integer.toString(character.getChar_id()))){
                            counter ++;
                            character.setPositionId(counter);
                            characters.add(character);
                        }
                    }
                    arrayAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<List<BreakingBadCharacter>> call, Throwable t) {
                    Log.d("info2","failure");
                }
            });
        }catch(Exception e){
            Log.e("info2",e.getMessage());
        }




    }

    private void setUpOnClickListener(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                BreakingBadCharacter character = (BreakingBadCharacter) (list.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(),DetailActivity.class);
                showDetail.putExtra("positionId",character.getPositionId());
                startActivity(showDetail);

           }
        });


    }
}