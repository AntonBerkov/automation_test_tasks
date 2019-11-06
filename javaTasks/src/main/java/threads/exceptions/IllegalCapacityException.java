package threads.exceptions;

public class IllegalCapacityException extends Exception {
    public IllegalCapacityException() {
    }

    public IllegalCapacityException(String message) {
        super(message);
    }

    public IllegalCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalCapacityException(Throwable cause) {
        super(cause);
    }
}
