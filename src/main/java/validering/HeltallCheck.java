package validering;

import java.util.regex.Pattern;

public class HeltallCheck {
    public static boolean heltallCheck(String tall){

        //Tillater kun 0-9
        Pattern pat = Pattern.compile("\\d+");
        if(tall == null) {
            return false;
        }
        return pat.matcher(tall).matches();
    }
}
