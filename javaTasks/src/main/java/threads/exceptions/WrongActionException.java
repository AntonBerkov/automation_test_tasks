package threads.exceptions;

public class WrongActionException extends Exception {
    public WrongActionException() {
    }

    public WrongActionException(String message) {
        super(message);
    }

    public WrongActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongActionException(Throwable cause) {
        super(cause);
    }
}
