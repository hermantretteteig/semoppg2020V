package filbehandling.Parse;

import models.komponent.*;

public class ParseKomponenter {
    private String feilHeltall = "kan ikke formateres som ett heltall.";
    private String feilDesimaltall = "kan ikke formateres som ett desimaltall.";
    private String feilBoolean = "kan ikke formateres som true eller false";

    private Komponent parseKomponent(String linje){
        String[] split = linje.split(";");

        String vareNr = split[0];
        String varemerke = split[1];
        String modell = split[2];
        double pris = ParseVariabler.parseDesimaltall(split[3], "Prisen " + feilDesimaltall);

        return new Komponent(vareNr, varemerke, modell, pris);
    }

    public Prosessor parseProsessor(String linje){
        String[] split = linje.split(";");

        if(split.length != 6){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponent(linje);
        int kjerner = ParseVariabler.parseHeltall(split[4], "Antall kjerner " + feilHeltall);
        double klokkehastighet = ParseVariabler.parseDesimaltall(split[5], "Klokkehastigheten " + feilDesimaltall);

        return new Prosessor(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                kjerner,
                klokkehastighet);
    }

    public Skjermkort parseSkjermkort(String linje){
        String[] split = linje.split(";");

        if(split.length != 6){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponent(linje);
        double klokkehastighet = ParseVariabler.parseDesimaltall(split[4], "Klokkehastigheten " + feilDesimaltall);
        int minne = ParseVariabler.parseHeltall(split[5], "Minne " + feilHeltall);

        return new Skjermkort(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                klokkehastighet,
                minne);
    }

    public Lagringsenhet parseLagringsenhet(String linje){
        String[] split = linje.split(";");

        if(split.length != 8){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponent(linje);
        String format = split[4];
        int gb = ParseVariabler.parseHeltall(split[5], "Antall gb " + feilHeltall);
        String leseHastighet = split[6];
        String skriveHastighet = split[6];

        return new Lagringsenhet(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                format,
                gb,
                leseHastighet,
                skriveHastighet);
    }

    public Skjerm parseSkjerm(String linje) {
        String[] split = linje.split(";");

        if (split.length != 7) {
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponent(linje);
        int pixelBredde = ParseVariabler.parseHeltall(split[4], "Pixelbredden " + feilHeltall);
        int pixelHoyde = ParseVariabler.parseHeltall(split[5], "Pixelhøyden " + feilHeltall);
        boolean min4k = ParseVariabler.parseBoolean(split[6], "Min4k " + feilBoolean);

        return new Skjerm(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                pixelBredde,
                pixelHoyde,
                min4k);
    }

    public Mus parseMus(String linje){
        String[] split = linje.split(";");

        if(split.length != 6){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponent(linje);
        boolean trodlos = ParseVariabler.parseBoolean(split[4], "Trådløs " + feilBoolean);
        String farge = split[5];

        return new Mus(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                trodlos,
                farge);
    }

    public Tastatur parseTastatur(String linje){
        String[] split = linje.split(";");

        if(split.length != 6){
            //TODO feilhåndtering
            //eks: throw new InvalidKomponentFormatException("Må bruke semicolon ; for å separere data.")
        }
        Komponent komponent = parseKomponent(linje);
        boolean trodlos = ParseVariabler.parseBoolean(split[4], "Trådløs " + feilBoolean);
        boolean numpad = ParseVariabler.parseBoolean(split[5], "Numpad " + feilBoolean);
        return new Tastatur(komponent.getVarenr(),
                komponent.getVaremerke(),
                komponent.getModell(),
                komponent.getPris(),
                trodlos,
                numpad);
    }
}


