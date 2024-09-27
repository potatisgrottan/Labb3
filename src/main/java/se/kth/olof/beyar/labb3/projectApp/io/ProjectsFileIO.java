package se.kth.olof.beyar.labb3.projectApp.io;

import se.kth.olof.beyar.labb3.projectApp.model.Project;

import java.io.*;
import java.util.ArrayList;
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
        try {
            //TODO kommer förmodligen behöva ändras
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(Project project: data)
            {
                writer.write(project+"\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException {

        List<Project> data = new ArrayList<>();
        //TODO kommer behöva ändras så den läser title(string) description(string) och id(int)
        // och skapa "nya" objekt(project) för varje rad
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //while(reader.read()!=null ??
            //data.add(new Project(reader.read(),reader.read(),reader.read()));

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ProjectsFileIO() {}
}
