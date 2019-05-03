package com.example.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase eventsDB = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

//            eventsDB.execSQL("CREATE TABLE IF NOT EXISTS newUsers(name VARCHAR, age INTERGER(3), id INTEGER PRIMARY KEY)");

//            eventsDB.execSQL("INSERT INTO users(name, age) VALUES('Kirsten', 21 )");
//            eventsDB.execSQL("INSERT INTO users(event, year) VALUES('Ralphie', 1)");

//            eventsDB.execSQL("DELETE FROM users WHERE name = 'Kirsten' LIMIT 1");
            eventsDB.execSQL("DELETE FROM newUsers WHERE id = 1");

            Cursor c = eventsDB.rawQuery("SELECT * FROM users WHERE name Like '%o%' LIMIT 1", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while (c!=null){
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UsersResults - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }

        } catch (Exception e){
            e.printStackTrace();


        }

//        try {
//            SQLiteDatabase eventsDB = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
//
//            eventsDB.execSQL("CREATE TABLE IF NOT EXISTS events(event VARCHAR, year INT(4))");
//            eventsDB.execSQL("INSERT INTO events(event, year) VALUES('End of WW2', 1945)");
//            eventsDB.execSQL("INSERT INTO events(event, year) VALUES('Wham split up', 1986)");
//
//            Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);
//
//            int eventIndex = c.getColumnIndex("event");
//            int yearIndex = c.getColumnIndex("year");
//
//            c.moveToFirst();
//
//            while (c!=null){
//                Log.i("Results - event", c.getString(eventIndex));
//                Log.i("Results - year", Integer.toString(c.getInt(yearIndex)));
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//
//
//        }

//        try {
//
//            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
//
//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
//
//            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");
//
//            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Tommy', 4)");
//
//            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null)
//
//            int nameIndex = c.getColumnIndex("name");
//            int ageIndex = c.getColumnIndex("age");
//
//            c.moveToFirst();
//            while (c != null){
//
//                Log.i("name", c.getString(nameIndex));
//                Log.i("age", Integer.toString(c.getInt(ageIndex)));
//
//                c.moveToFirst();
//
//            }
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
