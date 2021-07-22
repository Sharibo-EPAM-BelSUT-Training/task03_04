package gmail.alexejkrawez;

/**
 * @name Java.SE.03-04
 * @package gmail.alexejkrawez;
 * @file Girl.java
 * @author Alexej Krawez
 * @email AlexejKrawez@gmail.com
 * @created 28.12.2018
 * @updated 17.07.2021
 * @version 1.1
 * */

import gmail.alexejkrawez.box.Box;
import gmail.alexejkrawez.exceptions.BoxAlreadyContainsShapeException;
import gmail.alexejkrawez.exceptions.BoxIncorrectArgumentException;
import gmail.alexejkrawez.exceptions.WriteReadException;
import gmail.alexejkrawez.film.FilmCircle;
import gmail.alexejkrawez.film.FilmRectangle;
import gmail.alexejkrawez.film.FilmTriangle;
import gmail.alexejkrawez.paper.PaperCircle;
import gmail.alexejkrawez.paper.PaperRectangle;
import gmail.alexejkrawez.paper.PaperTriangle;
import gmail.alexejkrawez.serialisation.Connector;

import static gmail.alexejkrawez.paper.Paper.Color.*;

public class Girl {

    public static void main(String[] args) {
        Box box = new Box();

        PaperRectangle pr1 = new PaperRectangle(12, 15);
        System.out.println(pr1);
        PaperTriangle pt1 = new PaperTriangle(11, 12, 13);
        System.out.println(pt1);
        PaperTriangle pt2 = new PaperTriangle(10, 11, 12);
        System.out.println(pt2);
        PaperCircle pc1 = new PaperCircle(24);
        System.out.println(pc1);

        FilmRectangle fr1 = new FilmRectangle(12, 15);
        System.out.println(fr1);
        FilmRectangle fr2 = new FilmRectangle(16, 18);
        System.out.println(fr2);
        FilmTriangle ft1 = new FilmTriangle(12, 13, 14);
        System.out.println(ft1);
        FilmCircle fc1 = new FilmCircle(6);
        System.out.println(fc1);
        FilmCircle fc2 = new FilmCircle(8);
        System.out.println(fc2);

        System.out.println("Cutting a film circle from a film triangle (side_a = 12, side_b = 13, side_c = 14):");
        FilmCircle fc3 = new FilmCircle(ft1);
        System.out.println(fc3);

        System.out.println("Cutting a paper circle from a paper circle (radius = 24, color = GREEN):");
        pc1.setColor(GREEN);
        PaperCircle pc2 = new PaperCircle(pc1);
        System.out.println(pc2);

        pr1.setColor(RED);
        System.out.println(pr1);
        System.out.println(pr1.getColor());

        pt1.setColor(BLUE);
        System.out.println(pt1);

        pt1.setColor(BLACK);
        System.out.println("Attempting to repaint the paper triangle in black:");
        System.out.println(pt1);

        box.addShape(pr1);
        box.addShape(fr1);
        box.addShape(pt1);
        box.addShape(pc2);
        box.addShape(fc3);
        box.addShape(pt2);
        box.addShape(fr2);

        try {
            System.out.println("\n1. Receiving by number:");
            System.out.println(box.getByNumber(1));
        } catch (BoxIncorrectArgumentException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("\n2. Extraction by number:");
            System.out.println(box.extractByNumber(2));
        } catch (BoxIncorrectArgumentException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("\n3. Substitution by number:");
            System.out.println("Before the replacement: " + box.replaceByNumber(3, fc2));
            System.out.println("After the replacement: " + box.getByNumber(3));
        } catch (BoxIncorrectArgumentException | BoxAlreadyContainsShapeException e) {
            e.printStackTrace();
        }


        System.out.println("\n4. Search shape by number:");
        PaperRectangle pr2 = new PaperRectangle(12, 15);
        pr2.setColor(RED);
        System.out.println(box.findEquivalent(pr2));

        System.out.println("\n5. Print shapes that are available:");
        System.out.println(box.toString());

        System.out.println("\n6. Print the total area of the shapes:");
        System.out.println(box.sumArea());

        System.out.println("\n7. Print the total perimeter of the shapes:");
        System.out.println(box.sumPerimeter());

        System.out.println("\n8. Getting all the circles out of the box:");
        box.removeAllCircles();
        System.out.println(box.toString());

        System.out.println("\n9. Getting all the film shapes out of the box:");
        box.removeAllFilmShapes();
        System.out.println(box.toString());




        //Serialization:
        System.out.println("\n==============================================\n");

        System.out.println("Box: " + box.toString());
        try {
            Connector.writeBox("BoxOut", box);
        } catch (WriteReadException e) {
            e.printStackTrace();
        }


        Box box2 = new Box();
        try {
            box2 = Connector.readBox("BoxOut", box);
        } catch (WriteReadException e) {
            e.printStackTrace();
        }

        System.out.println("Box2: " + box2.toString());


        //Exception situation:
        try {
            System.out.println("\n1. Receiving by number:");
            Thread.sleep(1000); // Иначе происходит шайтан.
            System.out.println(box.getByNumber(-5));

        } catch (InterruptedException | BoxIncorrectArgumentException e) {
            e.printStackTrace();
        }

    }
}
