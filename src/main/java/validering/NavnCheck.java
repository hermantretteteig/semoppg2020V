package validering;

import java.util.regex.Pattern;

public class NavnCheck {
    public boolean navnchecker(String navn){

        //Tillater kun navn som inneholde store og små bokstaver
        String navnRegex = "^[æøåa-zÆØÅA-Z]+$";

        Pattern pat = Pattern.compile(navnRegex);

        if(navn == null) {
            return false;
        }
        return pat.matcher(navn).matches();
    }
}
