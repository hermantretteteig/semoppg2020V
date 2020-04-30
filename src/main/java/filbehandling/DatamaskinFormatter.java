package filbehandling;

import models.komponent.*;

public class DatamaskinFormatter {
    public static String DELIMITER = ";";

    public static String formaterDatamaskin(Datamaskin datamaskin){
        String ut = String.join(System.lineSeparator(),
                formaterLageringsenhet(datamaskin.getLagringsenhet()),
                formaterSkjerm(datamaskin.getSkjerm()),
                formaterMus(datamaskin.getMus()),
                formaterProsessor(datamaskin.getProsessor()),
                formaterSkjermkort(datamaskin.getSkjermkort()),
                formaterTastatur(datamaskin.getTastatur()));
        return ut;
    }

    private static String formaterKomponent(Komponent komponent){
        String ut = String.join(";",
                komponent.getClass().getSimpleName(),
                komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                String.valueOf(komponent.getPris()));
        return ut;
    }

    private static String formaterLageringsenhet(Lagringsenhet lagringsenhet){
        String ut = formaterKomponent(lagringsenhet) + ";";
        ut += String.join(";",
                lagringsenhet.getFormat(),
                String.valueOf(lagringsenhet.getGb()),
                lagringsenhet.getLeseHastighet(),
                lagringsenhet.getSkriveHastighet());
        return ut;
    }

    private static String formaterSkjerm(Skjerm skjerm) {
        String ut = formaterKomponent(skjerm) + ";";
        ut += String.join(";",
                String.valueOf(skjerm.getPixelBredde()),
                String.valueOf(skjerm.getPixelHoyde()),
                String.valueOf(skjerm.getMin4K()));
        return ut;
    }

    private static String formaterMus(Mus mus){
        String ut = formaterKomponent(mus) + ";";
        ut += String.join(";",
                String.valueOf(mus.getTrodlos()),
                mus.getFarge());
        return ut;
    }

    private static String formaterProsessor(Prosessor prosessor){
        String ut = formaterKomponent(prosessor) + ";";
        ut += String.join(";",
                String.valueOf(prosessor.getAntallKjerner()),
                String.valueOf(prosessor.getKlokkehastighet()));
        return ut;
    }

    private static String formaterSkjermkort(Skjermkort skjermkort){
        String ut = formaterKomponent(skjermkort) + ";";
        ut += String.join(";",
                String.valueOf(skjermkort.getKlokkehastighet()),
                String.valueOf(skjermkort.getMinne()));
        return ut;
    }

    private static String formaterTastatur(Tastatur tastatur){
        String ut = formaterKomponent(tastatur) + ";";
        ut += String.join(";",
                String.valueOf(tastatur.getTrodlos()),
                String.valueOf(tastatur.getNumpad()));
        return ut;
    }
}
