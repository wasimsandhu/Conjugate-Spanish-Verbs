package com.wsandhu.conjugation;

import android.app.Fragment;
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

public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public static String infinitive;
    public static String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;

    public static TextView mYoTextView, mTuTextView, mElTextView, mNosTextView, mOsTextView, mEllosTextView;
    Spinner mConjugationTypeSpinner;
    EditText mMainTextField;
    Button mConjugateButton;

    public static boolean isEndingAr, isEndingEr, isEndingIr, isIrregularVerb, isIrregularYoVerb, hasStemChange;
    boolean E2IE, O2UE, E2I;

    public static int verbTense;

    String[] irregularVerbs = {"ir", "ser", "estar", "dar", "saber", "conocer", "hacer", "traer", "poner",
            "ver", "salir", "conducir", "jugar", "haber", "poder", "querer", "venir", "decir"};

    String[] irregularYoVerbs = {"tener", "venir", "salir", "poner", "caer", "traer", "oír", "hacer", "decir",
            "conducir", "conocer"};

    String[] stemChangingVerbsIE = {"cerrar", "comenzar", "despertar", "divertirse", "empezar",
            "encender", "entender", "sentir", "mentir", "negar", "nevar", "pensar", "perder", "preferir",
            "recomendar", "sentarse", "querer"};

    String[] stemChangingVerbsUE = {"almorzar", "aprobar", "contar", "costar", "doler", "dormir", "encontrar",
            "jugar", "llover", "morir", "poder", "probar", "recordar", "soñar", "volar"};

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

        // Booleans for checking stem change before conjugation
        E2IE = Arrays.asList(stemChangingVerbsIE).contains(infinitive);
        O2UE = Arrays.asList(stemChangingVerbsUE).contains(infinitive);
        E2I = Arrays.asList(stemChangingVerbsI).contains(infinitive);

        if (E2IE || O2UE || E2I) { hasStemChange = true; }

        if (hasStemChange) { stemChangeConjugation(); }

        // Check to see what kind of verb it is before conjugating
        if (isEndingAr && !isIrregularVerb) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                conjugateArVerbPresent();
            } else if (verbTense == 1) {
                conjugateArVerbPreterite();
            } else if (verbTense == 2) {
                conjugateArVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                conjugateVerbNegativeCommand();
            }
        } else if (isEndingEr && !isIrregularVerb) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                conjugateErVerbPresent();
            } else if (verbTense == 1) {
                conjugateErIrVerbPreterite();
            } else if (verbTense == 2) {
                conjugateErIrVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                conjugateVerbNegativeCommand();
            }
        } else if (isEndingIr && !isIrregularVerb) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                conjugateIrVerbPresent();
            } else if (verbTense == 1) {
                conjugateErIrVerbPreterite();
            } else if (verbTense == 2) {
                conjugateErIrVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                conjugateVerbNegativeCommand();
            }
        } else if (isIrregularVerb) {
            IrregularVerb.conjugate();
        } else {
            Toast toast = Toast.makeText(getActivity(), "No puedo conjugar eso.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /* METHODS FOR PRESENT TENSE CONJUGATIONS */
    public void conjugateArVerbPresent() {

        // replaces the ending in the -ar infinitive with present tense ending
        conjugationYo = infinitive.replace("ar", "o");
        conjugationTu = infinitive.replace("ar", "as");
        conjugationEl = infinitive.replace("ar", "a");
        conjugationNos = infinitive.replace("ar", "amos");
        conjugationOs = infinitive.replace("ar", "aís");
        conjugationEllos = infinitive.replace("ar", "an");

        setText();

    }

    public void conjugateErVerbPresent() {

        conjugationYo = infinitive.replace("er", "o");
        conjugationTu = infinitive.replace("er", "es");
        conjugationEl = infinitive.replace("er", "e");
        conjugationNos = infinitive.replace("er", "emos");
        conjugationOs = infinitive.replace("er", "eís");
        conjugationEllos = infinitive.replace("er", "en");

        setText();

    }

    public void conjugateIrVerbPresent() {

        conjugationYo = infinitive.replace("ir", "o");
        conjugationTu = infinitive.replace("ir", "es");
        conjugationEl = infinitive.replace("ir", "e");
        conjugationNos = infinitive.replace("ir", "imos");
        conjugationOs = infinitive.replace("ir", "ís");
        conjugationEllos = infinitive.replace("ir", "en");

        setText();

    }

    /* METHODS FOR PRETERITE TENSE CONJUGATIONS */
    public void conjugateArVerbPreterite() {

        conjugationYo = infinitive.replace("ar", "é");
        conjugationTu = infinitive.replace("ar", "aste");
        conjugationEl = infinitive.replace("ar", "ó");
        conjugationNos = infinitive.replace("ar", "amos");
        conjugationOs = infinitive.replace("ar", "asteis");
        conjugationEllos = infinitive.replace("ar", "aron");

        setText();
    }

    public void conjugateErIrVerbPreterite() {

        conjugationYo = infinitive.replace("er", "í");
        conjugationTu = infinitive.replace("er", "iste");
        conjugationEl = infinitive.replace("er", "ió");
        conjugationNos = infinitive.replace("er", "imos");
        conjugationOs = infinitive.replace("er", "isteis");
        conjugationEllos = infinitive.replace("er", "ieron");

        conjugationYo = infinitive.replace("ir", "í");
        conjugationTu = infinitive.replace("ir", "iste");
        conjugationEl = infinitive.replace("ir", "ió");
        conjugationNos = infinitive.replace("ir", "imos");
        conjugationOs = infinitive.replace("ir", "isteis");
        conjugationEllos = infinitive.replace("ir", "ieron");

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
        conjugationYo = infinitive.replace("er", "ía");
        conjugationTu = infinitive.replace("er", "ías");
        conjugationEl = infinitive.replace("er", "ía");
        conjugationNos = infinitive.replace("er", "íamos");
        conjugationOs = infinitive.replace("er", "íais");
        conjugationEllos = infinitive.replace("er", "ían");

        conjugationYo = infinitive.replace("ir", "ía");
        conjugationTu = infinitive.replace("ir", "ías");
        conjugationEl = infinitive.replace("ir", "ía");
        conjugationNos = infinitive.replace("ir", "íamos");
        conjugationOs = infinitive.replace("ir", "íais");
        conjugationEllos = infinitive.replace("ir", "ían");

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
    public static void conjugateVerbAffirmativeCommand() {
        conjugationYo = " ";

        // Tú commands are just present tense el/ella/usted
        if (isEndingAr) {
            conjugationTu = infinitive.replace("ar", "a");
        } else if (isEndingEr) {
            conjugationTu = infinitive.replace("er", "e");
        } else if (isEndingIr) {
            conjugationTu = infinitive.replace("er", "e");
        }

        // Usted commands use "opposite" endings
        if (isEndingAr) {
            conjugationEl = infinitive.replace("ar", "e");
        } else if (isEndingEr) {
            conjugationEl = infinitive.replace("er", "a");
        } else if (isEndingIr) {
            conjugationEl = infinitive.replace("ir", "a");
        }

        // Nosotros commands
        if (isEndingAr) {
            conjugationNos = infinitive.replace("ar", "emos");
        } else if (isEndingEr) {
            conjugationNos = infinitive.replace("er", "amos");
        } else if (isEndingIr) {
            conjugationNos = infinitive.replace("ir", "amos");
        }

        conjugationOs = " ";
        if (isEndingAr) {
            conjugationEllos = infinitive.replace("ar", "en");
        } else if (isEndingEr) {
            conjugationEllos = infinitive.replace("er", "an");
        } else if (isEndingIr) {
            conjugationEllos = infinitive.replace("ir", "an");
        }

        setText();
    }

    public static void conjugateVerbNegativeCommand() {
        // TODO Figure this out
        conjugationYo = " ";

        // Tú commands are just present tense el/ella/usted
        if (isEndingAr) {
            conjugationTu = "no " + infinitive.replace("ar", "es");
        } else if (isEndingEr) {
            conjugationTu = "no " + infinitive.replace("er", "as");
        } else if (isEndingIr) {
            conjugationTu = "no " + infinitive.replace("er", "as");
        }

        // Usted commands use "opposite" endings
        if (isEndingAr) {
            conjugationEl = "no " + infinitive.replace("ar", "e");
        } else if (isEndingEr) {
            conjugationEl = "no " + infinitive.replace("er", "a");
        } else if (isEndingIr) {
            conjugationEl = "no " + infinitive.replace("ir", "a");
        }

        // Nosotros commands
        if (isEndingAr) {
            conjugationNos = "no " + infinitive.replace("ar", "emos");
        } else if (isEndingEr) {
            conjugationNos = "no " + infinitive.replace("er", "amos");
        } else if (isEndingIr) {
            conjugationNos = "no " + infinitive.replace("ir", "amos");
        }

        conjugationOs = " ";
        if (isEndingAr) {
            conjugationEllos = "no " + infinitive.replace("ar", "en");
        } else if (isEndingEr) {
            conjugationEllos = "no " + infinitive.replace("er", "an");
        } else if (isEndingIr) {
            conjugationEllos = "no " + infinitive.replace("ir", "an");
        }

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

    public void stemChangeConjugation() {
        int index;

        if (E2IE) {
            // finds "e" and changes to stem "ie"
            index = infinitive.indexOf("e");
            StringBuilder sb = new StringBuilder(infinitive);
            sb = sb.replace(index, index + 1, "ie");
            infinitive = sb.toString();
        } else if (O2UE) {
            // finds "o" and changes to stem "ue"
            index = infinitive.indexOf("e");
            StringBuilder sb = new StringBuilder(infinitive);
            sb = sb.replace(index, index + 1, "ue");
            infinitive = sb.toString();
        } else if (E2I) {
            // finds "e" and changes to stem "i"
            index = infinitive.indexOf("e");
            StringBuilder sb = new StringBuilder(infinitive);
            sb = sb.replace(index, index + 1, "i");
            infinitive = sb.toString();
        } else {

        }
    }

    @Override
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

