package gmail.alexejkrawez.exceptions;

public class BoxIncorrectArgumentException extends Exception {

    /**
     * Constructor of the personal BoxIncorrectArgumentException without parameters.
     * Designed to point to an invalid index when calling box methods.
     */
    public BoxIncorrectArgumentException() {
        super();
    }

    /**
     * Constructor of the personal BoxIncorrectArgumentException with message-parameter.
     * Designed to point to an invalid index when calling box methods.
     *
     * @param message string for a description of exception.
     */
    public BoxIncorrectArgumentException(String message) {
        super(message);
    }
}