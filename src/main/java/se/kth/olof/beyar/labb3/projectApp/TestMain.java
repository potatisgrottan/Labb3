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
            System.out.println("Testing ProjectsManager and Project:");
            Project project1 = manager.addProject("Project 1", "First project");
            Project project2 = manager.addProject("Project 2", "Second project");

            System.out.println("Projects created: " + manager.getProjects().size());

            // Testa skapandet av Task och management
            System.out.println("\nTesting Task creation and management:");
            Task task1 = project1.addTask("Task 1", TaskPrio.HIGH);
            Task task2 = project1.addTask("Task 2", TaskPrio.MEDIUM);
            Task task3 = project1.addTask("Task 3", TaskPrio.LOW);

            System.out.println("Tasks in Project 1: " + project1.getTasks().size());

            // Testa task uppdatering
            task1.setTakenBy("Alice");
            task2.setState(TaskState.IN_PROGRESS);
            task3.setPrio(TaskPrio.HIGH);

            // Testa matchers
            System.out.println("\nTesting Matchers:");
            ITaskMatcher prioMatcher = new PrioMatcher(TaskPrio.HIGH);
            List<Task> highPrioTasks = project1.findTasks(prioMatcher);
            System.out.println("High priority tasks: " + highPrioTasks.size());

            ITaskMatcher takenByMatcher = new TakenByMatcher("Alice");
            List<Task> aliceTasks = project1.findTasks(takenByMatcher);
            System.out.println("Tasks taken by Alice: " + aliceTasks.size());

            ITaskMatcher notDoneMatcher = new NotDoneMatcher();
            List<Task> notDoneTasks = project1.findTasks(notDoneMatcher);
            System.out.println("Not done tasks: " + notDoneTasks.size());

            // Testa projekt state
            System.out.println("\nTesting Project State:");
            System.out.println("Project 1 state: " + project1.getState());
            System.out.println("Project 2 state: " + project2.getState());

            // Testa serialization och deserialization
            System.out.println("\nTesting Serialization and Deserialization:");
            File testFile = new File("test_projects.ser");
            ProjectsFileIO.serializeToFile(testFile, manager.getProjects());
            System.out.println("Projects serialized to file.");

            List<Project> loadedProjects = ProjectsFileIO.deSerializeFromFile(testFile);
            System.out.println("Projects deserialized from file. Loaded projects: " + loadedProjects.size());

            // Ta bort test fil
            testFile.delete();

            System.out.println("\nAll tests completed successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred during testing:");
            e.printStackTrace();
        }
    }
}