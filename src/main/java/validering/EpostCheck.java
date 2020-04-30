package validering;

import java.util.regex.Pattern;

public class EpostCheck {
    public static boolean epostchecker(String epost) {

        String epostRegex = "^\\S+@\\S+\\.\\S+$";

        Pattern pat = Pattern.compile(epostRegex);

        if (epost == null) {
            return false;
        }
        return pat.matcher(epost).matches();

    }

}