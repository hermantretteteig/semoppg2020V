package validering;

import java.util.regex.Pattern;

public class BokstaverCheck {
    public static boolean bokstavercheck(String navn){

        //Tillater kun input som inneholde store og små bokstaver
        String navnRegex = "^[a-zA-Z]+$";

        Pattern pat = Pattern.compile(navnRegex);

        if(navn == null) {
            return false;
        }
        return pat.matcher(navn).matches();
    }
}
