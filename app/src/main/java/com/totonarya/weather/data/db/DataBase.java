package com.totonarya.weather.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.totonarya.weather.data.pojo.searchCity.SearchCities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(@Nullable Context context) {
        super(context, cities_db.DATABASE_NAME, null, cities_db.DATABASE_VERSION);
        this.context = context;
        isDatabase();
    }

    private void isDatabase() {

        File check = new File(cities_db.PACKAGE);
        if (check.exists()) {

        } else {
            check.mkdir();
        }
        check = context.getDatabasePath(cities_db.DATABASE_NAME);


        if (check.exists()) {

        } else {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(cities_db.DATABASE_SOURCE);

        String outFileName = cities_db.PACKAGE + cities_db.DATABASE_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<SearchCities> getAllCities() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<SearchCities> data = new ArrayList<>();
        String query = "Select * From worldcities";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                SearchCities searchCities = new SearchCities();
                searchCities.setId(cursor.getColumnIndex(cities_db.DATABASE_ID));
                searchCities.setCityName(cursor.getString(cursor.getColumnIndex(cities_db.DATABASE_CITYNAME)));
                searchCities.setCountry(cursor.getString(cursor.getColumnIndex(cities_db.DATABASE_COUNTRY)));
                searchCities.setFav(cursor.getInt(cursor.getColumnIndex(cities_db.DATABASE_FAV)));
                searchCities.setIso2(cursor.getString(cursor.getColumnIndex(cities_db.DATABASE_ISO2)));
                searchCities.setIso3(cursor.getString(cursor.getColumnIndex(cities_db.DATABASE_ISO3)));
                data.add(searchCities);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return data;
    }
}
