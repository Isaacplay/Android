package com.example.a300box;
import android.app.Activity;
import android.content.ComponentName;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.content.Intent;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.a300box.heros.*;

public class hero extends Activity{
    ExpandableAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);


        adapter = new ExpandableAdapter(this);
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        expandableListView.setAdapter(adapter);
//        expandableListView.expandGroup(1);//设置第一组张开
//        expandableListView.setGroupIndicator(null);//除去自带的箭头


        //设置item点击的监听器
        expandableListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

//                Toast.makeText(
//                        ExpandableList.this,
//                        "你点击了" + adapter.getChild(groupPosition, childPosition),
//                        Toast.LENGTH_SHORT).show();
                Intent intent=new Intent("com.example.a300box.ACTION_START");
                intent.addCategory("com.example.a300box."+adapter.getChild(groupPosition, childPosition));
                startActivity(intent);



                return true;
            }



        });
    }


}
