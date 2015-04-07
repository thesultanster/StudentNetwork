package com.example.sultan.elitestudent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    // constant represents name of the file
    public static final String PREF_FILE_NAME="testpref";
    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;

    ImageButton myProfile;
    ImageButton classes;
    ImageButton email;
    ImageButton chat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserLearnedDrawer=Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));

        // coming back from rotation
        if(savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }

    }

    //indicates whether the user is aware of the drawers existence
    private boolean mUserLearnedDrawer;
    //indicates whether fragment is started first time
    private boolean mFromSavedInstanceState;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        myProfile = (ImageButton) v.findViewById(R.id.profile);
        classes = (ImageButton) v.findViewById(R.id.schedule);
        email = (ImageButton) v.findViewById(R.id.email);
        chat = (ImageButton) v.findViewById(R.id.chat);


        //home.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint


        myProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (getActivity(), MyProfile.class);
                startActivity(intent);
            }
        });

        classes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (getActivity(), ClassesList.class);

                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (getActivity(), Emails.class);

                startActivity(intent);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent
                        (getActivity(), ChatList.class);

                startActivity(intent);
            }
        });


        return v;
    }


    public void setUp( int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar)
    {
        containerView=getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                // IF user have never seen drawer before
                if(!mUserLearnedDrawer)
                {
                    // yes it is open
                    mUserLearnedDrawer=true;
                    savedToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }
                // redraw make activity draw actionbar again
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };

        // IF the user has never seen drawer, and this is very first time frag is starting
        if(!mUserLearnedDrawer && !mFromSavedInstanceState)
        {
            // open the fragment in activity main
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    //Store drawer value in shared preference file. If it is saved then we will not open drawer
    public static void savedToPreferences(Context context, String preferenceName, String preferenceValue){
        // mode private means our app is the only one to modify sharedPreference value
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(preferenceName,preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue){
        // mode private means our app is the only one to modify sharedPreference value
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName,defaultValue);

    }

}