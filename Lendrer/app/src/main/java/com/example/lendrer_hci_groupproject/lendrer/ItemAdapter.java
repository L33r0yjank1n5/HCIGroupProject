package com.example.lendrer_hci_groupproject.lendrer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Adam-Laptop on 12/3/2017.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] id;
    String[] names;
    String[] startDates;
    String[] dueDates;
    String[] personNames;

    public ItemAdapter(Context c, String[] n, String[] sDates, String[] dDates, String[] pNames){
        names = n;
        startDates = sDates;
        dueDates = dDates;
        personNames = pNames;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.list_view_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView startDateTextView = (TextView) v.findViewById(R.id.startDateTextView);
        TextView dueDateTextView = (TextView) v.findViewById(R.id.dueDateTextView);
        TextView personNameTextView = (TextView) v.findViewById(R.id.personNameTextView);

        String name = names[i];
        String sDate = startDates[i];
        String dDate = dueDates[i];
        String pName = personNames[i];

        nameTextView.setText(name);
        startDateTextView.setText(sDate);
        dueDateTextView.setText(dDate);
        personNameTextView.setText(pName);

        return v;
    }
}
