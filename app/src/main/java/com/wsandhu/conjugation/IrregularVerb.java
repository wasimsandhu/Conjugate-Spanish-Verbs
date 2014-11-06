package com.wsandhu.conjugation;

/**
 * Created by wasimsandhu on 9/28/14.
 */
public class IrregularVerb {

    public static void conjugate() {

        // Present tense irregular verbs
        if (MainFragment.verbTense == 0) {
            // Irregular yo endings
            if (MainFragment.isIrregularYoVerb) {
                conjugateIrregularYoVerb();
            }

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

                MainFragment.conjugationTu = "conoces";
                MainFragment.conjugationEl = "conoce";
                MainFragment.conjugationNos = "conocemos";
                MainFragment.conjugationOs = "conocéis";
                MainFragment.conjugationEllos = "conocen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {

                MainFragment.conjugationTu = "haces";
                MainFragment.conjugationEl = "hace";
                MainFragment.conjugationNos = "hacemos";
                MainFragment.conjugationOs = "hacéis";
                MainFragment.conjugationEllos = "hacen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {

                MainFragment.conjugationTu = "traes";
                MainFragment.conjugationEl = "trae";
                MainFragment.conjugationNos = "traemos";
                MainFragment.conjugationOs = "traéis";
                MainFragment.conjugationEllos = "traen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {

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

                MainFragment.conjugationTu = "sales";
                MainFragment.conjugationEl = "sale";
                MainFragment.conjugationNos = "salemos";
                MainFragment.conjugationOs = "salís";
                MainFragment.conjugationEllos = "salen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {

                MainFragment.conjugationTu = "conduces";
                MainFragment.conjugationEl = "conduce";
                MainFragment.conjugationNos = "conducimos";
                MainFragment.conjugationOs = "conducís";
                MainFragment.conjugationEllos = "conducen";
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

                MainFragment.conjugationTu = "tienes";
                MainFragment.conjugationEl = "tiene";
                MainFragment.conjugationNos = "tenemos";
                MainFragment.conjugationOs = "tenéis";
                MainFragment.conjugationEllos = "tienen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {

                MainFragment.conjugationTu = "dices";
                MainFragment.conjugationEl = "dice";
                MainFragment.conjugationNos = "dicemos";
                MainFragment.conjugationOs = "decís";
                MainFragment.conjugationEllos = "dicen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {

                MainFragment.conjugationTu = "vienes";
                MainFragment.conjugationEl = "viene";
                MainFragment.conjugationNos = "venimos";
                MainFragment.conjugationOs = "venís";
                MainFragment.conjugationEllos = "vienen";
                MainFragment.setText();
            }
            // Preterite tense irregular verbs
        } else if (MainFragment.verbTense == 1) {
            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "fui";
                MainFragment.conjugationTu = "fuiste";
                MainFragment.conjugationEl = "fue";
                MainFragment.conjugationNos = "fuimos";
                MainFragment.conjugationOs = "fuisteis";
                MainFragment.conjugationEllos = "fueron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "fui";
                MainFragment.conjugationTu = "fuiste";
                MainFragment.conjugationEl = "fue";
                MainFragment.conjugationNos = "fuimos";
                MainFragment.conjugationOs = "fuisteis";
                MainFragment.conjugationEllos = "fueron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.conjugationYo = "estuve";
                MainFragment.conjugationTu = "estuviste";
                MainFragment.conjugationEl = "estuvo";
                MainFragment.conjugationNos = "estuvimos";
                MainFragment.conjugationOs = "estuvisteis";
                MainFragment.conjugationEllos = "estuvieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.conjugationYo = "di";
                MainFragment.conjugationTu = "diste";
                MainFragment.conjugationEl = "dio";
                MainFragment.conjugationNos = "dimos";
                MainFragment.conjugationOs = "disteis";
                MainFragment.conjugationEllos = "dieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.conjugationYo = "supe";
                MainFragment.conjugationTu = "supiste";
                MainFragment.conjugationEl = "supo";
                MainFragment.conjugationNos = "supimos";
                MainFragment.conjugationOs = "supisteis";
                MainFragment.conjugationEllos = "supieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conocer")) {
                MainFragment.conjugationYo = "conocí";
                MainFragment.conjugationTu = "conociste";
                MainFragment.conjugationEl = "conoció";
                MainFragment.conjugationNos = "conocimos";
                MainFragment.conjugationOs = "conocisteis";
                MainFragment.conjugationEllos = "conocieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.conjugationYo = "hice";
                MainFragment.conjugationTu = "hiciste";
                MainFragment.conjugationEl = "hizo";
                MainFragment.conjugationNos = "hicimos";
                MainFragment.conjugationOs = "hicisteis";
                MainFragment.conjugationEllos = "hicieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {
                MainFragment.conjugationYo = "traje";
                MainFragment.conjugationTu = "trajiste";
                MainFragment.conjugationEl = "trajo";
                MainFragment.conjugationNos = "trajimos";
                MainFragment.conjugationOs = "trajisteis";
                MainFragment.conjugationEllos = "trajeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.conjugationYo = "puse";
                MainFragment.conjugationTu = "pusiste";
                MainFragment.conjugationEl = "puso";
                MainFragment.conjugationNos = "pusimos";
                MainFragment.conjugationOs = "pusisteis";
                MainFragment.conjugationEllos = "pusieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "ví";
                MainFragment.conjugationTu = "viste";
                MainFragment.conjugationEl = "vió";
                MainFragment.conjugationNos = "vimos";
                MainFragment.conjugationOs = "visteis";
                MainFragment.conjugationEllos = "vieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.conjugationYo = "salí";
                MainFragment.conjugationTu = "saliste";
                MainFragment.conjugationEl = "salió";
                MainFragment.conjugationNos = "salimos";
                MainFragment.conjugationOs = "salisteis";
                MainFragment.conjugationEllos = "salieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.conjugationYo = "conduje";
                MainFragment.conjugationTu = "condujiste";
                MainFragment.conjugationEl = "condujo";
                MainFragment.conjugationNos = "condujimos";
                MainFragment.conjugationOs = "condujisteis";
                MainFragment.conjugationEllos = "condujeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("jugar")) {
                MainFragment.conjugationYo = "jugué";
                MainFragment.conjugationTu = "jugiste";
                MainFragment.conjugationEl = "jugó";
                MainFragment.conjugationNos = "jugamos";
                MainFragment.conjugationOs = "jugasteis";
                MainFragment.conjugationEllos = "jugaron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("haber")) {
                MainFragment.conjugationYo = "hube";
                MainFragment.conjugationTu = "hubiste";
                MainFragment.conjugationEl = "hubo";
                MainFragment.conjugationNos = "hubimos";
                MainFragment.conjugationOs = "hubisteis";
                MainFragment.conjugationEllos = "hubieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.conjugationYo = "pude";
                MainFragment.conjugationTu = "pudiste";
                MainFragment.conjugationEl = "pudo";
                MainFragment.conjugationNos = "pudimos";
                MainFragment.conjugationOs = "pudisteis";
                MainFragment.conjugationEllos = "pudieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = "quise";
                MainFragment.conjugationTu = "quisiste";
                MainFragment.conjugationEl = "quiso";
                MainFragment.conjugationNos = "quisimos";
                MainFragment.conjugationOs = "quisisteis";
                MainFragment.conjugationEllos = "quisieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.conjugationYo = "tuve";
                MainFragment.conjugationTu = "tuviste";
                MainFragment.conjugationEl = "tuvo";
                MainFragment.conjugationNos = "tuvimos";
                MainFragment.conjugationOs = "tuvisteis";
                MainFragment.conjugationEllos = "tuvieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.conjugationYo = "vine";
                MainFragment.conjugationTu = "viniste";
                MainFragment.conjugationEl = "vino";
                MainFragment.conjugationNos = "vinimos";
                MainFragment.conjugationOs = "visteis";
                MainFragment.conjugationEllos = "vinieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.conjugationYo = "dije";
                MainFragment.conjugationTu = "dijiste";
                MainFragment.conjugationEl = "dijo";
                MainFragment.conjugationNos = "dijimos";
                MainFragment.conjugationOs = "dijisteis";
                MainFragment.conjugationEllos = "dijeron";
                MainFragment.setText();
            }
            // Imperfect tense irregular verbs
        } else if (MainFragment.verbTense == 2) {
            boolean notIrregularInImperfect = !MainFragment.infinitive.equals("ir")
                                                && !MainFragment.infinitive.equals("ser")
                                                && !MainFragment.infinitive.equals("ver");

            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "iba";
                MainFragment.conjugationTu = "ibas";
                MainFragment.conjugationEl = "iba";
                MainFragment.conjugationNos = "íbamos";
                MainFragment.conjugationOs = "ibais";
                MainFragment.conjugationEllos = "iban";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "era";
                MainFragment.conjugationTu = "eras";
                MainFragment.conjugationEl = "era";
                MainFragment.conjugationNos = "éramos";
                MainFragment.conjugationOs = "erais";
                MainFragment.conjugationEllos = "eran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "veía";
                MainFragment.conjugationTu = "veías";
                MainFragment.conjugationEl = "veía";
                MainFragment.conjugationNos = "veíamos";
                MainFragment.conjugationOs = "veíais";
                MainFragment.conjugationEllos = "veían";
                MainFragment.setText();
            } else if (MainFragment.isEndingAr && notIrregularInImperfect) {
                MainFragment.conjugateArVerbImperfect();
            } else if (notIrregularInImperfect && MainFragment.isEndingEr) {
                MainFragment.conjugateErIrVerbImperfect();
            } else if (notIrregularInImperfect && MainFragment.isEndingIr) {
                MainFragment.conjugateErIrVerbImperfect();
            }
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
            } // Affirmative commands
        } else if (MainFragment.verbTense == 4) {
            if (MainFragment.infinitive.equals("decir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "di";
                MainFragment.conjugationEl = "diga";
                MainFragment.conjugationNos = "digamos";
                MainFragment.conjugationEllos = "digan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "haz";
                MainFragment.conjugationEl = "haga";
                MainFragment.conjugationNos = "hagamos";
                MainFragment.conjugationEllos = "hagan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ve";
                MainFragment.conjugationEl = "vaya";
                MainFragment.conjugationNos = "vayamos";
                MainFragment.conjugationEllos = "vayan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "pon";
                MainFragment.conjugationEl = "ponga";
                MainFragment.conjugationNos = "pongamos";
                MainFragment.conjugationEllos = "pongan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "sal";
                MainFragment.conjugationEl = "salga";
                MainFragment.conjugationNos = "salgamos";
                MainFragment.conjugationEllos = "salgan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "sé";
                MainFragment.conjugationEl = "sea";
                MainFragment.conjugationNos = "seamos";
                MainFragment.conjugationEllos = "sean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ten";
                MainFragment.conjugationEl = "tenga";
                MainFragment.conjugationNos = "tengamos";
                MainFragment.conjugationEllos = "tengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ve";
                MainFragment.conjugationEl = "venga";
                MainFragment.conjugationNos = "vengamos";
                MainFragment.conjugationEllos = "vengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("jugar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "juega";
                MainFragment.conjugationEl = "juege";
                MainFragment.conjugationNos = "jueguemos";
                MainFragment.conjugationEllos = "juegen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "quiere";
                MainFragment.conjugationEl = "quiera";
                MainFragment.conjugationNos = "quieramos";
                MainFragment.conjugationEllos = "quieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "conduce";
                MainFragment.conjugationEl = "conduzca";
                MainFragment.conjugationNos = "conduzcamos";
                MainFragment.conjugationEllos = "conduzcan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "está";
                MainFragment.conjugationEl = "esté";
                MainFragment.conjugationNos = "estemos";
                MainFragment.conjugationEllos = "estén";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "da";
                MainFragment.conjugationEl = "dé";
                MainFragment.conjugationNos = "demos";
                MainFragment.conjugationEllos = "den";
                MainFragment.setText();
            }
            // Negative commands
        } else if (MainFragment.verbTense == 5) {
            if (MainFragment.infinitive.equals("decir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no digas";
                MainFragment.conjugationEl = "no diga";
                MainFragment.conjugationNos = "no digamos";
                MainFragment.conjugationEllos = "no digan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no haz";
                MainFragment.conjugationEl = "no haga";
                MainFragment.conjugationNos = "no hagamos";
                MainFragment.conjugationEllos = "no hagan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no vayas";
                MainFragment.conjugationEl = "no vaya";
                MainFragment.conjugationNos = "no vayamos";
                MainFragment.conjugationEllos = "no vayan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no pongas";
                MainFragment.conjugationEl = "no ponga";
                MainFragment.conjugationNos = "no pongamos";
                MainFragment.conjugationEllos = "no pongan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no salgas";
                MainFragment.conjugationEl = "no salga";
                MainFragment.conjugationNos = "no salgamos";
                MainFragment.conjugationEllos = "no salgan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no seas";
                MainFragment.conjugationEl = "no sea";
                MainFragment.conjugationNos = "no seamos";
                MainFragment.conjugationEllos = "no sean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no tengas";
                MainFragment.conjugationEl = "no tenga";
                MainFragment.conjugationNos = "no tengamos";
                MainFragment.conjugationEllos = "no tengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no vengas";
                MainFragment.conjugationEl = "no venga";
                MainFragment.conjugationNos = "no vengamos";
                MainFragment.conjugationEllos = "no vengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("jugar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no jueges";
                MainFragment.conjugationEl = "no juege";
                MainFragment.conjugationNos = "no jueguemos";
                MainFragment.conjugationEllos = "no juegen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no quieras";
                MainFragment.conjugationEl = "no quiera";
                MainFragment.conjugationNos = "no quieramos";
                MainFragment.conjugationEllos = "no quieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no conduczas";
                MainFragment.conjugationEl = "no conduzca";
                MainFragment.conjugationNos = "no conduzcamos";
                MainFragment.conjugationEllos = "no conduzcan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no estés";
                MainFragment.conjugationEl = "no esté";
                MainFragment.conjugationNos = "no estemos";
                MainFragment.conjugationEllos = "no estén";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no des";
                MainFragment.conjugationEl = "no dé";
                MainFragment.conjugationNos = "no demos";
                MainFragment.conjugationEllos = "no den";
                MainFragment.setText();
            }
        }
    }

    public static void conjugateIrregularYoVerb() {
        if (MainFragment.infinitive.equals("hacer")) {
            MainFragment.conjugationYo = "hago";
        } else if (MainFragment.infinitive.equals("oír")) {
            MainFragment.conjugationYo = "oigo";
        } else if (MainFragment.infinitive.equals("traer")) {
            MainFragment.conjugationYo = "traigo";
        } else if (MainFragment.infinitive.equals("caer")) {
            MainFragment.conjugationYo = "caigo";
        } else if (MainFragment.infinitive.equals("decir")) {
            MainFragment.conjugationYo = "digo";
        } else if (MainFragment.infinitive.equals("conducir")) {
            MainFragment.conjugationYo = "conduzco";
        } else if (MainFragment.infinitive.equals("conocer")) {
            MainFragment.conjugationYo = "conozco";
        } else if (MainFragment.isEndingEr) {
            MainFragment.conjugationYo = MainFragment.infinitive.replace("er", "go");
        } else if (MainFragment.isEndingIr) {
            MainFragment.conjugationYo = MainFragment.infinitive.replace("ir", "go");
        }
    }
}
