package com.manrique.daniel.smiteapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.HashMap;

/**
 * Created by Dann on 19/06/2017.
 */

public class BuildBuilderFragment extends Fragment {

    GridView itemsGrid;
    String[] names;
    HashMap<String, Integer> itemInfo = new HashMap<>();

    private Integer[] images = {
            R.drawable.acorn_of_swiftness, R.drawable.acorn_of_yggdrasil,
            R.drawable.adventurers_blade, R.drawable.aegis_amulet,
            R.drawable.ancient_blade, R.drawable.ancile,
            R.drawable.armored_cloak, R.drawable.asi,
            R.drawable.balanced_blade, R.drawable.bancrofts_talon,
            R.drawable.belt_of_frenzy, R.drawable.blackthorn_hammer,
            R.drawable.blink_rune, R.drawable.bloodforge,
            R.drawable.bluestone_pendant, R.drawable.book_of_the_dead,
            R.drawable.book_of_thoth, R.drawable.boots
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.build_builder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        Spinner damageTypeSpn = (Spinner) getActivity().findViewById(R.id.damage_type_spinner);
        Spinner typeSpn = (Spinner) getActivity().findViewById(R.id.type_spinner);
        names = this.getResources().getStringArray(R.array.item_names);

        damageTypeSpn.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.damage_type)));

        typeSpn.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.type)));

        itemsGrid = (GridView) getView().findViewById(R.id.items_grid);

        for (int i = 0; i < names.length; i++)
            itemInfo.put(names[i], images[i]);

        itemsGrid.setAdapter(new godsAdapter(itemInfo, getActivity()));


    }
}
