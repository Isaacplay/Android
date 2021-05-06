package com.example.a300box;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import com.example.a300box.zhanji;

import java.util.ArrayList;

public class show_name extends ListActivity {

    private MyDatabaseHelper dbHelper;
    ArrayList<String> str = new ArrayList<String>();
    @Override
    public  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        dbHelper = new MyDatabaseHelper(this,"namestore.db",null,1);
        SQLiteDatabase db =dbHelper.getWritableDatabase();
                Cursor cursor =db.query("name",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name =cursor.getString(cursor.getColumnIndex("name"));
                        str.add(name);
                        Log.d("zhanji",name);

                    }while(cursor.moveToNext());
                }
                cursor.close();


//        for (int i = 0; i < str.size(); i++) {
//            str[i] = "List_" + i;
//        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);   //使用系统已经实现好的xml文件simple_list_item_1
        setListAdapter(adapter);





    }

    public ArrayList sd(){
        return str;
    }


}
