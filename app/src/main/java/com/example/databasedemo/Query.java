package com.example.databasedemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Query {



    public static final String DataBaseName="student.db";
    public static final String TableName="student_details";
    public static final int DataBaseVersion=3;

    public static final String ID="Id";
    public static final String NAME="Name";
    public static final String ROLL="Roll";
    public static final String ADDRESS="Address";
    public static final String SHIFT="Shift";
    public static final String DEPARTMENT="Department";
    public static final String MOBILE="Mobile";
    public static final String SEMESTER="Semester";


    public static final String CREATE_TABLE=" CREATE TABLE "+TableName+"("
            +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +NAME+" TEXT, "
            +ROLL+" TEXT, "
            +ADDRESS+" TEXT, "
            +SHIFT+" TEXT, "
            +DEPARTMENT+" TEXT, "
            +MOBILE+" TEXT, "
            +SEMESTER+" TEXT "
            +")";

    public static final String DROP_TABLE= " DROP TABLE IF EXISTS "+TableName;


}
