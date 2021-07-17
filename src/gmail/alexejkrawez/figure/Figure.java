package gmail.alexejkrawez.figure;

import java.io.Serializable;

public abstract class Figure implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * Get perimeter of shape.
     *
     * @return perimeter of shape.
     */
    public abstract double getPerimeter();

    /**
     * Get area of shape.
     *
     * @return area of shape.
     */
    public abstract double getArea();

    /**
     * Get the minimal size of shape.
     *
     * @return the minimal size.
     */
    public abstract double getMinSize();

    /**
     * Get the simple name of class.
     *
     * @return the simple name of class.
     */
    @Override
    public String toString() {
        return "\n" + this.getClass().getSimpleName();
    }

    /**
     * Compare object membership of class.
     *
     * @param o the object.
     * @return true, when object belong to class.
     */
    @Override
    public boolean equals(Object o) {
        return getClass() == o.getClass();
    }
}
