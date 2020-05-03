package filbehandling.Parse;

import models.komponent.*;

import java.io.IOException;

public class ParseKomponenterGammel {
    private static String feilHeltall = "kan ikke formateres som ett heltall.";
    private static String feilDesimaltall = "kan ikke formateres som ett desimaltall.";
    private static String feilBoolean = "kan ikke formateres som true eller false";

    public static Komponent parseKomponent(String linje) throws IOException {
        String[] split = linje.split(";");
        Komponent komponent;

        if(split[0].equals("Prosessor")){
            return parseProsessor(linje);
        }
        if(split[0].equals("Skjermkort")){
            return parseSkjermkort(linje);
        }
        if(split[0].equals("Lagringsenhet")){
            return parseLagringsenhet(linje);
        }
        if(split[0].equals("Skjerm")){
            return parseSkjerm(linje);
        }
        if(split[0].equals("Mus")){
            return parseMus(linje);
        }
        if(split[0].equals("Tastatur")){
            return parseTastatur(linje);
        }
        //TODO fikse feilhåndtering
        //Eks: InvalidKomponentException("Finner ikke komponent med navn " + split[1])
        else throw new IOException();
    }

    private static Komponent parseKomponentSuper(String linje){
        String[] split = linje.split(";");
        //TODO validere at varenr, er på riktig format.
        String vareNr = split[1];
        String varemerke = split[2];
        String modell = split[3];
        double pris = ParseVariabler.parseDesimaltall(split[4], "Prisen " + feilDesimaltall);

        return new Komponent(vareNr, varemerke, modell, pris);
    }

    private static Prosessor parseProsessor(String linje){
        String[] split = linje.split(";");

        if(split.length != 7){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponentSuper(linje);
        int kjerner = ParseVariabler.parseHeltall(split[5], "Antall kjerner " + feilHeltall);
        double klokkehastighet = ParseVariabler.parseDesimaltall(split[6], "Klokkehastigheten " + feilDesimaltall);

        return new Prosessor(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                kjerner,
                klokkehastighet);
    }

    private static Skjermkort parseSkjermkort(String linje){
        String[] split = linje.split(";");

        if(split.length != 7){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponentSuper(linje);
        double klokkehastighet = ParseVariabler.parseDesimaltall(split[5], "Klokkehastigheten " + feilDesimaltall);
        int minne = ParseVariabler.parseHeltall(split[6], "Minne " + feilHeltall);

        return new Skjermkort(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                klokkehastighet,
                minne);
    }

    private static Lagringsenhet parseLagringsenhet(String linje){
        String[] split = linje.split(";");

        if(split.length != 9){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponentSuper(linje);
        String format = split[5];
        int gb = ParseVariabler.parseHeltall(split[6], "Antall gb " + feilHeltall);
        String leseHastighet = split[7];
        String skriveHastighet = split[8];

        return new Lagringsenhet(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                format,
                gb,
                leseHastighet,
                skriveHastighet);
    }

    private static Skjerm parseSkjerm(String linje) {
        String[] split = linje.split(";");

        if (split.length != 8) {
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponentSuper(linje);
        int pixelBredde = ParseVariabler.parseHeltall(split[5], "Pixelbredden " + feilHeltall);
        int pixelHoyde = ParseVariabler.parseHeltall(split[6], "Pixelhøyden " + feilHeltall);
        boolean min4k = ParseVariabler.parseBoolean(split[7], "Min4k " + feilBoolean);

        return new Skjerm(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                pixelBredde,
                pixelHoyde,
                min4k);
    }

    private static Mus parseMus(String linje){
        String[] split = linje.split(";");

        if(split.length != 7){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponentSuper(linje);
        boolean trodlos = ParseVariabler.parseBoolean(split[5], "Trådløs " + feilBoolean);
        String farge = split[6];

        return new Mus(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                trodlos,
                farge);
    }

    private static Tastatur parseTastatur(String linje){
        String[] split = linje.split(";");

        if(split.length != 7){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponentSuper(linje);
        boolean trodlos = ParseVariabler.parseBoolean(split[5], "Trådløs " + feilBoolean);
        boolean numpad = ParseVariabler.parseBoolean(split[6], "Numpad " + feilBoolean);
        return new Tastatur(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                trodlos,
                numpad);
    }
}


