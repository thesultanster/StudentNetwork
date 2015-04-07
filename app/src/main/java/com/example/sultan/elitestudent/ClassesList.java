package com.example.sultan.elitestudent;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ClassesList extends ActionBarActivity {

    RecyclerView recyclerView;
    private ClassesRecyclerAdapter adapter;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView (R.layout.activity_classes_list);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.classesDrawerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ClassesRecyclerAdapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }





    public static List<ClassesRecyclerInfo> getData(){

        List<ClassesRecyclerInfo> data = new ArrayList<>();

        String[] titles = { "CS166: Database Management Lecture" ,
                            "CS166: Database Management Laboratory",
                            "CS164: Networking Lecture",
                            "CS164: Networking Laboratory",
                            "Physics 40C Lecture",
                            "Physics 40C Laboratory"};

        String[] location = {   "UV THE8" ,
                                "Chung 133",
                                "BRNS A125",
                                "Chung 133",
                                "PHY 2000",
                                "PHY 2029"};

        String[] timeStart = {   "11:10am" ,
                "6:10pm",
                "3:40pm",
                "11:10am",
                "9:40am",
                "3:40pm"};

        String[] timeEnd = {   "12:30pm" ,
                "9:00pm",
                "5:00pm",
                "2:00pm",
                "11:00am",
                "6:30pm"};

        String[] days = { "MW" ,
                "H",
                "TH",
                "F",
                "TH",
                "W"};

        for(int i=0; (i < timeStart.length) && (i < timeEnd.length) && (i < titles.length) && (i < location.length); i++)
        {
            ClassesRecyclerInfo current = new ClassesRecyclerInfo();
            current.title = titles[i];
            current.location = location[i];
            current.timeStart = timeStart[i];
            current.timeEnd = timeEnd[i];
            current.days = days[i];

            data.add(current);
        }

        return data;
    }
}