package filbehandling.Parse;

import models.kjop.Ordre;
import models.komponent.*;

public class ParseOrdre {
    private static final String feilHeltall = "kan ikke formateres som ett heltall.";
    private static final String feilDesimaltall = "kan ikke formateres som ett desimaltall.";
    private static final String feilBoolean = "kan ikke formateres som true eller false";

    public static Ordre parseOrdre(String linje){
        //Deler opp linjer i tekstfilen der hvor tekstfilen inneholder semikolon (";").
        String[] split = linje.split(";");

        //Hvis en linje ikke inneholder 49 splitter kastes en InvalidOrdreFormatException.
        if(split.length != 49){
            //TODO feilhåndtering
            //Eksempel: InvalidOrdreFormatException("Må bruke semicolon ; for å separere data.");
        }
        //Organiserer arrayet for å skrives til objekt.
        String ordrenummer = split[0];
        String kjopsdato = split[1];
        String kundenr = split[2];
        Double totalsum = ParseVariabler.parseDesimaltall(split[3], feilDesimaltall);
        //Legger til verdiene fra split arrayet i nytt Ordre objekt.
        return new Ordre(ordrenummer, kjopsdato, kundenr, totalsum, parseDatamaskin(linje));
    }


    private static Datamaskin parseDatamaskin(String linje){
        return new Datamaskin(
                parseProsessor(linje),
                parseSkjermkort(linje),
                parseLagringsenhet(linje),
                parseSkjerm(linje),
                parseMus(linje),
                parseTastatur(linje)
        );
    }

    //Formatterer data fra tekstfil til komponent sin superklasse.
    private static Komponent parseKomponentSuper(String linje, int i, int j, int k, int l){
        String[] split = linje.split(";");
        //TODO validere at varenr, er på riktig format.
        String vareNr = split[i];
        String varemerke = split[j];
        String modell = split[k];
        double pris = ParseVariabler.parseDesimaltall(split[l], "Prisen " + feilDesimaltall);

        return new Komponent(vareNr, varemerke, modell, pris);
    }

    //Formatterer data fra tekstfil til prosessor.
    private static Prosessor parseProsessor(String linje){
        String[] split = linje.split(";");

        Komponent komponent = parseKomponentSuper(linje, 5, 6, 7, 8);
        int kjerner = ParseVariabler.parseHeltall(split[9], "Antall kjerner " + feilHeltall);
        double klokkehastighet = ParseVariabler.parseDesimaltall(split[10], "Klokkehastigheten " + feilDesimaltall);

        return new Prosessor(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                kjerner,
                klokkehastighet);
    }
    //Formatterer data fra tekstfil til skjermkort.
    private static Skjermkort parseSkjermkort(String linje){
        String[] split = linje.split(";");

        Komponent komponent = parseKomponentSuper(linje, 12, 13 , 14, 15);
        double klokkehastighet = ParseVariabler.parseDesimaltall(split[16], "Klokkehastigheten " + feilDesimaltall);
        int minne = ParseVariabler.parseHeltall(split[17], "Minne " + feilHeltall);

        return new Skjermkort(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                klokkehastighet,
                minne);
    }
    //Formatterer data fra tekstfil til lagringsenhet.
    private static Lagringsenhet parseLagringsenhet(String linje){
            String[] split = linje.split(";");

        Komponent komponent = parseKomponentSuper(linje, 19, 20, 21, 22);
        String format = split[23];
        int gb = ParseVariabler.parseHeltall(split[24], "Antall gb " + feilHeltall);
        String leseHastighet = split[25];
        String skriveHastighet = split[26];

        return new Lagringsenhet(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                format,
                gb,
                leseHastighet,
                skriveHastighet);
    }

    //Formatterer data fra tekstfil til skjerm.
    private static Skjerm parseSkjerm(String linje) {
        String[] split = linje.split(";");

        Komponent komponent = parseKomponentSuper(linje, 28, 29, 30, 31);
        int pixelBredde = ParseVariabler.parseHeltall(split[32], "Pixelbredden " + feilHeltall);
        int pixelHoyde = ParseVariabler.parseHeltall(split[33], "Pixelhøyden " + feilHeltall);
        boolean min4k = ParseVariabler.parseBoolean(split[34], "Min4k " + feilBoolean);

        return new Skjerm(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                pixelBredde,
                pixelHoyde,
                min4k);
    }

    //Formatterer data fra tekstfil til mus.
    private static Mus parseMus(String linje){
        String[] split = linje.split(";");

        Komponent komponent = parseKomponentSuper(linje, 36, 37, 38, 39);
        boolean trodlos = ParseVariabler.parseBoolean(split[40], "Trådløs " + feilBoolean);
        String farge = split[41];

        return new Mus(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                trodlos,
                farge);
    }

    //Formatterer data fra tekstfil til tastatur.
    private static Tastatur parseTastatur(String linje){
        String[] split = linje.split(";");

        Komponent komponent = parseKomponentSuper(linje, 43, 44, 45, 46);
        boolean trodlos = ParseVariabler.parseBoolean(split[47], "Trådløs " + feilBoolean);
        boolean numpad = ParseVariabler.parseBoolean(split[48], "Numpad " + feilBoolean);
        return new Tastatur(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                trodlos,
                numpad);
    }
}


