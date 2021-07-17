package gmail.alexejkrawez.serialisation;

import gmail.alexejkrawez.box.Box;
import gmail.alexejkrawez.exceptions.WriteReadException;

import java.io.*;

public class Connector {

    /**
     * Writing a serializable box to a file with a specific name.
     *
     * @param fileName name of the file to which the box will be written.
     * @param box the object to write to the file.
     * @throws WriteReadException personal exception to be shown when serialization failed.
     */
    public static void writeBox(String fileName, Box box) throws WriteReadException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(box);
        } catch (IOException e) {
            throw new WriteReadException("A read-write error has occurred", e);
        }
    }

    /**
     * Reading a serializable box from the file with a specific name.
     *
     * @param fileName name of the file from which the information will be read.
     * @param box the object to write information from the file.
     * @return return the box with information from file.
     * @throws WriteReadException personal exception to be shown when serialization failed.
     */
    public static Box readBox(String fileName, Box box) throws WriteReadException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BoxOut"))) {
            box = (Box) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new WriteReadException("A read-write error has occurred", e);
        }
        return box;
    }

}
