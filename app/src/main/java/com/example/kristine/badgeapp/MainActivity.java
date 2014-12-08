package com.example.kristine.badgeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText username;
    String stringUsername;
    EditText password;
    String stringPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up the Username
        username=(EditText) findViewById(R.id.editTxtUserName);
        stringUsername = username.getText().toString();
        //setting up the Password
        password=(EditText) findViewById(R.id.editTxtPassword);
        stringPassword = password.getText().toString();

        //finding the buttons by their ID
        final Button btnMyBadges = (Button) findViewById(R.id.btnYourBadges);
        final Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        Button btn = (Button) findViewById(R.id.btnAvailableBdg);

        //onClickListeners for the buttons
        btnMyBadges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnYourBadges(view);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAvailableBadges(view);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Username validation is incorrect
                if(username.length()>15 || username.length()<=4){
                    username.setError("Please enter a username between 5-15 characters");
                }
                //When username is accepted the name is set to the Badges button and capitalized properly
                else if(username.length()>=5 || username.length()<=15){
                    stringUsername=username.getText().toString();
                    String str = stringUsername;
                    String cap = str.substring(0,1).toUpperCase()+str.substring(1);
                    ((Button) findViewById(R.id.btnYourBadges)).setText(cap+"'s Badges");
                }
                //Password validation incorrect
                if(password.length()<=4){
                    password.setError("Please enter a password between 5-15 characters");
                }
                else if(password.length()>=5 || password.length()<=15){
                    stringPassword=password.getText().toString();
                //When password is accepted the login disappears
                    findViewById(R.id.txtViewUserName).setVisibility(view.GONE);
                    findViewById(R.id.txtViewPassword).setVisibility(view.GONE);
                    findViewById(R.id.editTxtUserName).setVisibility(view.GONE);
                    findViewById(R.id.editTxtPassword).setVisibility(view.GONE);
                    findViewById(R.id.btnSubmit).setVisibility(view.GONE);

                    findViewById(R.id.btnYourBadges).setEnabled(true);
                    findViewById(R.id.btnAvailableBdg).setEnabled(true);
                }
            }
        });
    }
    //called when a user clicks the Your Badges button
    public  void btnYourBadges (View view){
        Intent intent = new Intent(this,YourBadges.class);
        startActivity(intent);
    }

    /** Called when the user clicks the availableBdg button */
    public void btnAvailableBadges (View view) {

        Intent intent = new Intent(this, AvailableBadges.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
