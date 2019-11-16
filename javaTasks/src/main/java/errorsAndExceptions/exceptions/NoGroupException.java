package errorsAndExceptions.exceptions;

public class NoGroupException extends Exception {

    public NoGroupException() {
    }

    public NoGroupException(String message) {
        super(message);
    }

    public NoGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupException(Throwable cause) {
        super(cause);
    }
}
