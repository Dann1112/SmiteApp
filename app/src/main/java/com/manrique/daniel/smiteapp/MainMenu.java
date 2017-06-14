package com.manrique.daniel.smiteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import java.util.HashMap;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView godsGrid;
    String[] names;
    HashMap<String, Integer> godsInfo;
    View layoutToDisplay;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        godsGrid = (GridView) findViewById(R.id.gods_grid);


        names = this.getResources().getStringArray(R.array.god_names_array);

        godsInfo = new HashMap<>();

        for (int i = 0; i < names.length; i++)
            godsInfo.put(names[i], avatars[i]);

        godsGrid.setAdapter(new godsAdapter(godsInfo, this));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        EditText godSearch = (EditText) findViewById(R.id.gods_name_txt);

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

                godsGrid.setAdapter(new godsAdapter(godsInfo, MainMenu.this));
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_profile) {
            Intent goToProfile = new Intent().setClass(MainMenu.this, UserProfile.class);

            startActivity(goToProfile);

            // Handle the camera action
        } else if (id == R.id.nav_my_profile) {
            Intent goToCreation = new Intent().setClass(MainMenu.this, CreateNewBuild1.class);
            getActionBar().setTitle(getResources().getString(R.string.my_profile));

        } else if (id == R.id.nav_create_build) {
            Intent goToProfile = new Intent().setClass(MainMenu.this, UserProfile.class);

            startActivity(goToProfile);

        } else if (id == R.id.nav_counters) {
            Intent goToProfile = new Intent().setClass(MainMenu.this, UserProfile.class);

            startActivity(goToProfile);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
