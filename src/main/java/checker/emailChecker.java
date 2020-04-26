package checker;

import java.util.regex.Pattern;

public class emailChecker {
    public static boolean emailchecker(String email) {

        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pat = Pattern.compile(emailRegex);

        if(email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }
}
