package com.example.kristine.badgeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class YourBadges2 extends Activity {
int[] statusArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_badges2);

        Intent intent = getIntent();
        statusArray = intent.getIntArrayExtra("status_Array");

        ImageView image =(ImageView) findViewById(R.id.imgSociety2);
        TextView name =(TextView) findViewById(R.id.txtViewHonorSociety);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnPrevious = (Button) findViewById(R.id.btnPrevious);

        if (statusArray[3]==1){
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }
        if (statusArray[4]==1){
            image = (ImageView) findViewById(R.id.imgAbroad2);
            name = (TextView) findViewById(R.id.txtViewStudyAbroad);
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }
        if(statusArray[5]==1){
            image = (ImageView) findViewById(R.id.imgGraduation2);
            name = (TextView) findViewById(R.id.txtViewGraduation);
            image.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBackPress(view);
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPreviousPress(view);
            }
        });
    }
    public void btnBackPress (View view){
        Intent intentAvailableBadges = new Intent(this,AvailableBadgesPg2.class);
        intentAvailableBadges.putExtra("status_Array",statusArray);
        startActivity(intentAvailableBadges);
    }
    public void btnPreviousPress(View view){
        Intent intentAvailableBadges = new Intent(this,YourBadges.class);
        intentAvailableBadges.putExtra("status_Array",statusArray);
        startActivity(intentAvailableBadges);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_your_badges2, menu);
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
