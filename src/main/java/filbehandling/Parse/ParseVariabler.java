package filbehandling.Parse;


//TODO feilhåndtering
public class ParseVariabler {

    public static int parseHeltall(String tall, String feilmelding){
        int heltall = 0; //Fjern "=0" når feilhåndtering er på plass.
        try {
            heltall = Integer.parseInt(tall);
        }
        catch (NumberFormatException e){
            //eks: Throw InvalidKomponentFormatException(Feilmelding);
        }
        return heltall;
    }

    public static double parseDesimaltall(String tall, String feilmelding){
        double desimalTall = 0; //Fjern "=0" når feilhåndtering er på plass.
        try{
            desimalTall = Double.parseDouble(tall);
        }
        catch (NumberFormatException e){
            //eks: Throw InvalidKomponentFormatException(Feilmelding);
        }
        return desimalTall;
    }

    public static boolean parseBoolean(String string, String feilmelding){
        boolean bol = false;
        try {
            bol = Boolean.parseBoolean(string);
        }
        catch (IllegalArgumentException e){
            //Throw InvalidKomponentFormatException(Feilmelding);
        }
        return bol;
    }
}
