package com.example.sultan.elitestudent;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class ChatList extends ActionBarActivity {
    RecyclerView recyclerView;
    private ChatRecyclerAdapter adapter;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView (R.layout.activity_chat_list);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.chat_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ChatRecyclerAdapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }





    public static List<ChatRecyclerInfo> getData(){

        List<ChatRecyclerInfo> data = new ArrayList<>();

        String[] name = { "Sultan Khan" ,
                "Kashy Krishna",
                "Michael Villacorta",
                "Shilpa Chirang",
                "Azhar Khan",
                "Dr. WHo"};

        String[] major = {   "Computer Science" ,
                "Computer Science",
                "Art",
                "Organic Chemistry",
                "Biology",
                "Sociology"};

        String[] message = {   "Hi I like carrots and such things" ,
                "Hi I like carrots and such things",
                "Hi I like carrots and such things",
                "Hi I like carrots and such things",
                "Hi I like carrots and such things",
                "Hi I like carrots and such things"};

        int[] imageId = { R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample,
                R.drawable.sample};

        String[] color = {   "#1abc9c" ,
                "#e74c3c",
                "#2ecc71",
                "#a668ab",
                "#f1c40f",
                "#c0392b"};



        for(int i=0;  (i < name.length); i++)
        {
            ChatRecyclerInfo current = new ChatRecyclerInfo();
            current.name = name[i];
            current.message = message[i];
            current.major = major[i];
            current.imageId = imageId[i];
            current.color = color[i];
            data.add(current);
        }

        return data;
    }
}