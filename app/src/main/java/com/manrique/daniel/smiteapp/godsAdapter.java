package com.manrique.daniel.smiteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class godsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> godsAvatars = new ArrayList<>();
    private ArrayList<String> godsNames = new ArrayList<>();

    public godsAdapter(HashMap<String, Integer> godsInfo, Context c) {
        context = c;

        SortedSet<String> keys = new TreeSet<>(godsInfo.keySet());
        int i = 0;
        for (String key : keys) {
            Integer avatarId = godsInfo.get(key);
            godsAvatars.add(avatarId);
            godsNames.add(key);
            i++;
        }
    }

    public int getCount() {
        return godsAvatars.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View godItem;
        final TextView godsName;
        ImageView godsAvatar;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            godItem = inflater.inflate(R.layout.god_gridview_item, parent, false);


        } else {
            godItem = convertView;
        }

        godsName = (TextView) godItem.findViewById(R.id.god_name);
        godsAvatar = (ImageView) godItem.findViewById(R.id.god_avatar);
        godsAvatar.setImageResource(godsAvatars.get(position));
        godsName.setText(godsNames.get(position));
        godItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrir builds de este dios
                Toast.makeText(context, godsNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        return godItem;

    }


}