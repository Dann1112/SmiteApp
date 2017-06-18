package com.manrique.daniel.smiteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Date;

public class BuildPreviewAdapter extends BaseAdapter {
    private Context context;
    private String godName;
    private String username;
    private Date date;
    private String[] items;

    public BuildPreviewAdapter(Context c, String godName) {
        context = c;
        this.godName = godName;
    }

    public int getCount() {
        return 10;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View buildPreview;
        username = "Dann1112";
        date = new Date(System.currentTimeMillis());

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {
            buildPreview = inflater.inflate(R.layout.build_preview, parent, false);
        } else
            buildPreview = convertView;

        return buildPreview;

    }


}