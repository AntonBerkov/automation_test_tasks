package threads.exceptions;

public class HarborFullException extends Exception {
    public HarborFullException() {
    }

    public HarborFullException(String message) {
        super(message);
    }

    public HarborFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public HarborFullException(Throwable cause) {
        super(cause);
    }
}
