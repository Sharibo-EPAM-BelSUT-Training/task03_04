package gmail.alexejkrawez.paper;

import gmail.alexejkrawez.figure.Figure;
import gmail.alexejkrawez.figure.Rectangle;

import java.io.Serializable;
import java.util.Objects;

public class PaperRectangle extends Rectangle implements Paper, Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Create object which save color of rectangle.
     */
    private Painted painted = new Painted();

    /**
     * Constructor of the paper rectangle with sizes.
     *
     * @param width width of paper rectangle.
     * @param height height of paper rectangle.
     */
    public PaperRectangle(double width, double height) {
        super(width, height);
    }

    /**
     * Constructor of the paper rectangle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public PaperRectangle(Paper figure) {
        super((Figure) figure);
    }

    /**
     * Get rectangle color which belong to enum.
     *
     * @return rectangle color.
     */
    @Override
    public Color getColor() {
        return painted.getColor();
    }

    /**
     * Set color which belong to enum to paper rectangle.
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
        PaperRectangle that = (PaperRectangle) o;
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
     * @return simple name with sizes and color of rectangle.
     */
    @Override
    public String toString() {
        return super.toString() + ", painted = " + painted.getColor();
    }
}
