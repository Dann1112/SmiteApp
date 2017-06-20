package com.manrique.daniel.smiteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Dann on 19/06/2017.
 */

public class itemsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> itemsImages = new ArrayList<>();
    private ArrayList<String> itemsNames = new ArrayList<>();

    public itemsAdapter(HashMap<String, Integer> godsInfo, Context c) {

        context = c;

        SortedSet<String> keys = new TreeSet<>(godsInfo.keySet());

        for (String key : keys) {
            Integer avatarId = godsInfo.get(key);
            itemsImages.add(avatarId);
            itemsNames.add(key);
        }
    }

    public int getCount() {
        return itemsImages.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View itemItem;
        final TextView itemName;
        ImageView itemImage;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            itemItem = inflater.inflate(R.layout.item_gridview_item, parent, false);


        } else {
            itemItem = convertView;
        }

        itemName = (TextView) itemItem.findViewById(R.id.god_name);
        itemImage = (ImageView) itemItem.findViewById(R.id.god_avatar);
        itemImage.setImageResource(itemsImages.get(position));
        itemName.setText(itemsNames.get(position));
        itemItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrir builds de este dios

            }
        });

        return itemItem;

    }


}