package com.example.a300box;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_NAME = "create table Name (" +
            "id integer primary key autoincrement,"
            +"name text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext = context;

    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_NAME);
        Toast.makeText(mContext,"CREATE succeeded",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVewsion){

    }




}
