package com.example.a300box.heros;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.view.WindowManager;
import android.os.Bundle;
import com.example.a300box.R;

public class yeye extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.yeye);
    }


}
