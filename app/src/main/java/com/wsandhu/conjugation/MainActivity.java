package com.wsandhu.conjugation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, new MainFragment())
                            .commit();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_bugreport) {
            sendBugReport();
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendBugReport() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "sandhuwasim@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Conjugation: Bug Report");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I just found a bug in your app. Here's the problem: ");
        emailIntent.setData(Uri.parse("mailto:" + "sandhuwasim@gmail.com"));
        startActivity(Intent.createChooser(emailIntent, "Send Email to Developer"));
    }
}