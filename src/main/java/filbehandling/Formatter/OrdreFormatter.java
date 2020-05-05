package filbehandling.Formatter;

import models.kjop.Ordre;

import java.util.ArrayList;

import static filbehandling.Formatter.DatamaskinFormatter.formaterDatamaskin;

public class OrdreFormatter {
    private static final String ordreHead = String.join(";","Ordrenummer", "Kjopsdato", "Kundenummer", "Totalsum");
    private static final String komponentHead = String.join(";", "Komponent", "Varenummer", "Varemerke", "Modell", "Pris");
    private static final String prosessorHead = String.join(";", komponentHead, "Kjerner", "Klokkehastiget");
    private static final String skjermkortHead = String.join(";", komponentHead,"Klokkehastigher", "Minne");
    private static final String lagringsenhetHead = String.join(";", komponentHead, "Format", "Antall GB", "Lesehastighet", "Skrivehastighet");
    private static final String skjermHead = String.join(";", komponentHead, "Pixelbredde", "Pixelhoyde", "4k");
    private static final String musHead = String.join(";", komponentHead, "Traadlos", "Farge");
    private static final String tastaturHead = String.join(";", komponentHead,"Traadlos", "Numpad");

    private static final String head = String.join(";", ordreHead, prosessorHead, skjermkortHead, lagringsenhetHead, skjermHead, musHead, tastaturHead);

    public static String formaterOrdre(ArrayList<Ordre> ordreListe){
        StringBuilder ut = new StringBuilder(head + "\n");

        for(Ordre ordre : ordreListe){
            ut.append(String.join(";",
                    ordre.getOrdrenumer(),
                    ordre.getKjopsdato(),
                    ordre.getKundenr(),
                    String.valueOf(ordre.getTotalsum()),
                    formaterDatamaskin(ordre.getDatamaskin()) + "\n"
            ));

        }
        return ut.toString();
    }

    public static String formaterOrdre2(Ordre ordre){
        StringBuilder ut = new StringBuilder();

            ut.append(String.join(";",
                    ordre.getOrdrenumer(),
                    ordre.getKjopsdato(),
                    ordre.getKundenr(),
                    String.valueOf(ordre.getTotalsum()),
                    formaterDatamaskin(ordre.getDatamaskin()) + "\n"));
        return ut.toString();
    }

}
