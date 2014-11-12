package com.wsandhu.conjugation;

import android.os.Bundle;
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

public class MainFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    public static String infinitive;
    public static String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;
    String stemChangedVerb;

    public static TextView mYoTextView, mTuTextView, mElTextView, mNosTextView, mOsTextView, mEllosTextView;
    Spinner mConjugationTypeSpinner;
    EditText mMainTextField;
    Button mConjugateButton;

    public static boolean isEndingAr, isEndingEr, isEndingIr, isIrregularVerb, isIrregularYoVerb, hasStemChange, hasSpellingChange;
    boolean E2IE, O2UE, E2I, U2UE;

    public static int verbTense;

    String[] irregularVerbs = {"ir", "ser", "estar", "dar", "saber", "conocer", "hacer", "traer", "poner",
            "ver", "salir", "conducir", "haber", "poder", "querer", "venir", "decir", "tener"};

    String[] irregularYoVerbs = {"tener", "venir", "salir", "poner", "caer", "traer", "oír", "hacer", "decir",
            "conducir", "conocer"};

    String[] stemChangingVerbsIE = {"cerrar", "comenzar", "despertar", "divertirse", "empezar",
            "encender", "entender", "sentir", "mentir", "negar", "nevar", "pensar", "perder", "preferir",
            "recomendar", "sentarse", "querer"};

    String[] stemChangingVerbsUE = {"almorzar", "aprobar", "contar", "costar", "doler", "dormir", "encontrar",
            "llover", "morir", "poder", "probar", "recordar", "soñar", "volar"};

    String[] stemChangingVerbsI = {"conseguir", "corregir", "elegir", "repetir", "seguir", "servir", "vestirse"};


    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Casting the XML text views into Java objects...
        mYoTextView = (TextView) rootView.findViewById(R.id.yoTextView);
        mTuTextView = (TextView) rootView.findViewById(R.id.tuTextView);
        mElTextView = (TextView) rootView.findViewById(R.id.elTextView);
        mNosTextView = (TextView) rootView.findViewById(R.id.nosTextView);
        mOsTextView = (TextView) rootView.findViewById(R.id.osTextView);
        mEllosTextView = (TextView) rootView.findViewById(R.id.ellosTextView);

        // Spinner for picking how to conjugate the verb
        mConjugationTypeSpinner = (Spinner) rootView.findViewById(R.id.conjugationTypeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.conjugation_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mConjugationTypeSpinner.setAdapter(adapter);
        mConjugationTypeSpinner.setOnItemSelectedListener(this);

        // Grabs input from text field and places it in String infinitive
        mMainTextField = (EditText) rootView.findViewById(R.id.mainTextField);

        /* The conjugate button code */
        mConjugateButton = (Button) rootView.findViewById(R.id.conjugateButton);
        mConjugateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conjugate();
            }
        });
        return rootView;
    }

    protected void conjugate() {
        // The string "infinitive" is whatever the user types in the text field
        infinitive = mMainTextField.getText().toString();

        // booleans for checking verb type
        isEndingAr = infinitive.endsWith("ar");
        isEndingEr = infinitive.endsWith("er");
        isEndingIr = infinitive.endsWith("ir");
        isIrregularVerb = Arrays.asList(irregularVerbs).contains(infinitive);
        isIrregularYoVerb = Arrays.asList(irregularYoVerbs).contains(infinitive);

        // boolean for checking for -car, -gar, -zar spelling changes for some tenses
        if (infinitive.endsWith("car")) { hasSpellingChange = true; }
        if (infinitive.endsWith("gar")) { hasSpellingChange = true; }
        if (infinitive.endsWith("zar")) { hasSpellingChange = true; }

        // Booleans for checking stem change before conjugation
        E2IE = Arrays.asList(stemChangingVerbsIE).contains(infinitive);
        O2UE = Arrays.asList(stemChangingVerbsUE).contains(infinitive);
        E2I = Arrays.asList(stemChangingVerbsI).contains(infinitive);
        U2UE = infinitive.equals("jugar");

        if (E2IE) { hasStemChange = true; }
        if (O2UE) { hasStemChange = true; }
        if (E2I) { hasStemChange = true; }
        if (U2UE) { hasStemChange = true; }

        // Check to see what kind of verb it is before conjugating
        if (isEndingAr && !isIrregularVerb) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                // checks for stem change in present tense
                if (hasStemChange) { stemChange(); }
                conjugateArVerbPresent();
            } else if (verbTense == 1) {
                conjugateArVerbPreterite();
            } else if (verbTense == 2) {
                conjugateArVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbNegativeCommand();
            } else if (verbTense == 6) {
                if (hasStemChange) { stemChange(); }
                conjugatePresentSubjunctive();
            } else if (verbTense == 7) {
                conjugateImperfectSubjunctive();
            } else if (verbTense == 8) {
                conjugateVerbConditional();
            }
        } else if (isEndingEr && !isIrregularVerb) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                // checks for stem change in present tense
                if (hasStemChange) { stemChange(); }
                conjugateErVerbPresent();
            } else if (verbTense == 1) {
                conjugateErIrVerbPreterite();
            } else if (verbTense == 2) {
                conjugateErIrVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbNegativeCommand();
            } else if (verbTense == 6) {
                if (hasStemChange) { stemChange(); }
                conjugatePresentSubjunctive();
            } else if (verbTense == 7) {
                conjugateImperfectSubjunctive();
            } else if (verbTense == 8) {
                conjugateVerbConditional();
            }
        } else if (isEndingIr && !isIrregularVerb) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                // checks for stem change in present tense
                if (hasStemChange) { stemChange(); }
                conjugateIrVerbPresent();
            } else if (verbTense == 1) {
                conjugateErIrVerbPreterite();
            } else if (verbTense == 2) {
                conjugateErIrVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbNegativeCommand();
            } else if (verbTense == 6) {
                if (hasStemChange) { stemChange(); }
                conjugatePresentSubjunctive();
            } else if (verbTense == 7) {
                conjugateImperfectSubjunctive();
            } else if (verbTense == 8) {
                conjugateVerbConditional();
            }
        } else if (isIrregularVerb) {
            IrregularVerb.conjugate();
        } else {
            Toast toast = Toast.makeText(getActivity(), "Cannot conjugate verb", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /* METHODS FOR PRESENT TENSE CONJUGATIONS */
    public void conjugateArVerbPresent() {

        // replaces the ending in the -ar infinitive with present tense ending
        if (!hasStemChange) {
            conjugationYo = infinitive.replace("ar", "o");
            conjugationTu = infinitive.replace("ar", "as");
            conjugationEl = infinitive.replace("ar", "a");
            conjugationNos = infinitive.replace("ar", "amos");
            conjugationOs = infinitive.replace("ar", "aís");
            conjugationEllos = infinitive.replace("ar", "an");
        } else {
            // stem change conjugations
            conjugationYo = stemChangedVerb.replace("ar", "o");
            conjugationTu = stemChangedVerb.replace("ar", "as");
            conjugationEl = stemChangedVerb.replace("ar", "a");
            conjugationNos = infinitive.replace("ar", "amos"); // stem doesn't change
            conjugationOs = infinitive.replace("ar", "aís"); // stem doesn't change
            conjugationEllos = stemChangedVerb.replace("ar", "an");
        }

        setText();

    }

    public void conjugateErVerbPresent() {

        // replaces the ending in the -er infinitive with present tense ending
        if (!hasStemChange) {
            conjugationYo = infinitive.replace("er", "o");
            conjugationTu = infinitive.replace("er", "es");
            conjugationEl = infinitive.replace("er", "e");
            conjugationNos = infinitive.replace("er", "emos");
            conjugationOs = infinitive.replace("er", "eís");
            conjugationEllos = infinitive.replace("er", "en");
        } else {
            // stem change conjugations
            conjugationYo = stemChangedVerb.replace("er", "o");
            conjugationTu = stemChangedVerb.replace("er", "es");
            conjugationEl = stemChangedVerb.replace("er", "e");
            conjugationNos = infinitive.replace("er", "emos"); // stem doesn't change
            conjugationOs = infinitive.replace("er", "eís"); // stem doesn't change
            conjugationEllos = stemChangedVerb.replace("er", "en");
            }

        setText();

    }

    public void conjugateIrVerbPresent() {

        // replaces the ending in the -ir infinitive with present tense ending
        if (!hasStemChange) {
            conjugationYo = infinitive.replace("ir", "o");
            conjugationTu = infinitive.replace("ir", "es");
            conjugationEl = infinitive.replace("ir", "e");
            conjugationNos = infinitive.replace("ir", "imos");
            conjugationOs = infinitive.replace("ir", "ís");
            conjugationEllos = infinitive.replace("ir", "en");
        } else {
            // stem change conjugations
            conjugationYo = stemChangedVerb.replace("ir", "o");
            conjugationTu = stemChangedVerb.replace("ir", "es");
            conjugationEl = stemChangedVerb.replace("ir", "e");
            conjugationNos = infinitive.replace("ir", "imos"); // stem doesn't change
            conjugationOs = infinitive.replace("ir", "ís"); // stem doesn't change
            conjugationEllos = stemChangedVerb.replace("ir", "en");
        }
        setText();

    }

    /* METHODS FOR PRETERITE TENSE CONJUGATIONS */
    public void conjugateArVerbPreterite() {

        // Spelling change of car/gar/zar verbs to maintain pronunciation
        if (hasSpellingChange) {
            if (infinitive.endsWith("car")) {
                conjugationYo = infinitive.replace("car", "qué");
            } else if (infinitive.endsWith("gar")) {
                conjugationYo = infinitive.replace("gar", "gué");
            } else if (infinitive.endsWith("zar")) {
                conjugationYo = infinitive.replace("zar", "cé");
            }
        } else { conjugationYo = infinitive.replace("ar", "é"); }

        conjugationTu = infinitive.replace("ar", "aste");
        conjugationEl = infinitive.replace("ar", "ó");
        conjugationNos = infinitive.replace("ar", "amos");
        conjugationOs = infinitive.replace("ar", "asteis");
        conjugationEllos = infinitive.replace("ar", "aron");

        setText();
    }

    public void conjugateErIrVerbPreterite() {

        if (isEndingEr) {
            conjugationYo = infinitive.replace("er", "í");
            conjugationTu = infinitive.replace("er", "iste");
            conjugationEl = infinitive.replace("er", "ió");
            conjugationNos = infinitive.replace("er", "imos");
            conjugationOs = infinitive.replace("er", "isteis");
            conjugationEllos = infinitive.replace("er", "ieron");
        }

        if (isEndingIr) {
            conjugationYo = infinitive.replace("ir", "í");
            conjugationTu = infinitive.replace("ir", "iste");
            conjugationEl = infinitive.replace("ir", "ió");
            conjugationNos = infinitive.replace("ir", "imos");
            conjugationOs = infinitive.replace("ir", "isteis");
            conjugationEllos = infinitive.replace("ir", "ieron");
        }

        setText();
    }

    /* METHODS FOR IMPERFECT TENSE CONJUGATION */
    public static void conjugateArVerbImperfect() {
        conjugationYo = infinitive.replace("ar", "aba");
        conjugationTu = infinitive.replace("ar", "abas");
        conjugationEl = infinitive.replace("ar", "aba");
        conjugationNos = infinitive.replace("ar", "ábamos");
        conjugationOs = infinitive.replace("ar", "abais");
        conjugationEllos = infinitive.replace("ar", "aban");

        setText();
    }

    public static void conjugateErIrVerbImperfect() {

        if (isEndingEr) {
            conjugationYo = infinitive.replace("er", "ía");
            conjugationTu = infinitive.replace("er", "ías");
            conjugationEl = infinitive.replace("er", "ía");
            conjugationNos = infinitive.replace("er", "íamos");
            conjugationOs = infinitive.replace("er", "íais");
            conjugationEllos = infinitive.replace("er", "ían");
        }

        if (isEndingIr) {
            conjugationYo = infinitive.replace("ir", "ía");
            conjugationTu = infinitive.replace("ir", "ías");
            conjugationEl = infinitive.replace("ir", "ía");
            conjugationNos = infinitive.replace("ir", "íamos");
            conjugationOs = infinitive.replace("ir", "íais");
            conjugationEllos = infinitive.replace("ir", "ían");
        }

        setText();
    }

    /* METHODS FOR FUTURE TENSE CONJUGATIONS */
    public static void conjugateVerbFuture() {

        conjugationYo = infinitive + "é";
        conjugationTu = infinitive + "ás";
        conjugationEl = infinitive + "á";
        conjugationNos = infinitive + "emos";
        conjugationOs = infinitive + "éis";
        conjugationEllos = infinitive + "án";

        setText();
    }

    /* METHODS FOR IMPERATIVE TENSE CONJUGATION */
    public void conjugateVerbAffirmativeCommand() {

        if (isEndingAr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replace("ar", "a");
                conjugationEl = stemChangedVerb.replace("ar", "e");
                conjugationNos = infinitive.replace("ar", "emos");
                conjugationEllos = stemChangedVerb.replace("ar", "en");
            } else {
                conjugationTu = infinitive.replace("ar", "a");
                conjugationEl = infinitive.replace("ar", "e");
                conjugationNos = infinitive.replace("ar", "emos");
                conjugationEllos = infinitive.replace("ar", "en");
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replace("er", "e");
                conjugationEl = stemChangedVerb.replace("er", "a");
                conjugationNos = infinitive.replace("er", "amos");
                conjugationEllos = stemChangedVerb.replace("o", "an");
            } else {
                conjugationTu = infinitive.replace("er", "e");
                conjugationEl = infinitive.replace("er", "a");
                conjugationNos = infinitive.replace("er", "amos");
                conjugationEllos = infinitive.replace("er", "an");
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replace("ir", "e");
                conjugationEl = stemChangedVerb.replace("ir", "a");
                conjugationNos = infinitive.replace("ir", "amos");
                conjugationEllos = stemChangedVerb.replace("ir", "an");
            } else {
                conjugationTu = infinitive.replace("ir", "e");
                conjugationEl = infinitive.replace("ir", "a");
                conjugationNos = infinitive.replace("ir", "amos");
                conjugationEllos = infinitive.replace("ir", "an");
            }
        }

        // No commands for these two forms
        conjugationYo = " ";
        conjugationOs = " ";

        setText();
    }

    public void conjugateVerbNegativeCommand() {

        // Tú commands are just present tense el/ella/usted
        if (isEndingAr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replace("ar", "es");
                conjugationEl = "no " + stemChangedVerb.replace("ar", "e");
                conjugationNos = "no " + infinitive.replace("ar", "emos");
                conjugationEllos = "no " + stemChangedVerb.replace("ar", "en");
            } else {
                conjugationTu = "no " + infinitive.replace("ar", "es");
                conjugationEl = "no " + infinitive.replace("ar", "e");
                conjugationNos = "no " + infinitive.replace("ar", "emos");
                conjugationEllos = "no " + infinitive.replace("ar", "en");
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replace("er", "as");
                conjugationEl = "no " + stemChangedVerb.replace("er", "a");
                conjugationNos = "no " + infinitive.replace("er", "amos");
                conjugationEllos = "no " + stemChangedVerb.replace("er", "an");
            } else {
                conjugationTu = "no " + infinitive.replace("er", "as");
                conjugationEl = "no " + infinitive.replace("er", "a");
                conjugationNos = "no " + infinitive.replace("er", "amos");
                conjugationEllos = "no " + infinitive.replace("er", "an");
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replace("ir", "as");
                conjugationEl = "no " + stemChangedVerb.replace("ir", "a");
                conjugationNos = "no " + infinitive.replace("ir", "amos");
                conjugationEllos = "no " + stemChangedVerb.replace("ir", "an");
            } else {
                conjugationTu = "no " + infinitive.replace("ir", "as");
                conjugationEl = "no " + infinitive.replace("ir", "a");
                conjugationNos = "no " + infinitive.replace("ir", "amos");
                conjugationEllos = "no " + infinitive.replace("ir", "an");
            }
        }

        // No commands for these two forms
        conjugationYo = " ";
        conjugationOs = " ";

        setText();
    }

    public void conjugatePresentSubjunctive() {

        // TODO spelling change of -car, -gar, -zar verbs
        if (isEndingAr) {
            if (hasStemChange) {
                conjugationYo = stemChangedVerb.replace("ar", "e");
                conjugationTu = stemChangedVerb.replace("ar", "es");
                conjugationEl = stemChangedVerb.replace("ar", "e");
                conjugationNos = infinitive.replace("ar", "emos");
                conjugationOs = infinitive.replace("ar", "éis");
                conjugationEllos = stemChangedVerb.replace("ar", "en");
            } else {
                conjugationYo = infinitive.replace("ar", "e");
                conjugationTu = infinitive.replace("ar", "es");
                conjugationEl = infinitive.replace("ar", "e");
                conjugationNos = infinitive.replace("ar", "emos");
                conjugationOs = infinitive.replace("ar", "éis");
                conjugationEllos = infinitive.replace("ar", "en");
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationYo = stemChangedVerb.replace("er", "a");
                conjugationTu = stemChangedVerb.replace("er", "as");
                conjugationEl = stemChangedVerb.replace("er", "a");
                conjugationNos = infinitive.replace("er", "amos");
                conjugationOs = infinitive.replace("er", "áis");
                conjugationEllos = stemChangedVerb.replace("o", "an");
            } else {
                conjugationYo = infinitive.replace("er", "a");
                conjugationTu = infinitive.replace("er", "as");
                conjugationEl = infinitive.replace("er", "a");
                conjugationNos = infinitive.replace("er", "amos");
                conjugationOs = infinitive.replace("er", "áis");
                conjugationEllos = infinitive.replace("er", "an");
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationYo = stemChangedVerb.replace("ir", "a");
                conjugationTu = stemChangedVerb.replace("ir", "as");
                conjugationEl = stemChangedVerb.replace("ir", "a");
                conjugationNos = infinitive.replace("ir", "amos");
                conjugationOs = infinitive.replace("ir", "áis");
                conjugationEllos = stemChangedVerb.replace("ir", "an");
            } else {
                conjugationYo = infinitive.replace("ir", "a");
                conjugationTu = infinitive.replace("ir", "as");
                conjugationEl = infinitive.replace("ir", "a");
                conjugationNos = infinitive.replace("ir", "amos");
                conjugationOs = infinitive.replace("ir", "áis");
                conjugationEllos = infinitive.replace("ir", "an");
            }
        }

        setText();
    }

    public void conjugateImperfectSubjunctive() {

        if (isEndingAr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            infinitive = infinitive.replace("ar", "aron");

            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replace("ron", "ra");
            conjugationTu = infinitive.replace("ron", "ras");
            conjugationEl = infinitive.replace("ron", "ra");
            conjugationNos = infinitive.replace("ron", "áramos");
            conjugationOs = infinitive.replace("ron", "rais");
            conjugationEllos = infinitive.replace("ron", "ran");
        } else if (isEndingEr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            infinitive = infinitive.replace("er", "ieron");

            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replace("ron", "ra");
            conjugationTu = infinitive.replace("ron", "ras");
            conjugationEl = infinitive.replace("ron", "ra");
            conjugationNos = infinitive.replace("ron", "éramos");
            conjugationOs = infinitive.replace("ron", "rais");
            conjugationEllos = infinitive.replace("ron", "ran");
        } else if (isEndingIr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            infinitive = infinitive.replace("ir", "ieron");

            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replace("ron", "ra");
            conjugationTu = infinitive.replace("ron", "ras");
            conjugationEl = infinitive.replace("ron", "ra");
            conjugationNos = infinitive.replace("ron", "éramos");
            conjugationOs = infinitive.replace("ron", "rais");
            conjugationEllos = infinitive.replace("ron", "ran");
        }

        setText();
    }

    public static void conjugateVerbConditional() {
        conjugationYo = infinitive + "ía";
        conjugationTu = infinitive + "ías";
        conjugationEl = infinitive + "ía";
        conjugationNos = infinitive + "íamos";
        conjugationOs = infinitive + "íais";
        conjugationEllos = infinitive + "ían";

        setText();
    }

    // Sets and clears the text of these placeholder text views to the conjugation
    public static void setText() {
        mYoTextView.setText(conjugationYo);
        mTuTextView.setText(conjugationTu);
        mElTextView.setText(conjugationEl);
        mNosTextView.setText(conjugationNos);
        mOsTextView.setText(conjugationOs);
        mEllosTextView.setText(conjugationEllos);
    }

    public static void clearText() {
        mYoTextView.setText(" ");
        mTuTextView.setText(" ");
        mElTextView.setText(" ");
        mNosTextView.setText(" ");
        mOsTextView.setText(" ");
        mEllosTextView.setText(" ");
    }

    private void stemChange() {
        int index;
        // another string that equals the value of "infinitive",
        // string is stem-changed in the conditional below
        stemChangedVerb = infinitive;

        if (E2IE) {
            // finds "e" and changes to stem "ie"
            index = stemChangedVerb.indexOf("e");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "ie");
            stemChangedVerb = sb.toString();
        } else if (O2UE) {
            // finds "o" and changes to stem "ue"
            index = stemChangedVerb.indexOf("o");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "ue");
            stemChangedVerb = sb.toString();
        } else if (E2I) {
            // finds "e" and changes to stem "i"
            index = stemChangedVerb.indexOf("e");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "i");
            stemChangedVerb = sb.toString();
        } else if (U2UE) {
            // finds "u" and changes to stem "ue"
            index = stemChangedVerb.indexOf("u");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "ue");
            stemChangedVerb = sb.toString();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        // verbTense is the position of the item selected in the spinner
        verbTense = mConjugationTypeSpinner.getSelectedItemPosition();
        /* 0 = present tense, 1 = preterite tense, 2 = imperfect tense, 3 = future tense,
           4 = affirmative imperative tense,  5 = negative imperative tense,
           6 = present subjunctive tense, 7 = imperfect subjunctive tense
         */
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

