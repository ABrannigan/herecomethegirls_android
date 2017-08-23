package com.herecomethegirls.abrannigan.android.datastream.datastreams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.Toast;


public class LoginActivity extends Activity {

    private EditText mUsername;
    private EditText channelEditText;
    private String channelName;
    private static final String TAG = "Tracker";
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText) findViewById(R.id.login_username);

        channelEditText = (EditText) findViewById(R.id.channelEditText);

       // ImageView image = (ImageView) findViewById(R.id.imageView2);


        channelEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN)) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            channelName = channelEditText.getText().toString();
                            String message = "Chosen channel: " + channelName;
                            Toast.makeText(LoginActivity.this, message,
                                    Toast.LENGTH_SHORT).show();
                            Log.d(TAG, message);
                            return true;
                        default:
                            break;
                    }
                    return true;
                }
                return false;
            }
        });




        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String lastUsername = extras.getString("oldUsername", "");
            mUsername.setText(lastUsername);

            String lastChannel = extras.getString("oldChannel", "");
            channelEditText.setText(lastChannel);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }



    /**
     * Takes the username from the EditText, and channel from channelEdittext check its validity and saves it if valid.
     *   Then, redirects to the MainActivity.
     *
     */
    public void joinChat(View view){
        String username = mUsername.getText().toString();
        String channel = channelEditText.getText().toString();
        if (!validUsername(username))
            return;
        if(!validChannelName(channel)){
            channelEditText.setError("Group key  must contain uppercase & lowercase letters, " +
                    "special symbols & be between 8-20 Characters");
            return;
        }

        SharedPreferences sp = getSharedPreferences(Constants.CHAT_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(Constants.CHAT_USERNAME, username);
        edit.putString(Constants.CHANNEL_NAME, channel);
        edit.apply();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    //username validation method

    private boolean validUsername(String username) {
        if (username.length() == 0) {
            mUsername.setError("Username cannot be empty.");
            return false;
        }
        if (username.length() > 16) {
            mUsername.setError("Username too long.");
            return false;
        }
        return true;
    }

    //channel validation method
    private boolean validChannelName(String channel) {

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(channel);

        return matcher.matches();


    }







}
