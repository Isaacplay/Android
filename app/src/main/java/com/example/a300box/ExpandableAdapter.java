package com.example.a300box;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * @author Administrator
 * @date &{date}
 */
public class ExpandableAdapter extends BaseExpandableListAdapter{
    private Context context;
    public ExpandableAdapter(Context context){
        this.context = context;
    }


    //设置组视图的显示文字
    private String[] generalsTypes = new String[] { "            射手", "            坦克" };
    //子视图显示文字
    private String[][] generals = new String[][] {
            { "伊卡洛斯" },
            { "夜夜" },

    };
    //子视图图片

    //自己定义一个获得文字信息的方法
    TextView getTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, 240);
        TextView textView = new TextView(
                context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
        textView.setPadding(36, 0, 200, 0);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        return textView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return generals[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LinearLayout ll = new LinearLayout(
                context);
//        ll.setOrientation(0);
        ImageView generallogo = new ImageView(
                context);

        ll.addView(generallogo);
        TextView textView = getTextView();
        textView.setText(getChild(groupPosition, childPosition)
                .toString());
        ll.addView(textView);
        return ll;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return generals[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return generalsTypes[groupPosition];
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return generalsTypes.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LinearLayout ll = new LinearLayout(
                context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ImageView logo = new ImageView(context);
        logo.setPadding(0, 0, 0, 0);
        ll.addView(logo);
        TextView textView = getTextView();
        textView.setTextColor(Color.BLACK);
        textView.setText(getGroup(groupPosition).toString());
        ll.addView(textView);

        ImageView iv  =new ImageView(context);
        iv.setPadding(70, 0, 0, 0);

        ll.addView(iv);

        return ll;
//        LinearLayout ll = (LinearLayout) View.inflate(    context, R.layout.list_item    , null);
//        TextView tv = (TextView)ll.findViewById(R.id.tv);
//        ImageView iv1 = (ImageView)ll.findViewById(R.id.iv1);
//        ImageView iv2 = (ImageView)ll.findViewById(R.id.iv2);
//        tv.setText(getGroup(groupPosition).toString());
//        iv1.setBackgroundResource(logos[groupPosition]);
//        if (isExpanded) {
//
//            iv2.setBackgroundResource(R.drawable.btn1);
//        } else {
//            iv2.setBackgroundResource(R.drawable.btn2);
//        }
//        return null;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

}