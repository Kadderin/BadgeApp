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


        username=(EditText) findViewById(R.id.editTxtUserName);
        stringUsername = username.getText().toString();

        password=(EditText) findViewById(R.id.editTxtPassword);
        stringPassword = password.getText().toString();

        final Button btnMyBadges = (Button) findViewById(R.id.btnYourBadges);
        final Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        ;
        Button btn = (Button) findViewById(R.id.btnAvailableBdg);
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
                if(username.length()>15 || username.length()<=4){
                    username.setError("Please enter a username between 5-15 characters");
                }
                else if(username.length()>=5 || username.length()<=15){
                    stringUsername=username.getText().toString();
                    ((Button) findViewById(R.id.btnYourBadges)).setText(stringUsername+"'s Badges");
                }

                if(password.length()<=4){
                    password.setError("Please enter a password between 5-15 characters");
                }
                else if(password.length()>=5 || password.length()<=15){
                    stringPassword=password.getText().toString();

                    findViewById(R.id.txtViewUserName).setVisibility(view.GONE);
                    findViewById(R.id.txtViewPassword).setVisibility(view.GONE);
                    findViewById(R.id.editTxtUserName).setVisibility(view.GONE);
                    findViewById(R.id.editTxtPassword).setVisibility(view.GONE);
                    findViewById(R.id.btnSubmit).setVisibility(view.GONE);

                    

                }

            }
        });
    }

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
