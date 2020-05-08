package validering;

import java.util.regex.Pattern;

public class DesimaltallCheck {
    public static boolean desimaltallCheck(String tall){

        //Tillater alle desimaltall i formen 0-9.0-9
        Pattern pat = Pattern.compile("^[0-9]*\\.?[0-9]+$");
        if(tall == null) {
            return false;
        }
        return pat.matcher(tall).matches();
    }

}
