package validering;

public class PassordValCheck {
    public static boolean passordValCheck(String passord1, String passord2){
        if(!passord2.equals(passord1)) {
            return false;
        }
        else{
            return true;
        }
    }

}
