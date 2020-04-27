package checker;

import java.util.regex.Pattern;

public class tallChecker {
    public boolean tallchecker(String tall){

        //Tillater kun 0-9, og må være et norsk telefonnummer med 8 siffer
        Pattern pat = Pattern.compile("(0047|\\+47|47)?\\d{8}");
        if(tall == null) {
            return false;
        }
        return pat.matcher(tall).matches();
    }
}
