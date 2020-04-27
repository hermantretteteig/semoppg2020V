package avvikshandtering;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String ut) {
        super(ut);
    }
}
