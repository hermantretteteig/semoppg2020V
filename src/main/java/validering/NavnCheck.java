package validering;

import java.util.regex.Pattern;

public class NavnCheck {
    public static boolean navncheck(String navn){

        //Tillater kun navn som inneholde store og små bokstaver
        String navnRegex = "^[a-zA-Z]+$";

        Pattern pat = Pattern.compile(navnRegex);

        if(navn == null) {
            return false;
        }
        return pat.matcher(navn).matches();
    }
}
