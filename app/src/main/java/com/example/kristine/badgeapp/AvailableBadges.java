package com.example.kristine.badgeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import  android.content.Intent;
import android.view.View;
import android.widget.Button;


public class AvailableBadges extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_badges);
        //Intent intent = getIntent();
        Button btnMyBadges = (Button) findViewById(R.id.btnMyBadges);
        Button btnNext = (Button) findViewById(R.id.btnNextAvailableBdg);
        Button btnCommunity = (Button) findViewById(R.id.btnAddCommunity);

        btnMyBadges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGoToMyBadges(view);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNextAvailableBdg(view);
            }
        });

        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddCommunity(view);
            }
        });
        }
    public  void btnGoToMyBadges(View view){
        Intent intent = new Intent(this,YourBadges.class);
        startActivity(intent);
    }
    public void btnAddCommunity (View view){

        Intent intent = new Intent(this, YourBadges.class);
        startActivity(intent);
    }

    public void btnNextAvailableBdg (View view) {

        Intent intent = new Intent(this, AvailableBadgesPg2.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_your_badges, menu);
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
