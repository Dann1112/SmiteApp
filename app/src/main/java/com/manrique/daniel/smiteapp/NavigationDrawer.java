package com.manrique.daniel.smiteapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NavigationDrawer extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = new MainGodSelection();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        //drawerList.setItemChecked(0, true);

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        private static final int MY_PROFILE = 0;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

        /**
         * Swaps fragments in the main content view
         */
        private void selectItem(int position) {
            Fragment fragment;

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getFragmentManager();

            switch (position) {
                case MY_PROFILE:
                    fragment = new MyProfileFragment();

                    fragmentManager.beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();
                    //drawerList.setItemChecked(position, true);
                    try {
                        getActionBar().setTitle(getResources().getString(R.string.my_profile));
                    } catch (NullPointerException e) {
                    }

            }


            // Highlight the selected item, update the title, and close the drawer

        }

    }

}