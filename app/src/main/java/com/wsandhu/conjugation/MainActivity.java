package com.wsandhu.conjugation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    String infinitive;
    String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Button mConjugateButton = (Button) findViewById(R.id.conjugateButton);
        mConjugateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conjugate();
            }
        });
    }

    protected void Conjugate() {

        // Grabs input from text field and places it in String infinitive
        EditText mMainTextField = (EditText) findViewById(R.id.mainTextField);
        infinitive = mMainTextField.getText().toString();

        // replaces the ending in the -ar infinitive with present tense ending
        conjugationYo = infinitive.replace("ar", "o");
        conjugationTu = infinitive.replace("ar", "as");
        conjugationEl = infinitive.replace("ar", "a");
        conjugationNos = infinitive.replace("ar", "amos");
        conjugationOs = infinitive.replace("ar", "aís");
        conjugationEllos = infinitive.replace("ar", "an");

        // Casting the XML text views into Java objects...
        TextView mYoTextView = (TextView) findViewById(R.id.yoTextView);
        TextView mTuTextView = (TextView) findViewById(R.id.tuTextView);
        TextView mElTextView = (TextView) findViewById(R.id.elTextView);
        TextView mNosTextView = (TextView) findViewById(R.id.nosTextView);
        TextView mOsTextView = (TextView) findViewById(R.id.osTextView);
        TextView mEllosTextView = (TextView) findViewById(R.id.ellosTextView);

        // Sets the text of these placeholder text views to the conjugation :)
        mYoTextView.setText(conjugationYo);
        mTuTextView.setText(conjugationTu);
        mElTextView.setText(conjugationEl);
        mNosTextView.setText(conjugationNos);
        mOsTextView.setText(conjugationOs);
        mEllosTextView.setText(conjugationEllos);
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
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
