package com.wsandhu.conjugation;

/**
 * Created by wasimsandhu on 9/28/14.
 */
public class IrregularVerb {

    public static void conjugate() {

        // Present tense irregular verbs
        if (MainFragment.verbTense == 0) {
            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "voy";
                MainFragment.conjugationTu = "vas";
                MainFragment.conjugationEl = "va";
                MainFragment.conjugationNos = "vamos";
                MainFragment.conjugationOs = "vaís";
                MainFragment.conjugationEllos = "van";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "soy";
                MainFragment.conjugationTu = "eres";
                MainFragment.conjugationEl = "es";
                MainFragment.conjugationNos = "somos";
                MainFragment.conjugationOs = "soís";
                MainFragment.conjugationEllos = "son";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.conjugationYo = "estoy";
                MainFragment.conjugationTu = "estás";
                MainFragment.conjugationEl = "está";
                MainFragment.conjugationNos = "estamos";
                MainFragment.conjugationOs = "estáis";
                MainFragment.conjugationEllos = "están";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.conjugationYo = "doy";
                MainFragment.conjugationTu = "das";
                MainFragment.conjugationEl = "da";
                MainFragment.conjugationNos = "damos";
                MainFragment.conjugationOs = "dais";
                MainFragment.conjugationEllos = "dan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.conjugationYo = "sé";
                MainFragment.conjugationTu = "sabes";
                MainFragment.conjugationEl = "sabe";
                MainFragment.conjugationNos = "sabemos";
                MainFragment.conjugationOs = "sabéis";
                MainFragment.conjugationEllos = "saben";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conocer")) {
                MainFragment.conjugationYo = "conozco";
                MainFragment.conjugationTu = "conoces";
                MainFragment.conjugationEl = "conoce";
                MainFragment.conjugationNos = "conocemos";
                MainFragment.conjugationOs = "conocéis";
                MainFragment.conjugationEllos = "conocen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.conjugationYo = "hago";
                MainFragment.conjugationTu = "haces";
                MainFragment.conjugationEl = "hace";
                MainFragment.conjugationNos = "hacemos";
                MainFragment.conjugationOs = "hacéis";
                MainFragment.conjugationEllos = "hacen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {
                MainFragment.conjugationYo = "traigo";
                MainFragment.conjugationTu = "traes";
                MainFragment.conjugationEl = "trae";
                MainFragment.conjugationNos = "traemos";
                MainFragment.conjugationOs = "traéis";
                MainFragment.conjugationEllos = "traen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.conjugationYo = "pongo";
                MainFragment.conjugationTu = "pones";
                MainFragment.conjugationEl = "pone";
                MainFragment.conjugationNos = "ponemos";
                MainFragment.conjugationOs = "ponéis";
                MainFragment.conjugationEllos = "ponen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "veo";
                MainFragment.conjugationTu = "ves";
                MainFragment.conjugationEl = "ve";
                MainFragment.conjugationNos = "vemos";
                MainFragment.conjugationOs = "véis";
                MainFragment.conjugationEllos = "ven";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.conjugationYo = "salgo";
                MainFragment.conjugationTu = "sales";
                MainFragment.conjugationEl = "sale";
                MainFragment.conjugationNos = "salemos";
                MainFragment.conjugationOs = "salís";
                MainFragment.conjugationEllos = "salen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.conjugationYo = "conduzco";
                MainFragment.conjugationTu = "conduces";
                MainFragment.conjugationEl = "conduce";
                MainFragment.conjugationNos = "conducimos";
                MainFragment.conjugationOs = "conducís";
                MainFragment.conjugationEllos = "conducen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("jugar")) {
                MainFragment.conjugationYo = "juego";
                MainFragment.conjugationTu = "juegas";
                MainFragment.conjugationEl = "juega";
                MainFragment.conjugationNos = "jugamos";
                MainFragment.conjugationOs = "jugáis";
                MainFragment.conjugationEllos = "juegan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.conjugationYo = "puedo";
                MainFragment.conjugationTu = "puedes";
                MainFragment.conjugationEl = "puede";
                MainFragment.conjugationNos = "podemos";
                MainFragment.conjugationOs = "podéis";
                MainFragment.conjugationEllos = "pueden";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = "quiero";
                MainFragment.conjugationTu = "quieres";
                MainFragment.conjugationEl = "quiere";
                MainFragment.conjugationNos = "queremos";
                MainFragment.conjugationOs = "queréis";
                MainFragment.conjugationEllos = "quieren";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.conjugationYo = "tengo";
                MainFragment.conjugationTu = "tienes";
                MainFragment.conjugationEl = "tiene";
                MainFragment.conjugationNos = "tenemos";
                MainFragment.conjugationOs = "tenéis";
                MainFragment.conjugationEllos = "tienen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.conjugationYo = "digo";
                MainFragment.conjugationTu = "dices";
                MainFragment.conjugationEl = "dice";
                MainFragment.conjugationNos = "dicemos";
                MainFragment.conjugationOs = "decís";
                MainFragment.conjugationEllos = "dicen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.conjugationYo = "vengo";
                MainFragment.conjugationTu = "vienes";
                MainFragment.conjugationEl = "viene";
                MainFragment.conjugationNos = "venimos";
                MainFragment.conjugationOs = "venís";
                MainFragment.conjugationEllos = "vienen";
                MainFragment.setText();
            }
            // Preterite tense irregular verbs
        } else if (MainFragment.verbTense == 1) {
            // TODO irregular preterite tense verbs

            // Future tense irregular verbs
        } else if (MainFragment.verbTense == 3) {
            if (MainFragment.infinitive.equals("haber")) {
                MainFragment.infinitive = "habr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.infinitive = "podr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.infinitive = "querr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.infinitive = "sabr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.infinitive = "pondr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.infinitive = "saldr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.infinitive = "tendr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.infinitive = "vendr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.infinitive = "dir";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.infinitive = "har";
                MainFragment.conjugateVerbFuture();
            }
        }
    }
}
