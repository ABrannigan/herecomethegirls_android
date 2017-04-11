package com.herecomethegirls.abrannigan.android.datastream.datastreams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by adam on 16/02/2017.
 */
public class MainActivity extends AppCompatActivity {

    private boolean useMapBox;
    private EditText channelEditText;

    private String channelName = Constants.CHANNEL_NAME;
    private static final String TAG = "Tracker - MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.chat);

// Set a click listener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(numbersIntent);
            }
        });

    }

    public void shareLocation(View view) {

            Log.d(TAG, "Share Location With Google Maps Chosen on channel: "
                    + channelName);
            callActivity(ShareLocationActivity.class);


    }

    public void followLocation(View view) {

            Log.d(TAG, "Follow Location With Google Maps Chosen on channel: "
                    + channelName);
            callActivity(LocateActivity.class);

    }

    private void callActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.putExtra("channel", channelName);
        startActivity(intent);
    }

}




