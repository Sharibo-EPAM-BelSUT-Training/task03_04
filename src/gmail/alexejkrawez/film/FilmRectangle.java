package gmail.alexejkrawez.film;

import gmail.alexejkrawez.figure.Figure;
import gmail.alexejkrawez.figure.Rectangle;

import java.io.Serializable;

public class FilmRectangle extends Rectangle implements Film, Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Constructor of the film rectangle with sizes.
     *
     * @param width width of film rectangle.
     * @param height height of film rectangle.
     */
    public FilmRectangle(double width, double height) {
        super(width, height);
    }

    /**
     * Constructor of the rectangle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public FilmRectangle(Film figure) {
        super((Figure) figure);
    }
}
