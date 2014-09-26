package com.wsandhu.conjugation;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    String infinitive;
    String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;

    Spinner mConjugationTypeSpinner;

    boolean isPresentTense, isPreteriteTense, isImperfectTense, isFutureTense, isImperativeTense, isSubjunctiveTense;


    // TODO Complete list of different types of irregular verbs
    String[] irregularVerbs = {"ir", "ser", "estar", "dar", "saber", "conocer", "hacer", "traer", "poner",
            "ver", "salir", "conducir", "jugar"};

    public MainFragment() {

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

        // Spinner for picking how to conjugate the verb
        mConjugationTypeSpinner = (Spinner) rootView.findViewById(R.id.conjugationTypeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.conjugation_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mConjugationTypeSpinner.setAdapter(adapter);
        mConjugationTypeSpinner.setOnItemSelectedListener(this);

        // Grabs input from text field and places it in String infinitive
        final EditText mMainTextField = (EditText) rootView.findViewById(R.id.mainTextField);

        /* The conjugate button code */
        final Button mConjugateButton = (Button) rootView.findViewById(R.id.conjugateButton);
        mConjugateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The string "infinitive" is whatever the user types in the text field
                infinitive = mMainTextField.getText().toString();

                // booleans for checking verb type
                boolean isEndingAr = infinitive.endsWith("ar");
                boolean isEndingEr = infinitive.endsWith("er");
                boolean isEndingIr = infinitive.endsWith("ir");
                boolean isIrregularVerb = Arrays.asList(irregularVerbs).contains(infinitive);

                // Check to see what kind of verb it is before conjugating
                if (isEndingAr && !isIrregularVerb) {
                    conjugateArVerbPresent();
                } else if (isEndingEr && !isIrregularVerb) {
                    conjugateErVerbPresent();
                } else if (isEndingIr && !isIrregularVerb) {
                    conjugateIrVerbPresent();
                } else if (isIrregularVerb) {
                    conjugateIrregularVerb();
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Could not conjugate the verb: " + infinitive, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            protected void conjugateArVerbPresent() {

                // replaces the ending in the -ar infinitive with present tense ending
                conjugationYo = infinitive.replace("ar", "o");
                conjugationTu = infinitive.replace("ar", "as");
                conjugationEl = infinitive.replace("ar", "a");
                conjugationNos = infinitive.replace("ar", "amos");
                conjugationOs = infinitive.replace("ar", "aís");
                conjugationEllos = infinitive.replace("ar", "an");

                setText();

            }

            protected void conjugateErVerbPresent() {

                // replaces the -er ending in the infinitive with present tense ending
                conjugationYo = infinitive.replace("er", "o");
                conjugationTu = infinitive.replace("er", "es");
                conjugationEl = infinitive.replace("er", "e");
                conjugationNos = infinitive.replace("er", "emos");
                conjugationOs = infinitive.replace("er", "eís");
                conjugationEllos = infinitive.replace("er", "en");

                setText();

            }

            protected void conjugateIrVerbPresent() {

                // replaces the -ir ending in the infinitive with present tense ending
                conjugationYo = infinitive.replace("ir", "o");
                conjugationTu = infinitive.replace("ir", "es");
                conjugationEl = infinitive.replace("ir", "e");
                conjugationNos = infinitive.replace("ir", "imos");
                conjugationOs = infinitive.replace("ir", "ís");
                conjugationEllos = infinitive.replace("ir", "en");

                setText();

            }

            // Very messy method for conjugation of present tense irregular verbs
            protected void conjugateIrregularVerb() {

                if (infinitive.equals("ir")) {
                    conjugationYo = "voy";
                    conjugationTu = "vas";
                    conjugationEl = "va";
                    conjugationNos = "vamos";
                    conjugationOs = "vaís";
                    conjugationEllos = "van";
                    setText();
                } else if (infinitive.equals("ser")) {
                    conjugationYo = "soy";
                    conjugationTu = "eres";
                    conjugationEl = "es";
                    conjugationNos = "somos";
                    conjugationOs = "soís";
                    conjugationEllos = "son";
                    setText();
                } else if (infinitive.equals("estar")) {
                    conjugationYo = "estoy";
                    conjugationTu = "estás";
                    conjugationEl = "está";
                    conjugationNos = "estamos";
                    conjugationOs = "estáis";
                    conjugationEllos = "están";
                    setText();
                } else if (infinitive.equals("dar")) {
                    conjugationYo = "doy";
                    conjugationTu = "das";
                    conjugationEl = "da";
                    conjugationNos = "damos";
                    conjugationOs = "dais";
                    conjugationEllos = "dan";
                    setText();
                } else if (infinitive.equals("saber")) {
                    conjugationYo = "sé";
                    conjugationTu = "sabes";
                    conjugationEl = "sabe";
                    conjugationNos = "sabemos";
                    conjugationOs = "sabéis";
                    conjugationEllos = "saben";
                    setText();
                } else if (infinitive.equals("conocer")) {
                    conjugationYo = "conozco";
                    conjugationTu = "conoces";
                    conjugationEl = "conoce";
                    conjugationNos = "conocemos";
                    conjugationOs = "conocéis";
                    conjugationEllos = "conocen";
                    setText();
                } else if (infinitive.equals("hacer")) {
                    conjugationYo = "hago";
                    conjugationTu = "haces";
                    conjugationEl = "hace";
                    conjugationNos = "hacemos";
                    conjugationOs = "hacéis";
                    conjugationEllos = "hacen";
                    setText();
                } else if (infinitive.equals("traer")) {
                    conjugationYo = "traigo";
                    conjugationTu = "traes";
                    conjugationEl = "trae";
                    conjugationNos = "traemos";
                    conjugationOs = "traéis";
                    conjugationEllos = "traen";
                    setText();
                } else if (infinitive.equals("poner")) {
                    conjugationYo = "pongo";
                    conjugationTu = "pones";
                    conjugationEl = "pone";
                    conjugationNos = "ponemos";
                    conjugationOs = "ponéis";
                    conjugationEllos = "ponen";
                    setText();
                } else if (infinitive.equals("ver")) {
                    conjugationYo = "veo";
                    conjugationTu = "ves";
                    conjugationEl = "ve";
                    conjugationNos = "vemos";
                    conjugationOs = "véis";
                    conjugationEllos = "ven";
                    setText();
                } else if (infinitive.equals("salir")) {
                    conjugationYo = "salgo";
                    conjugationTu = "sales";
                    conjugationEl = "sale";
                    conjugationNos = "salemos";
                    conjugationOs = "salís";
                    conjugationEllos = "salen";
                    setText();
                } else if (infinitive.equals("conducir")) {
                    conjugationYo = "conduzco";
                    conjugationTu = "conduces";
                    conjugationEl = "conduce";
                    conjugationNos = "conducimos";
                    conjugationOs = "conducís";
                    conjugationEllos = "conducen";
                    setText();
                } else if (infinitive.equals("jugar")) {
                    conjugationYo = "juego";
                    conjugationTu = "juegas";
                    conjugationEl = "juega";
                    conjugationNos = "jugamos";
                    conjugationOs = "jugáis";
                    conjugationEllos = "juegan";
                    setText();
                } else {
                    Log.e("ERROR", "Cannot conjugate irregular verb!");
                }
            }

            // Sets the text of these placeholder text views to the conjugation
            protected void setText() {
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

    @Override
    // TODO: Figure out how to properly use this method!
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        mConjugationTypeSpinner.getItemAtPosition(position);

        // Changes the boolean flags depending on position of selected item in spinner
        switch(position) {
            case 0:
                isPresentTense = true;
            case 1:
                isPreteriteTense = true;
            case 2:
                isImperfectTense = true;
            case 3:
                isFutureTense = true;
            case 4:
                isImperativeTense = true;
            case 5:
                isSubjunctiveTense = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

