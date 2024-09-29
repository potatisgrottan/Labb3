package se.kth.olof.beyar.labb3.delb.io;

import se.kth.olof.beyar.labb3.delb.model.Project;

import java.io.*;
import java.util.List;

/**
 * Hints on how to implement serialization and deserialization
 * of lists of projects and users.
 */
public class ProjectsFileIO {
    /**
     * Call this method before the application exits, to store the users and projects,
     * in serialized form.
     */
    public static void serializeToFile(File file, List<Project> data) throws IOException {
        // ...
        // and then, make sure the file always get closed
        try (
            FileOutputStream filename = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(filename)
        )
        {
            out.writeObject(data);
        }
    }

    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException
    {
        try (
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn)
        )
        {
            return (List<Project>) in.readObject();
        }
    }
}
