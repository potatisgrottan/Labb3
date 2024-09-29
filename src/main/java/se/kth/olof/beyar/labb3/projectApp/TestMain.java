package se.kth.olof.beyar.labb3.projectApp;

import se.kth.olof.beyar.labb3.projectApp.model.*;
import se.kth.olof.beyar.labb3.projectApp.io.ProjectsFileIO;
import se.kth.olof.beyar.labb3.projectApp.model.matchers.*;

import java.io.File;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        try {
            ProjectsManager manager = new ProjectsManager();

            // Tesat ProjectsManager och Project
            System.out.println("Testar ProjectsManager och Project, skapar två projekt:");
            Project project1 = manager.addProject("Min projekt ett", "Min första projekt");
            Project project2 = manager.addProject("Min projekt två", "Min andra projekt");

            System.out.println("Skapade projects: " + manager.getProjects().size());

            // Testa skapandet av Task och management
            System.out.println("\nTestar skapa Task och uppdatera värden i project 1:");
            Task task1 = project1.addTask("Task 1", TaskPrio.HIGH);
            Task task2 = project1.addTask("Task 2", TaskPrio.MEDIUM);
            Task task3 = project1.addTask("Task 3", TaskPrio.LOW);
            System.out.println("Tasks i Project 1: " + project1.getTasks().size());

            // Testa task uppdatering
            task1.setTakenBy("Alice");
            task2.setState(TaskState.IN_PROGRESS);
            task3.setPrio(TaskPrio.HIGH);

            // Testa matchers
            System.out.println("\nTestar Matchers:");
            ITaskMatcher prioMatcher = new PrioMatcher(TaskPrio.HIGH);
            List<Task> highPrioTasks = project1.findTasks(prioMatcher);
            System.out.println("Hög prioritet tasks: " + highPrioTasks.size());

            ITaskMatcher takenByMatcher = new TakenByMatcher("Alice");
            List<Task> aliceTasks = project1.findTasks(takenByMatcher);
            System.out.println("Tasks tagen av Alice: " + aliceTasks.size());

            ITaskMatcher notDoneMatcher = new NotDoneMatcher();
            List<Task> notDoneTasks = project1.findTasks(notDoneMatcher);
            System.out.println("Not done tasks: " + notDoneTasks.size());

            // Testa projekt state
            System.out.println("\nTestar Project State:");
            System.out.println("Project 1 state: " + project1.getState());
            System.out.println("Project 2 state: " + project2.getState());

            // Testa serialization och deserialization
            System.out.println("\nTestar serialisering och deserialisering:");
            File testFile = new File("test_projects.ser");
            ProjectsFileIO.serializeToFile(testFile, manager.getProjects());
            System.out.println("Projekten serialiserad till fil.");

            List<Project> loadedProjects = ProjectsFileIO.deSerializeFromFile(testFile);
            System.out.println("Projekten deserialiserad från fil. Laddade in projekt: " + loadedProjects.size());

            // Ta bort test fil
            testFile.delete();

            System.out.println("\nAll alla tester gick igenom successivt!");
        } catch (Exception e) {
            System.out.println("Ett fel uppstod:");
            e.printStackTrace();
        }
    }
}