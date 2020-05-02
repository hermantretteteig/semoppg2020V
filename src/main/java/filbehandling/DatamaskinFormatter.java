package filbehandling;

import models.komponent.*;

public class DatamaskinFormatter {
    public static String DELIMITER = ";";

     static String formaterDatamaskin(Datamaskin datamaskin){
         return String.join(System.lineSeparator(),
                 formaterProsessor(datamaskin.getProsessor()),
                 formaterSkjermkort(datamaskin.getSkjermkort()),
                 formaterLageringsenhet(datamaskin.getLagringsenhet()),
                 formaterSkjerm(datamaskin.getSkjerm()),
                 formaterMus(datamaskin.getMus()),
                 formaterTastatur(datamaskin.getTastatur()));
    }

    private static String formaterKomponent(Komponent komponent){
        return String.join(";",
                komponent.getClass().getSimpleName(),
                komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                String.valueOf(komponent.getPris()));
    }

    private static String formaterLageringsenhet(Lagringsenhet lagringsenhet){
        return formaterKomponent(lagringsenhet) + ";" + String.join(";",
                lagringsenhet.getFormat(),
                String.valueOf(lagringsenhet.getGb()),
                lagringsenhet.getLeseHastighet(),
                lagringsenhet.getSkriveHastighet());
    }

    private static String formaterSkjerm(Skjerm skjerm) {
        return formaterKomponent(skjerm) + ";" + String.join(";",
                String.valueOf(skjerm.getPixelBredde()),
                String.valueOf(skjerm.getPixelHoyde()),
                String.valueOf(skjerm.getMin4K()));
    }

    private static String formaterMus(Mus mus){
        return formaterKomponent(mus) + ";" + String.join(";",
                String.valueOf(mus.getTrodlos()),
                mus.getFarge());
    }

    private static String formaterProsessor(Prosessor prosessor){
        return formaterKomponent(prosessor) + ";" + String.join(";",
                String.valueOf(prosessor.getAntallKjerner()),
                String.valueOf(prosessor.getKlokkehastighet()));
    }

    private static String formaterSkjermkort(Skjermkort skjermkort){
        return formaterKomponent(skjermkort) + ";" + String.join(";",
                String.valueOf(skjermkort.getKlokkehastighet()),
                String.valueOf(skjermkort.getMinne()));
    }

    private static String formaterTastatur(Tastatur tastatur){
        return formaterKomponent(tastatur) + ";" + String.join(";",
                String.valueOf(tastatur.getTrodlos()),
                String.valueOf(tastatur.getNumpad()));
    }
}
