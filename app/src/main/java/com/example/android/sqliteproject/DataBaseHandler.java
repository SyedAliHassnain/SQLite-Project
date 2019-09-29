package com.example.android.sqliteproject;

import android.app.ActionBar;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DataBaseHandler extends SQLiteOpenHelper {
    public static final String Database_Name="Students";
    public static final String Table_Name="Student_Table";
    public static final String col_1="ID";
    public static final String col_2="Name";
    public static final String col_3="SurName";
    public static final String col_4="Marks";

    public DataBaseHandler (Context context){
        super(context,Database_Name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
   db.execSQL("create table "+ Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,SURNAME TEXT,MARKS INTERGER);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public boolean insertData(String Name, String SurName, String Marks) {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_2,Name);
        contentValues.put(col_3,SurName);
        contentValues.put(col_4,Marks);
        long result;
        result = db.insert(Table_Name,null,contentValues);
        if(result==-1)
            return false;
        else
        return true;
    }

}
