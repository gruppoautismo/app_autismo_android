package com.example.aut_out;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    private HashMap<String, List<String>> mStringListHashMap;
    private String[] mListHeaderGroup;

    public MyExpandableAdapter(HashMap<String, List<String>> mStringListHashMap) {
        this.mStringListHashMap = mStringListHashMap;
        mListHeaderGroup = mStringListHashMap.keySet().toArray(new String[0]);
    }

    @Override
    public int getGroupCount() {
        return mListHeaderGroup.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mStringListHashMap.get(mListHeaderGroup[groupPosition]).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListHeaderGroup [groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mStringListHashMap.get(mListHeaderGroup[groupPosition]).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition*childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_list_group, parent, false);

        }
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(String.valueOf(getGroup(groupPosition)));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
         if(convertView==null){
             convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_list_item, parent, false);
         }
         TextView textView = convertView.findViewById(R.id.textView);
         textView.setText(String.valueOf(getChild(groupPosition, childPosition)));
         return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
