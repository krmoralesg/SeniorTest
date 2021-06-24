package com.example.seniortest.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//public class FavoriteDB {
public class FavoriteDB extends SQLiteOpenHelper {

    private static final String NOMBRE_DB = "database.bd";
    private static final int VERSION_DB = 1;
    private static final String CREATE_TABLE= "CREATE TABLE FAVORITE_CHARACTER(CODIGO TEXT PRIMARY KEY, CHARACTER_ID TEXT)";

    public FavoriteDB(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /*@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int j){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE);

    }*/

    public void addToFavorite(String char_id){
        SQLiteDatabase database = getWritableDatabase();
        String query = String.format("INSERT INTO FAVORITE_CHARACTER(CODIGO) VALUES('%s');",char_id);
        if(database != null){
            database.execSQL(query);
            database.close();
        }

    }

    public void removeFromFavorite(String char_id){
        SQLiteDatabase database = getWritableDatabase();
        String query = String.format("DELETE FROM FAVORITE_CHARACTER WHERE CODIGO = ('%s');",char_id);
        if(database != null){
            database.execSQL(query);
            database.close();
        }
    }
    public boolean isFavorite(String char_id) {
        SQLiteDatabase database = getReadableDatabase();
        String query = String.format("SELECT * FROM FAVORITE_CHARACTER WHERE CODIGO = ('%s');", char_id);
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }

    }
}
