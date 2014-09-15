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
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        String infinitive;
        String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;

        public PlaceholderFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Casting the XML text views into Java objects...
            final TextView mYoTextView = (TextView) rootView.findViewById(R.id.yoTextView);
            final TextView mTuTextView = (TextView) rootView.findViewById(R.id.tuTextView);
            final TextView mElTextView = (TextView) rootView.findViewById(R.id.elTextView);
            final TextView mNosTextView = (TextView) rootView.findViewById(R.id.nosTextView);
            final TextView mOsTextView = (TextView) rootView.findViewById(R.id.osTextView);
            final TextView mEllosTextView = (TextView) rootView.findViewById(R.id.ellosTextView);

            // Grabs input from text field and places it in String infinitive
            final EditText mMainTextField = (EditText) rootView.findViewById(R.id.mainTextField);

            final Button mConjugateButton = (Button) rootView.findViewById(R.id.conjugateButton);
            mConjugateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    infinitive = mMainTextField.getText().toString();

                    boolean isEndingAr = infinitive.endsWith("ar");
                    boolean isEndingEr = infinitive.endsWith("er");
                    boolean isEndingIr = infinitive.endsWith("ir");

                    // Check to see what kind of verb it is before conjugating
                    if (isEndingAr) {
                        conjugateArVerb();
                    } else if (isEndingEr) {
                        conjugateErVerb();
                    } else if (isEndingIr) {
                        conjugateIrVerb();
                    } else {
                        Toast toast = Toast.makeText(getActivity(), "Could not conjugate the verb: " + infinitive, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

                protected void conjugateArVerb() {

                    // replaces the ending in the -ar infinitive with present tense ending
                    conjugationYo = infinitive.replace("ar", "o");
                    conjugationTu = infinitive.replace("ar", "as");
                    conjugationEl = infinitive.replace("ar", "a");
                    conjugationNos = infinitive.replace("ar", "amos");
                    conjugationOs = infinitive.replace("ar", "aís");
                    conjugationEllos = infinitive.replace("ar", "an");

                    // Sets the text of these placeholder text views to the conjugation :)
                    mYoTextView.setText(conjugationYo);
                    mTuTextView.setText(conjugationTu);
                    mElTextView.setText(conjugationEl);
                    mNosTextView.setText(conjugationNos);
                    mOsTextView.setText(conjugationOs);
                    mEllosTextView.setText(conjugationEllos);

                }

                protected void conjugateErVerb() {

                    // replaces the -er ending in the infinitive with present tense ending
                    conjugationYo = infinitive.replace("er", "o");
                    conjugationTu = infinitive.replace("er", "es");
                    conjugationEl = infinitive.replace("er", "e");
                    conjugationNos = infinitive.replace("er", "emos");
                    conjugationOs = infinitive.replace("er", "eís");
                    conjugationEllos = infinitive.replace("er", "en");

                    // Sets the text of these placeholder text views to the conjugation :)
                    mYoTextView.setText(conjugationYo);
                    mTuTextView.setText(conjugationTu);
                    mElTextView.setText(conjugationEl);
                    mNosTextView.setText(conjugationNos);
                    mOsTextView.setText(conjugationOs);
                    mEllosTextView.setText(conjugationEllos);

                }

                protected void conjugateIrVerb() {

                    // replaces the -ir ending in the infinitive with present tense ending
                    conjugationYo = infinitive.replace("ir", "o");
                    conjugationTu = infinitive.replace("ir", "es");
                    conjugationEl = infinitive.replace("ir", "e");
                    conjugationNos = infinitive.replace("ir", "imos");
                    conjugationOs = infinitive.replace("ir", "ís");
                    conjugationEllos = infinitive.replace("ir", "en");

                    // Sets the text of these placeholder text views to the conjugation :)
                    mYoTextView.setText(conjugationYo);
                    mTuTextView.setText(conjugationTu);
                    mElTextView.setText(conjugationEl);
                    mNosTextView.setText(conjugationNos);
                    mOsTextView.setText(conjugationOs);
                    mEllosTextView.setText(conjugationEllos);

                }

            });

            return rootView;
        }
    }
}
