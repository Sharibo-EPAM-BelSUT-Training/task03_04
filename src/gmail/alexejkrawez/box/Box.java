package gmail.alexejkrawez.box;

import gmail.alexejkrawez.exceptions.BoxAlreadyContainsShapeException;
import gmail.alexejkrawez.exceptions.BoxIncorrectArgumentException;
import gmail.alexejkrawez.figure.Circle;
import gmail.alexejkrawez.figure.Figure;
import gmail.alexejkrawez.film.Film;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box implements Serializable {
    private static final long serialVersionUID = 1;

    /**
     * Maximum quantity shapes in box.
     */
    private final int MAX_QUANTITY = 20;

    /**
     * Array of shapes.
     */
    private List<Figure> box = new ArrayList<>();

    public List<Figure> getBox() {
        return box;
    }

    /**
     * Adds a shape to the box.
     *
     * @param shape the shape that to be added to the box.
     * @return true if the shape doesn't exist.
     */
    public boolean addShape(Figure shape) {
        if (!box.contains(shape) && box.size() < MAX_QUANTITY) {
            box.add(shape);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get shape by number.
     *
     * @param number number of the shape.
     * @return the specific shape.
     * @throws BoxIncorrectArgumentException go outside the list.
     */
    public Figure getByNumber(int number) throws BoxIncorrectArgumentException {
        if (number < 1 || number > MAX_QUANTITY) {
            throw new BoxIncorrectArgumentException();
        } else {
            return box.get(number - 1);
        }
    }

    /**
     * Extract shape by number.
     *
     * @param number number of the shape.
     * @return removes the shape from the box and returns the specific shape.
     * @throws BoxIncorrectArgumentException go outside the list.
     */
    public Figure extractByNumber(int number) throws BoxIncorrectArgumentException {
        if (number < 1 || number > MAX_QUANTITY) {
            throw new BoxIncorrectArgumentException();
        } else {
            return box.remove(number - 1);
        }
    }

    /**
     * Replace shape by number.
     *
     * @param number number of the shape.
     * @param shape new shape.
     * @return old shape.
     * @throws BoxIncorrectArgumentException go outside the list.
     * @throws BoxAlreadyContainsShapeException box already contains specific shape.
     */
    public Figure replaceByNumber(int number, Figure shape)
            throws BoxIncorrectArgumentException, BoxAlreadyContainsShapeException {

        if (number < 1 || number > MAX_QUANTITY) {
            throw new BoxIncorrectArgumentException();
        }else if (box.contains(shape)) {
            throw new BoxAlreadyContainsShapeException("The shape is already in box!");
        } else {
            return box.set(number - 1, shape);
        }
    }

    /**
     * Find equivalent shape in box.
     *
     * @param shape shape, the equivalent of which is to be found in the box.
     * @return equivalent shape (if shape exist) else null.
     */
    public Figure findEquivalent(Figure shape) {
        for (Figure i : box) {
           if (i.equals(shape)) {
               return i;
           }
        }
        return null;
    }

    /**
     * Get total area of the shapes.
     *
     * @return sum area of shapes.
     */
    public double sumArea() {
        double sum = 0;
        for (Figure element : box) {
            sum += element.getArea();
        }
        return sum;
    }

    /**
     * Get total perimeter of the shapes.
     *
     * @return sum perimeter of shapes.
     */
    public double sumPerimeter() {
        double sum = 0;
        for (Figure element : box) {
            sum += element.getPerimeter();
        }
        return sum;
    }

    /**
     * Remove all circles from box.
     */
    public void removeAllCircles() {
        Iterator<Figure> iter = box.iterator();
        while (iter.hasNext()) {
            Figure shape = iter.next();
            if (shape instanceof Circle) {
                iter.remove();
            }
        }
    }

    /**
     * Remove all film shapes from box.
     */
    public void removeAllFilmShapes() {
        Iterator<Figure> iter = box.iterator();
        while (iter.hasNext()) {
            Figure shape = iter.next();
            if (shape instanceof Film) {
                iter.remove();
            }
        }
    }

    /**
     * Overrides toString() method.
     *
     * @return all shapes which are in the box.
     */
    @Override
    public String toString() {
        return "Box{" +
                "box=" + box +
                "}";
    }

}