package com.manrique.daniel.smiteapp;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashMap;

public class MainGodSelection extends Fragment {

    GridView godsGrid;
    String[] names;
    HashMap<String, Integer> godsInfo = new HashMap<>();

    private Integer[] avatars = {
            R.drawable.agni, R.drawable.ah_muzen_cab,
            R.drawable.ah_puch, R.drawable.amaterasu,
            R.drawable.anhur, R.drawable.anubis,
            R.drawable.ao_kuang, R.drawable.erlang_shen,
            R.drawable.the_morrigan, R.drawable.thor,
            R.drawable.rama, R.drawable.aphrodite,
            R.drawable.apollo, R.drawable.arachne,
            R.drawable.athena, R.drawable.awilix,
            R.drawable.bacchus, R.drawable.bakasura,
            R.drawable.bastet, R.drawable.bellona,
            R.drawable.cabrakan, R.drawable.camazotz,
            R.drawable.cernunnos, R.drawable.chaac

    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        godsGrid = (GridView) getView().findViewById(R.id.gods_grid);
        names = this.getResources().getStringArray(R.array.god_names_array);

        TextView title = (TextView) getView().findViewById(R.id.select_god_lbl);
        title.setFocusable(true);
        title.setFocusableInTouchMode(true);
        title.requestFocus();

        for (int i = 0; i < names.length; i++)
            godsInfo.put(names[i], avatars[i]);

        godsGrid.setAdapter(new godsAdapter(godsInfo, getActivity()));

        EditText godSearch = (EditText) getView().findViewById(R.id.gods_name_txt);
        godSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                godsInfo.clear();

                //Si lo que hay en la caja, es por lo menos un caracter...
                if (s.length() > 0) {

                    //Por cada nombre de Dios...
                    for (int i = 0; i < names.length; i++) {

                        //Compara el numero de caracteres en la caja con el numero de caracteres
                        //en el nombre de los dioses
                        if (s.toString().equals(names[i].substring(0, s.length()))) {
                            godsInfo.put(names[i], avatars[i]);
                        }
                    }


                } else {
                    for (int i = 0; i < names.length; i++)
                        godsInfo.put(names[i], avatars[i]);
                }

                godsGrid.setAdapter(new godsAdapter(godsInfo, getActivity()));
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main_menu, container, false);
    }


}
