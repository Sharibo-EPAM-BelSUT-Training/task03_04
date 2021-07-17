package gmail.alexejkrawez.paper;

import gmail.alexejkrawez.figure.Figure;
import gmail.alexejkrawez.figure.Circle;

import java.io.Serializable;
import java.util.Objects;

public class PaperCircle extends Circle implements Paper, Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Create object which save color of circle.
     */
    private Painted painted = new Painted();

    /**
     * Constructor of the paper circle which radius.
     *
     * @param radius radius of paper circle.
     */
    public PaperCircle(double radius) {
        super(radius);
    }

    /**
     * Constructor of the paper circle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public PaperCircle(Paper figure) {
        super((Figure) figure);
    }

    /**
     * Get circle color which belong to enum.
     *
     * @return circle color.
     */
    @Override
    public Color getColor() {
        return painted.getColor();
    }

    /**
     * Set color which belong to enum to paper circle.
     *
     * @param color color from enum.
     */
    @Override
    public void setColor(Color color) {
        painted.setColor(color);
    }

    /**
     * Compare object membership of class paper circle.
     *
     * @param o the object.
     * @return true, when object belong to class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PaperCircle that = (PaperCircle) o;
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
     * @return simple name with radius and color of circle.
     */
    @Override
    public String toString() {
        return super.toString() + ", painted = " + painted.getColor();
    }
}
