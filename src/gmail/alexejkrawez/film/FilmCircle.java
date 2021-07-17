package gmail.alexejkrawez.film;

import gmail.alexejkrawez.figure.Circle;
import gmail.alexejkrawez.figure.Figure;

import java.io.Serializable;

public class FilmCircle extends Circle implements Film, Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Constructor of the film circle which radius.
     *
     * @param radius radius of film circle.
     */
    public FilmCircle(double radius) {
        super(radius);
    }

    /**
     * Constructor of the film circle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public FilmCircle(Film figure) {
        super((Figure) figure);
    }
}
