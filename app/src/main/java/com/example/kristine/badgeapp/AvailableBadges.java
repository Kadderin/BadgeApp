package com.example.kristine.badgeapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AvailableBadges extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_badges);
        //Intent intent = getIntent();
        Button btnMyBdg = (Button) findViewById(R.id.btnMyBadges_Avail);
        Button btnNext = (Button) findViewById(R.id.btnNextAvailableBdg);
        Button btnCommunity = (Button) findViewById(R.id.btnAddCommunity);
        Button btnAcademic = (Button) findViewById(R.id.btnAddAcademicAward);

        btnMyBdg.setOnClickListener(new View.OnClickListener() {
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


    public void btnAddCommunity (View view){
        Intent intent = new Intent(this, YourBadges.class);
        intent.putExtra("state",0);
        startActivity(intent);
    }
    public void btnGoToMyBadges(View view){
        Intent intentMyBadges = new Intent (this, YourBadges.class);
        startActivity(intentMyBadges);
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
