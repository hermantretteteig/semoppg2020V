package validering;

public class PassordValCheck {
    public static boolean passordValCheck(String passord1, String passord2){
        if(!passord1.equals(passord2)) {
            return false;
        }
        else{
            return true;
        }
    }
}
