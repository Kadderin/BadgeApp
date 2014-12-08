package com.example.kristine.badgeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AvailableBadgesPg2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_badges_pg2);
        //finding views by their IDs
        Button btn = (Button) findViewById(R.id.btnBackAvailableBdg2);
        //setting on click listenres for the buttons
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBackAvailableBdg2(view);
            }
        });
    }
    //called when the back button is pressed by the user
    public void btnBackAvailableBdg2 (View view) {

        Intent intent = new Intent(this, AvailableBadges.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_available_badges_pg2, menu);
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
