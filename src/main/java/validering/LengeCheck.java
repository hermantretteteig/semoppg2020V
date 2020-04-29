package validering;

public class LengeCheck {
    public static boolean lengdeCheck(String lengde) {
        if(lengde.length() < 2) {
            return false;
        }
        return true;
    }
}
