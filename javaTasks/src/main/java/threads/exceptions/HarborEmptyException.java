package threads.exceptions;

public class HarborEmptyException extends Exception {
    public HarborEmptyException() {
    }

    public HarborEmptyException(String message) {
        super(message);
    }

    public HarborEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public HarborEmptyException(Throwable cause) {
        super(cause);
    }
}
