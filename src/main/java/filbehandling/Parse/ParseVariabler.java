package filbehandling.Parse;


import exceptions.InvalidBooleanFormatException;
import exceptions.InvalidNumberFormatException;


public class ParseVariabler {

    static int parseHeltall(String tall, String feilmelding) throws InvalidNumberFormatException {
        int heltall;
        try {
            heltall = Integer.parseInt(tall);
        }
        catch (NumberFormatException e){
            throw new InvalidNumberFormatException(feilmelding);
        }
        return heltall;
    }

    static double parseDesimaltall(String tall, String feilmelding) throws InvalidNumberFormatException {
        double desimalTall;
        try{
            desimalTall = Double.parseDouble(tall);
        }
        catch (NumberFormatException e){
            throw new InvalidNumberFormatException(feilmelding);
        }
        return desimalTall;
    }

    static boolean parseBoolean(String string, String feilmelding) throws InvalidBooleanFormatException {
        boolean bol;
            if(string.equals("true")){
                bol = true;
            }else if(string.equals("false")){
                bol = false;
            }else throw new InvalidBooleanFormatException(feilmelding);

        return bol;
    }
}
