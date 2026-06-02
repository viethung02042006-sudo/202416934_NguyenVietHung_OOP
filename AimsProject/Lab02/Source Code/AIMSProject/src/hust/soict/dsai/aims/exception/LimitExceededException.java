package hust.soict.dsai.aims.exception;

public class LimitExceededException extends Exception {
    public LimitExceededException(String message) {
        super(message);
    }

    public LimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
