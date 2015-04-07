package com.example.sultan.elitestudent;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;



public class Login extends ActionBarActivity {

    EditText email;
    EditText password;


    Button login;
    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "GfObgmcu05asTCeg9RNv68r7bW1cjK5WrWspcuYI", "A0VoDGfOBMqIe3wodUrxjYX9Gp77uYUIXVTDgcz5");


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                ParseObject identity = new ParseObject("Identity");
                identity.put("email", email.getText().toString());
                identity.put("password", password.getText().toString());
                identity.saveInBackground();

                loginUser();

            }

        });


        signUp = (Button) findViewById(R.id.signUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseObject identity = new ParseObject("Identity");
                identity.put("email", email.getText().toString());
                identity.put("password", password.getText().toString());
                identity.saveInBackground();
                signUpUser();


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void loginUser()
    {
        Intent intent = new Intent(this,MyProfile.class);
        startActivity(intent);
    }

    public void signUpUser()
    {
        Intent intent = new Intent(this,MyProfile.class);
        startActivity(intent);
    }
}
