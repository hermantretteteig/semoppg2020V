package checker;

import java.util.regex.Pattern;

public class navnChecker {
    public boolean navnchecker(String navn){

        //Navn skal kun inenholde store og små bokstaver
        String navnRegex = "^[æøåa-zÆØÅA-Z]+$";

        Pattern pat = Pattern.compile(navnRegex);

        if(navn == null) {
            return false;
        }
        return pat.matcher(navn).matches();
    }
}
