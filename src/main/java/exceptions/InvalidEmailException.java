package exceptions;

//TODO sikkert fjerne.
public class InvalidEmailException extends Exception {
    public InvalidEmailException(String ut) {
        super(ut);
    }
}
