package com.example.alice.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AliceP on 25.04.2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Films.db";
    public static final String TABLE_NAME="FilmList";
    public static final String ID="ID";
    public static final String CHECK="Check";
    public static final String NAME="Name";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY, "+CHECK+"TEXT,"+NAME +"TEXT"+")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

   public boolean insertData(ToDoItems item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       contentValues.put(CHECK,item.getChecked());
       contentValues.put(NAME, item.getName());
        Long result =db.insert(TABLE_NAME, null, contentValues);
        db.close();
       if (result ==-1) {
           return false;
       }
       else {
           return true;
       }
    }

    public Cursor getContents()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM"+TABLE_NAME,null);
        return data;
    }

}
