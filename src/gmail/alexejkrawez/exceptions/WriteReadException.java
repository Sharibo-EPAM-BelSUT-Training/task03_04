package gmail.alexejkrawez.exceptions;

public class WriteReadException extends Exception {

    /**
     * Constructor of the personal WriteReadException without parameters.
     * The exception is intended to indicate read-write exceptions.
     */
    public WriteReadException() {
        super();
    }

    /**
     * Constructor of the personal WriteReadException with parameters.
     * The exception is intended to indicate read-write exceptions.
     *
     * @param message string for a description of exception.
     * @param e cause of the exception.
     */
    public WriteReadException(String message, Exception e) {
        super(message, e);
    }

}
