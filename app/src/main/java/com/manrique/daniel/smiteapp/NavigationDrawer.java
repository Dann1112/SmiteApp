package com.manrique.daniel.smiteapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationDrawer extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        String[] options = getResources().getStringArray(R.array.god_names_array);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.options_drawer_list);

        // Set the adapter for the list view
        drawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, options));
        // Set the list's click listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

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
                    drawerList.setItemChecked(position, true);
                    try {
                        getActionBar().setTitle(getResources().getString(R.string.my_profile));
                    } catch (NullPointerException e) {
                    }

                    drawerLayout.closeDrawer(drawerList);
            }


            // Highlight the selected item, update the title, and close the drawer

        }

    }

}