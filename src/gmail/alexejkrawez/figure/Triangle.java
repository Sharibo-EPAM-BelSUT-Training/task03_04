package gmail.alexejkrawez.figure;

import java.io.Serializable;
import java.util.Objects;

public abstract class Triangle extends Figure implements Serializable {
    private static final long serialVersionUID = 1;
    private double side_a;
    private double side_b;
    private double side_c;

    /**
     * Constructor of the triangle with sizes.
     *
     * @param side_a side A of triangle.
     * @param side_b side B of triangle.
     * @param side_c side C of triangle.
     */
    public Triangle(double side_a, double side_b, double side_c) {
        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;
        }

    /**
     * Constructor of the triangle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public Triangle(Figure figure) { //конструктор для вырезаний
        this.side_a = figure.getMinSize() / 2;
        this.side_b = figure.getMinSize() / 2;
        this.side_c = figure.getMinSize() / 2;
    }

    /**
     * Get the minimal size of triangle.
     *
     * @return the minimal size.
     */
    @Override
    public double getMinSize() {
        return Math.min(Math.min(side_a, side_b), side_c);
    }

    /**
     * Get perimeter of triangle.
     *
     * @return perimeter of triangle.
     */
    public double getPerimeter() {
        return side_a + side_b + side_c;
    }

    /**
     * Get area of triangle.
     *
     * @return area of triangle.
     */
    @Override
    public double getArea() {
        double half_per = (side_a + side_b + side_c) / 2;
        return Math.sqrt(half_per * (half_per-side_a) *(half_per-side_b) * (half_per-side_c));
    }

    /**
     * Compare object membership of class triangle.
     *
     * @param o the object.
     * @return true, when object belong to class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side_a, side_a) == 0 &&
                Double.compare(triangle.side_b, side_b) == 0 &&
                Double.compare(triangle.side_c, side_c) == 0;
    }

    /**
     * Get hash code of the object with accounting of sizes.
     *
     * @return object hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(side_a, side_b, side_c);
    }

    /**
     * Overrides toString() method.
     *
     * @return simple name with sizes of triangle.
     */
    @Override
    public String toString() {
        return super.toString() +
                ": side_a = " + side_a +
                ", side_b = " + side_b +
                ", side_c = " + side_c;
    }
}