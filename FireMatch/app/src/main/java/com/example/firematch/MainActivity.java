package com.example.firematch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.content.Context;

import android.util.Log;

import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;

    ArrayList<MessageModel> messageArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageArrayList.add(new MessageModel("Alex Marchall", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Norma Wilson", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Morris Murphy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Kylie Lane", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Ted Stewart", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        setupNavViewListener(navigationView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, //Nav drawer setup
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {

            }
        });



        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
               Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void setupNavViewListener(NavigationView view) {
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.messages:
                        Intent intent = new Intent(getApplicationContext(), MessagesActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.profile:
                        Intent intent1 = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent1);
                        return true;
                }
                return true;
            }
        });
    }




}
