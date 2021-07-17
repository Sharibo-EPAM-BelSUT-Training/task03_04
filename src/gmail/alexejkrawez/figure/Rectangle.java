package gmail.alexejkrawez.figure;

import java.io.Serializable;
import java.util.Objects;

public abstract class Rectangle extends Figure implements Serializable {
    private static final long serialVersionUID = 1;
    private double width;
    private double height;

    /**
     * Constructor of the rectangle with sizes.
     *
     * @param width width of rectangle.
     * @param height height of rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor of the rectangle which cut out from the shape.
     *
     * @param figure old shape from which cut out.
     */
    public Rectangle(Figure figure) { //конструктор для вырезаний
        this.width = figure.getMinSize() / 2;
        this.height = figure.getMinSize() / 2;
    }

    /**
     * Get the minimal size of rectangle.
     *
     * @return the minimal size.
     */
    @Override
    public double getMinSize() {
        return Math.min(width, height); //определяем меньшую сторону
    }

    /**
     * Get perimeter of rectangle.
     *
     * @return perimeter of rectangle.
     */
    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }

    /**
     * Get area of rectangle.
     *
     * @return area of rectangle.
     */
    @Override
    public double getArea() {
        return width*height;
    }

    /**
     * Compare object membership of class rectangle.
     *
     * @param o the object.
     * @return true, when object belong to class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    /**
     * Get hash code of the object with accounting of sizes.
     *
     * @return object hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    /**
     * Overrides toString() method.
     *
     * @return simple name with sizes of rectangle.
     */
    @Override
    public String toString() {
        return super.toString() +
                ": width = " + width +
                ", height = " + height;
    }
}