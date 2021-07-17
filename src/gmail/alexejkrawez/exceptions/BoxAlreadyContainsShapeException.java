package gmail.alexejkrawez.exceptions;

public class BoxAlreadyContainsShapeException extends Exception {

    /**
     * Constructor of the personal BoxAlreadyContainsShapeException without parameters.
     * Exception for cases when there are already shapes in the box .
     */
    public BoxAlreadyContainsShapeException() {
        super();
    }

    /**
     * Constructor of the personal BoxIncorrectArgumentException with message-parameter.
     * Exception for cases when there are already shapes in the box .
     *
     * @param message string for a description of exception.
     */
    public BoxAlreadyContainsShapeException(String message) {
        super(message);
    }

}
