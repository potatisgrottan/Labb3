package se.kth.olof.beyar.labb3.projectApp.io;

import se.kth.olof.beyar.labb3.projectApp.model.Project;

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
        FileOutputStream filename = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(filename);
        out.writeObject(data);
        out.close();
    }

    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException
    {
        FileInputStream fileIn = null;
        ObjectInputStream in = null;

        try {
            fileIn = new FileInputStream(file);
            in = new ObjectInputStream(fileIn);
            return (List<Project>) in.readObject();
        }
        finally {
            if (in != null)
                in.close();

            if (fileIn != null)
                fileIn.close();
        }
    }
}
