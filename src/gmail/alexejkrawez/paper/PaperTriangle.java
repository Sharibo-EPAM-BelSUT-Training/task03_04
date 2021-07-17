package gmail.alexejkrawez.paper;

import gmail.alexejkrawez.figure.Figure;
import gmail.alexejkrawez.figure.Triangle;

import java.io.Serializable;
import java.util.Objects;

public class PaperTriangle extends Triangle implements Paper, Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Create object which save color of triangle.
     */
    private Painted painted = new Painted();

    /**
     * Constructor of the paper triangle with sizes.
     *
     * @param side_a side A of paper triangle.
     * @param side_b side B of paper triangle.
     * @param side_c side C of paper triangle.
     */
    public PaperTriangle(double side_a, double side_b, double side_c) {
        super(side_a, side_b, side_c);
    }

    /**
     * Constructor of the paper triangle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public PaperTriangle(Paper figure) {
        super((Figure) figure);
    }

    /**
     * Get triangle color which belong to enum.
     *
     * @return triangle color.
     */
    @Override
    public Color getColor() {
        return painted.getColor();
    }

    /**
     * Set color which belong to enum to paper triangle.
     *
     * @param color color from enum.
     */
    @Override
    public void setColor(Color color) {
        painted.setColor(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PaperTriangle that = (PaperTriangle) o;
        return Objects.equals(painted, that.painted);
    }

    /**
     * Get hash code of the object with accounting of sizes and color.
     *
     * @return object hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), painted);
    }

    /**
     * Overrides toString() method.
     *
     * @return simple name with sizes and color of triangle.
     */
    @Override
    public String toString() {
        return super.toString() + ", painted = " + painted.getColor();
    }
}
