package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    Context context;

    public DataBaseHelper(@Nullable Context context) {
        super(context, Query.DataBaseName, null, Query.DataBaseVersion);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(Query.CREATE_TABLE);
            Toast.makeText(context, "ON create is called ", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context,"Exception=",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Long insertData(String name,String roll,String address,String shift,String department,String mobile){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Query.NAME,name);
        contentValues.put(Query.ROLL,roll);
        contentValues.put(Query.ADDRESS,address);
        contentValues.put(Query.SHIFT,shift);
        contentValues.put(Query.DEPARTMENT,department);
        contentValues.put(Query.MOBILE,mobile);

        Long rowID=sqLiteDatabase.insert(Query.TableName,null,contentValues);
        return rowID;

    }
}
