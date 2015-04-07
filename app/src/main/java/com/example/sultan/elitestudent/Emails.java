package com.example.sultan.elitestudent;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Emails extends ActionBarActivity {
    RecyclerView recyclerView;
    private EmailRecyclerAdapter adapter;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView (R.layout.activity_emails);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.email_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EmailRecyclerAdapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }





    public static List<EmailRecyclerInfo> getData(){

        List<EmailRecyclerInfo> data = new ArrayList<>();

        String[] titles = { "UCR Student Recreation Center" ,
                "Society of Women Engineers",
                "Jun Wang",
                "ASUCR",
                "UCR Campus Store",
                "Kathleen DeAtley"};

        String[] subject = {   "Group Fitness Free Day April 9" ,
                "Upcoming Announcements",
                "The Spring Job Fair",
                "Join a Movement to Create a Culture of Respect ",
                "Urban Festival BOGO 50% OFF",
                "UCR Dance: Performance artists"};

        String[] body = {   "It’s time to change up your routine with an energetic and motivating group! " ,
                "The Society of Women Engineers has a few upcoming announcements to share with you!",
                "Networing is so important, use this chance to get networking experience and make valuable connections! ",
                "Join a movement to create a culture of respect and consent at UCR with your involvement on this initiative! ",
                "",
                "Performance artists Gerard & Kelly will engage in a three-day residency in the Department of Dance at UCR, April 7-9, 2015."};



        for(int i=0;  (i < titles.length) && (i < subject.length); i++)
        {
            EmailRecyclerInfo current = new EmailRecyclerInfo();
            current.title = titles[i];
            current.subject = subject[i];
            current.body = body[i];


            data.add(current);
        }

        return data;
    }
}