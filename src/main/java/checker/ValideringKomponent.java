package checker;

import java.util.regex.Pattern;

public class ValideringKomponent {
    public static boolean vareNr(String varenr){
        if(varenr.length() <= 6) {
            return false;
        }
        else{
            return true;
    }
}
}
