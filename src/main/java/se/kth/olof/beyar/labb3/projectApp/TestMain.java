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

            // Testa ProjectsManager och Project
            System.out.println("Testar ProjectsManager och Project:");
            Project project1 = manager.addProject("Projekt 1", "Första projektet");
            Project project2 = manager.addProject("Projekt 2", "Andra projektet");

            int projectCount = manager.getProjects().size();
            System.out.println("Antal skapade projekt: " + projectCount + " (Förväntat: 2)");

            // Testa söka efter projekt namn
            System.out.println("\nTestar söka efter 'projekt':");
            int searchResultCount = manager.findProjects("projekt").size();
            System.out.println("Sökte efter 'projekt', hittade: " + searchResultCount + " (Förväntad: 2)");

            // Testa Task-skapande och hantering
            System.out.println("\nTestar Task-skapande och hantering:");
            Task task1 = project1.addTask("Uppgift 1", TaskPrio.HIGH);
            Task task2 = project1.addTask("Uppgift 2", TaskPrio.MEDIUM);
            Task task3 = project1.addTask("Uppgift 3", TaskPrio.LOW);

            int taskCount = project1.getTasks().size();
            System.out.println("Antal uppgifter i Projekt 1: " + taskCount + " (Förväntat: 3)");

            // Testa uppdateringar av uppgifter
            task1.setTakenBy("Anna");
            task2.setState(TaskState.IN_PROGRESS);
            task3.setPrio(TaskPrio.HIGH);

            // Testa matchare
            System.out.println("\nTestar Matchare:");
            ITaskMatcher prioMatcher = new PrioMatcher(TaskPrio.HIGH);
            List<Task> highPrioTasks = project1.findTasks(prioMatcher);
            System.out.println("Antal högprioriterade uppgifter: " + highPrioTasks.size() + " (Förväntat: 2)");

            ITaskMatcher takenByMatcher = new TakenByMatcher("Anna");
            List<Task> annaTasks = project1.findTasks(takenByMatcher);
            System.out.println("Antal uppgifter tagna av Anna: " + annaTasks.size() + " (Förväntat: 1)");

            ITaskMatcher notDoneMatcher = new NotDoneMatcher();
            List<Task> notDoneTasks = project1.findTasks(notDoneMatcher);
            System.out.println("Antal ej klara uppgifter: " + notDoneTasks.size() + " (Förväntat: 3)");

            // Testa projekttillstånd
            System.out.println("\nTestar Projekttillstånd:");
            System.out.println("Tillstånd för Projekt 1: " + project1.getState() + " (Förväntat: ONGOING)");
            System.out.println("Tillstånd för Projekt 2: " + project2.getState() + " (Förväntat: EMPTY)");

            // Testa serialisering och deserialisering
            System.out.println("\nTestar Serialisering och Deserialisering:");
            File testFile = new File("test_projects.ser");
            ProjectsFileIO.serializeToFile(testFile, manager.getProjects());
            System.out.println("Projekt serialiserade till fil.");

            List<Project> loadedProjects = ProjectsFileIO.deSerializeFromFile(testFile);
            System.out.println("Antal deserialiserade projekt: " + loadedProjects.size() + " (Förväntat: 2)");

            //testFile.delete();
            testFile.deleteOnExit();
            System.out.println("\nAlla tester slutförda!");
        } catch (Exception e) {
            System.out.println("Ett fel uppstod: ");
            e.printStackTrace();
        }
    }
}