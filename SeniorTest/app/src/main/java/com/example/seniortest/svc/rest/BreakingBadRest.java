package com.example.seniortest.svc.rest;


import com.example.seniortest.model.BreakingBadCharacter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BreakingBadRest {


    /*@GET("/characters")
    Call<List<Character>> getCharacter(@Query("limit") String limit, @Query("offset") String offset);*/

    @GET("characters")
    Call<List<BreakingBadCharacter>> getCharacter();
}
