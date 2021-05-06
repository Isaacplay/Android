package com.example.a300box;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.example.a300box.show_name;
import com.example.a300box.domain.id;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class zhanji extends Activity {

    private EditText editText;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    private MyDatabaseHelper dbHelper;
    ArrayList<String> str = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhanji);

        skr();
        String[] autostring  = str.toArray(new String[str.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, autostring);
        // AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextView =
                (AutoCompleteTextView)findViewById(R.id.AC);
        autoCompleteTextView.setAdapter(adapter);

        ImageView imageView =(ImageView)findViewById(R.id.anim);
        final AnimationDrawable anim = (AnimationDrawable)imageView.getBackground();
        anim.start();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);
        editText =(EditText)findViewById(R.id.AC) ;
        dbHelper = new MyDatabaseHelper(this,"namestore.db",null,1);
        Button bn = (Button) findViewById(R.id.bn);
        Button bn2 = (Button)findViewById(R.id.bn2);
        boolean isRemember = pref.getBoolean("remember_password",false);

        if(isRemember){
            String account = pref.getString("account","");
            editText.setText(account);
            rememberPass.setChecked(true);
        }

        bn.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {

                String inputText = editText.getText().toString();
                Toast.makeText(zhanji.this,"http://300report.jumpw.com/list.html?name="+editText.getText().toString(),Toast.LENGTH_LONG).show();
                editor = pref.edit();
                if(rememberPass.isChecked()){
                    editor.putBoolean("remember_password",true);
                    editor.putString("account",inputText);
                }else{
                    editor.clear();
                }
                editor.apply();
                SQLiteDatabase db =dbHelper.getWritableDatabase();
                ContentValues values =new ContentValues();

                values.put("name",inputText);
                db.insert("name",null,values);
                values.clear();

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("http://300report.jumpw.com/list.html?name="+editText.getText().toString()));
                startActivity(intent);


            }
        });
        bn2.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent =new Intent(zhanji.this,show_name.class);
                startActivity(intent);
            }
        });
    }

    public void skr(){

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
    }



}
