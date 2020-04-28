package validering;

public class ValiKomponent {
    public static boolean vareNr(String varenr){
        if(varenr.length() <= 6) {
            return false;
        }
        else{
            return true;
    }
}
}
