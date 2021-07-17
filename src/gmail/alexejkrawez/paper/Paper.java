package gmail.alexejkrawez.paper;

import java.io.Serializable;
import java.util.Objects;

public interface Paper {

    /**
     * Color list.
     */
    enum Color {
        WHITE, BLACK, RED, GREEN, BLUE, YELLOW
    }

    /**
     * Get access to color from enum.
     *
     * @return color from enum.
     */
    Color getColor();

    /**
     * Set color from enum.
     *
     * @param color color from enum.
     */
    void setColor(Color color);


    class Painted implements Serializable {
        private static final long serialVersionUID = 1;

        private transient Color paintedColor;

        /**
         * Get object color.
         *
         * @return object color.
         */
        public Color getColor() {
            return paintedColor;
        }

        /**
         * Set color to object.
         *
         * @param color color which painted object.
         */
        public void setColor(Color color) {
            if (this.paintedColor == null) {
                this.paintedColor = color;
            }
        }

        /**
         * Compare object membership of class Painted.
         *
         * @param o the object.
         * @return true, when object belong to class.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Painted)) return false;
            Painted painted = (Painted) o;
            return paintedColor == painted.paintedColor;
        }

        /**
         * Get hash code of the object.
         *
         * @return object hash code.
         */
        @Override
        public int hashCode() {
            return Objects.hash(paintedColor);
        }
    }
}