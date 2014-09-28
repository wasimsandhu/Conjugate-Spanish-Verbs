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

    boolean isEndingAr, isEndingEr, isEndingIr, isIrregularVerb;

    int verbTense;

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
                conjugate();
            }

            protected void conjugate() {
                // The string "infinitive" is whatever the user types in the text field
                infinitive = mMainTextField.getText().toString();

                // booleans for checking verb type
                isEndingAr = infinitive.endsWith("ar");
                isEndingEr = infinitive.endsWith("er");
                isEndingIr = infinitive.endsWith("ir");
                isIrregularVerb = Arrays.asList(irregularVerbs).contains(infinitive);

                // Check to see what kind of verb it is before conjugating
                if (isEndingAr && !isIrregularVerb) {
                    // checks verb tense and then calls respective method
                    if (verbTense == 0) {
                        conjugateArVerbPresent();
                    } else if (verbTense == 1) {
                        conjugateArVerbPreterite();
                    }
                } else if (isEndingEr && !isIrregularVerb) {
                    if (verbTense == 0) {
                        conjugateErVerbPresent();
                    } else if (verbTense == 1) {
                        conjugateErIrVerbPreterite();
                    }
                } else if (isEndingIr && !isIrregularVerb) {
                    if (verbTense == 0) {
                        conjugateIrVerbPresent();
                    } else if (verbTense == 1) {
                        conjugateErIrVerbPreterite();
                    }
                } else if (isIrregularVerb) {
                    conjugateIrregularVerb();
                } else {
                    Toast toast = Toast.makeText(getActivity(), "Could not conjugate the verb: " + infinitive, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            /* METHODS FOR PRESENT TENSE CONJUGATIONS */
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

                conjugationYo = infinitive.replace("er", "o");
                conjugationTu = infinitive.replace("er", "es");
                conjugationEl = infinitive.replace("er", "e");
                conjugationNos = infinitive.replace("er", "emos");
                conjugationOs = infinitive.replace("er", "eís");
                conjugationEllos = infinitive.replace("er", "en");

                setText();

            }

            protected void conjugateIrVerbPresent() {

                conjugationYo = infinitive.replace("ir", "o");
                conjugationTu = infinitive.replace("ir", "es");
                conjugationEl = infinitive.replace("ir", "e");
                conjugationNos = infinitive.replace("ir", "imos");
                conjugationOs = infinitive.replace("ir", "ís");
                conjugationEllos = infinitive.replace("ir", "en");

                setText();

            }

            /* METHODS FOR PRETERITE TENSE CONJUGATIONS */
            protected void conjugateArVerbPreterite() {

                conjugationYo = infinitive.replace("ar", "é");
                conjugationTu = infinitive.replace("ar", "aste");
                conjugationEl = infinitive.replace("ar", "ó");
                conjugationNos = infinitive.replace("ar", "amos");
                conjugationOs = infinitive.replace("ar", "asteis");
                conjugationEllos = infinitive.replace("ar", "aron");

                setText();
            }

            protected void conjugateErIrVerbPreterite() {

                conjugationYo = infinitive.replace("ir", "í");
                conjugationTu = infinitive.replace("ir", "iste");
                conjugationEl = infinitive.replace("ir", "ió");
                conjugationNos = infinitive.replace("ir", "imos");
                conjugationOs = infinitive.replace("ir", "isteis");
                conjugationEllos = infinitive.replace("ir", "ieron");

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
        // verbTense is the position of the item selected in the spinner
        verbTense = mConjugationTypeSpinner.getSelectedItemPosition();
        /* 0 = present tense, 1 = preterite tense, 2 = imperfect tense, 3 = future tense,
           4 = imperative tense, 5 = subjunctive tense
         */
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

