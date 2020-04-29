package validering;

import java.util.regex.Pattern;

public class PassordCheck {
    public boolean passordchecker(String passord) {
        //Må inneholde minst et tall fra 0-9
        //Må inneholde minst en liten bokstaver fra a-å
        //Må inneholde minst en stor bokstav fra a-å
        //Det er ikke tillatt med mellomrom
        //Lengden på passorden må være minst 8 tegn
        String passordRegex = "(?=.*[0-9])(?=.*[æøåa-z])(?=.*[ÆØÅA-Z])(?=\\S+$).{8,}";

        Pattern pat = Pattern.compile(passordRegex);

        if(passord == null){
            return false;
        }
        return pat.matcher(passord).matches();
    }
}
