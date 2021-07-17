package gmail.alexejkrawez.film;

import gmail.alexejkrawez.figure.Figure;
import gmail.alexejkrawez.figure.Triangle;

import java.io.Serializable;

public class FilmTriangle extends Triangle implements Film, Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Constructor of the film triangle with sizes.
     *
     * @param side_a side A of film triangle.
     * @param side_b side B of film triangle.
     * @param side_c side C of film triangle.
     */
    public FilmTriangle(double side_a, double side_b, double side_c) {
        super(side_a, side_b, side_c);
    }

    /**
     * Constructor of the triangle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public FilmTriangle(Film figure) {
        super((Figure) figure);
    }
}
