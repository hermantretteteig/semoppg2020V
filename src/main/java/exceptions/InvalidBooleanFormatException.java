package exceptions;

public class InvalidBooleanFormatException extends IllegalArgumentException {
    public InvalidBooleanFormatException(String message) {
        super(message);
    }
}
