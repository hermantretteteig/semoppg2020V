package validering;

import data.AdminData;
import data.KundeData;
import models.brukere.Admin;
import models.brukere.Kunde;

import java.util.regex.Pattern;

public class Check {


    //Validerer bokstaver

    public static boolean bokstavercheck(String navn){

        //Tillater kun input som inneholde store og små bokstaver
        String navnRegex = "^[a-zA-Z]+$";

        Pattern pat = Pattern.compile(navnRegex);

        if(navn == null) {
            return false;
        }
        return pat.matcher(navn).matches();
    }

    //Validerer epost

    public static boolean epostchecker(String epost) {

        String epostRegex = "^\\S+@\\S+\\.\\S+$";

        Pattern pat = Pattern.compile(epostRegex);

        if (epost == null) {
            return false;
        }
        return pat.matcher(epost).matches();

    }

    //Validerer lengde

    public static boolean lengdeCheck(String lengde) {
        if(lengde.length() < 2) {
            return false;
        }
        return true;
    }

    //Validerer heltall

    public static boolean heltallCheck(String tall){

        //Tillater kun 0-9
        Pattern pat = Pattern.compile("\\d+");
        if(tall == null) {
            return false;
        }
        return pat.matcher(tall).matches();
    }

    //Validerer desimaltall

    public static boolean desimaltallCheck(String tall){

        //Tillater alle desimaltall i formen 0-9.0-9
        Pattern pat = Pattern.compile("^[0-9]*\\.?[0-9]+$");
        if(tall == null) {
            return false;
        }
        return pat.matcher(tall).matches();
    }

    //Validerer passord

    public static boolean passordchecker(String passord) {
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

    //Bekrefter passord

    public static boolean passordValCheck(String passord1, String passord2){
        if(!passord2.equals(passord1)) {
            return false;
        }
        else{
            return true;
        }
    }

    //Metode som kontrollerer at brukernavn ikke finnes fra før
    public static boolean brukernavnLedig(String brukernavn){
        for(Kunde eksiBrukernavn : KundeData.getKunder()){
            if(brukernavn.equals(eksiBrukernavn.getBrukernavn())){
                return false;
            }
        }
        return true;
    }

    //Metode som kontrollerer at brukernavn ikke finnes fra før
    public static boolean adminbrukernavnLedig(String brukernavn){
        for(Admin eksiBrukernavn : AdminData.getAdmins()){
            if(brukernavn.equals(eksiBrukernavn.getBrukernavn())){
                return false;
            }
        }
        return true;
    }


}