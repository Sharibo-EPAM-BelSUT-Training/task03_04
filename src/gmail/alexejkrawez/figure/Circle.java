package gmail.alexejkrawez.figure;

import java.io.Serializable;
import java.util.Objects;

/**
 * Circle
 * */

public abstract class Circle extends Figure implements Serializable {
    private static final long serialVersionUID = 1;
    private double radius;

    /**
     * Constructor of the circle which radius.
     *
     * @param radius radius of circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor of the circle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public Circle(Figure figure) { //конструктор для вырезаний
        this.radius = figure.getMinSize() / 4;
    }

    /**
     * Get the minimal size of circle.
     *
     * @return the minimal size.
     */
    @Override
    public double getMinSize() {
        return radius * 2;
    }

    /**
     * Get perimeter of circle.
     *
     * @return perimeter of circle.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Get area of circle.
     *
     * @return area of circle.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Compare object membership of class circle.
     *
     * @param o the object.
     * @return true, when object belong to class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    /**
     * Get hash code of the object with accounting of radius.
     *
     * @return object hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    /**
     * Overrides toString() method.
     *
     * @return simple name with radius of circle.
     */
    @Override
    public String toString() {
        return super.toString() + ": radius = " + radius;
    }
}
