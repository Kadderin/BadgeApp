package com.example.kristine.badgeapp;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.example.kristine.badgeapp.XMLParserHandler;
import com.example.kristine.badgeapp.Badge;

public class AvailableBadges extends Activity {
    int[] statusArray;

    /*int idListForImg[] = {      //Stephany Added
            R.id.imgAbroad,
            R.id.imgAcademicAward,
            R.id.imgCommunity,
            R.id.imgDeansList,
            R.id.imgGraduation,
            R.id.imgSociety };

    //XmlPullParserFactory factory;      //Stephany Added
    //XmlPullParser parser;      //Stephany Added
    ArrayAdapter<Badge> adapter;      //Stephany Added
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_badges);

        Intent intent = getIntent();
        statusArray = intent.getIntArrayExtra("status_Array");
        //Finding the views by their ID
        Button btnMyBdg = (Button) findViewById(R.id.btnMyBadges_Avail);
        Button btnNext = (Button) findViewById(R.id.btnNextAvailableBdg);
        Button btnCommunity = (Button) findViewById(R.id.btnAddCommunity);
        Button btnAcademic = (Button) findViewById(R.id.btnAddAcademicAward);
        Button btnDean = (Button) findViewById(R.id.btnAddDeansList);
        //Setting on click listeners for the buttons
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
        btnAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddAcademic(view);
            }
        });
        btnDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddDean(view);
            }
        });

       /* ImgListener listener = new ImgListener();      //Stephany Added

        for(int id: idListForImg) {      //Stephany Added
            ImageView view = (ImageView) findViewById(id);
            view.setOnClickListener(listener);
        }*/
    }
/*
    public class ImgListener implements OnClickListener {      //Stephany Added
        @Override
        public void onClick (View view){

            for(int id: idListForImg){
            //android:clickable="true"
            //0. check which id it is
            //1. open the xml file
            //2. get the string id name to requirements
            //3. open the requirements in a dialog box

                switch (view.getId())
                {
                    case R.id.imgAbroad:
                        id = R.id.imgAbroad;
                        parseXML();
                        openAlert(view);
                        break;
                    case R.id.imgAcademicAward:
                        id = R.id.imgAcademicAward;
                        parseXML();
                        openAlert(view);                        break;
                    case R.id.imgCommunity:
                        id = R.id.imgCommunity;
                        parseXML();
                        openAlert(view);                        break;
                    case R.id.imgDeansList:
                        id = R.id.imgDeansList;
                        parseXML();
                        openAlert(view);                        break;
                    case R.id.imgGraduation:
                        id = R.id.imgGraduation;
                        parseXML();
                        openAlert(view);                        break;
                    case R.id.imgSociety:
                        id = R.id.imgSociety;
                        parseXML();
                        openAlert(view);                        break;
                }
            }
        }

        public ArrayAdapter<Badge> parseXML (){      //Stephany Added
            ArrayList<Badge> Badges = new ArrayList<Badge>();
            try {
                XMLParserHandler parser = new XMLParserHandler();
                InputStream is = getApplicationContext().getAssets().open("xml/Badges.xml");
                parser.parse(is);
                adapter = new ArrayAdapter<Badge>(getApplicationContext(), android.R.layout.simple_list_item_1, Badges);
                //lv.setAdapter(adapter);

                return adapter;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        private void openAlert(View view) {      //Stephany Added

            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setTitle("Badge Requirements")
                    .setAdapter(adapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setNegativeButton("Ok", null); // nothing simply dismiss

            builder.create();

            AlertDialog alert = builder.create();
            alert.show();
        }
    }
*/

    //called when the user presses the add button for the Community badge
    public void btnAddCommunity (View view){
        Intent intent = new Intent(this, YourBadges.class);
        statusArray[0]=1;
        intent.putExtra("status_Array",statusArray);
        //intent.putExtra("state",0);
        startActivity(intent);
    }
    public void btnAddAcademic (View view){
        Intent intent = new Intent(this, YourBadges.class);
        statusArray[1]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }
    public void btnAddDean(View view){
        Intent intent = new Intent(this, YourBadges.class);
        statusArray[2]=1;
        intent.putExtra("status_Array",statusArray);
        startActivity(intent);
    }
    //called when the user selects the My Badge button
    public void btnGoToMyBadges(View view){
        Intent intentMyBadges = new Intent (this, YourBadges.class);
        intentMyBadges.putExtra("status_Array",statusArray);
        startActivity(intentMyBadges);
    }
    //called when the user selects the next button to switch to the second "My Badge" page
    public void btnNextAvailableBdg (View view) {

        Intent intent = new Intent(this, AvailableBadgesPg2.class);
        intent.putExtra("status_Array",statusArray);
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
