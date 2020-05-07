package validering;

import java.util.regex.Pattern;

public class TallCheck {
    public static boolean tallcheck(String tall){

        //TODO denne sjekker også priser, det bør utvikles en egen for pris. Ettersom priser kan innehole desimaltall.
        //Tillater kun 0-9
        Pattern pat = Pattern.compile("\\d+");
        if(tall == null) {
            return false;
        }
        return pat.matcher(tall).matches();
    }
}
