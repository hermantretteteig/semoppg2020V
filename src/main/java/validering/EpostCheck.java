package validering;

import java.util.regex.Pattern;

public class EpostCheck {
    public static boolean epostchecker(String epost) {

        //Tillater ikke norske bokstaver æ-ø-å

        String epostRegex = "^[æøåa-zÆØA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[^ æøåa-zÆØÅA-Z0-9.-]+$";

        Pattern pat = Pattern.compile(epostRegex);

        if (epost == null) {
            return false;
        }
        return pat.matcher(epost).matches();
    }

}