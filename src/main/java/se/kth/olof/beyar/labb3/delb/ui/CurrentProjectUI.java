package se.kth.olof.beyar.labb3.delb.ui;

import se.kth.olof.beyar.labb3.delb.model.Project;
import se.kth.olof.beyar.labb3.delb.model.Task;
import se.kth.olof.beyar.labb3.delb.model.TaskPrio;
import se.kth.olof.beyar.labb3.delb.model.TaskState;
import se.kth.olof.beyar.labb3.delb.model.matchers.ITaskMatcher;
import se.kth.olof.beyar.labb3.delb.model.matchers.*;

import java.util.List;
import java.util.Scanner;

/**
 * User interactions for a specific project, current project.
 * The user selects actions on current project in the projectLoop method.
 */
class CurrentProjectUI {
    private Project currentProject;
    private final Scanner scan;

    // package private visibility - only visible to other classes in
    // package ui - intended for MainUI.
    CurrentProjectUI(Scanner scan) {
        this.scan = scan;
        this.currentProject = null; // TODO: Ugly!
    }

    void setCurrentProject(Project project) {
        this.currentProject = project;
        projectLoop();
    }

    Project getCurrentProject() {
        return currentProject;
    }

    void projectLoop() {
        char choice;
        do {
            printCurrentProjectMenu();
            choice = InputUtils.scanAndReturnFirstChar(scan);

            switch (choice) {
                case 'T':
                    System.out.print("Name? ");
                    String takenBy = scan.nextLine();
                    viewTasks(new TakenByMatcher(takenBy));
                    break;
                case 'N':
                    viewTasks(new NotDoneMatcher());
                    break;
                case 'H':
                    viewTasks(new PrioMatcher(TaskPrio.HIGH));
                    break;
                case 'A':
                    addTask();
                    break;
                case 'U':
                    updateTask();
                    break;
                case 'X':
                    break;
                case 'R':
                    removeTask();
                    break;
                default:
                    System.out.println("Unknown command");
            }

        } while (choice != 'X');
    }

    private void removeTask()
    {
        System.out.print("Task id? ");
        int id = scan.nextInt();
        scan.nextLine(); //remove "new line" from scanner buffer
        Task task = currentProject.getTaskById(id);

        if (task != null) {
            System.out.println(task);
            System.out.print("Are you sure? (Y)es (N)o ");
            char stateChar = InputUtils.scanAndReturnFirstChar(scan);

            if (stateChar == 'Y')
            {
                currentProject.removeTask(task);
            }
            else if(stateChar == ('N'))
            {
                // Do nothing
            }
            else
            {
                System.out.println("Unknown command.");
            }
        } else {
            System.out.println("Id not found.");
        }
    }

    private void viewTasks(ITaskMatcher matcher) {
        System.out.println(currentProject.toString());
        List<Task> tasks = currentProject.findTasks(matcher);
        printTasks(tasks);
    }

    private void addTask() {
        System.out.print("Description? ");
        String descr = scan.nextLine();
        System.out.print("Priority (L)ow, (M)edium, (H)igh? ");
        char prioChar = InputUtils.scanAndReturnFirstChar(scan);
        TaskPrio prio = prioChar == 'H' ? TaskPrio.HIGH : prioChar == 'L' ? TaskPrio.LOW : TaskPrio.MEDIUM;
        currentProject.addTask(descr, prio);
    }

    private void updateTask() {
        System.out.print("Task id? ");
        int id = scan.nextInt();
        scan.nextLine(); //remove "new line" from scanner buffer
        Task task = currentProject.getTaskById(id);
        if (task != null) {
            System.out.println(task);
            System.out.print("New state (T)odo (D)one? ");
            char stateChar = InputUtils.scanAndReturnFirstChar(scan);
            if (stateChar == 'T') {
                System.out.print("Taken by (name or email address)? ");
                String emailStr = scan.nextLine();
                task.setState(TaskState.TO_DO);
                task.setTakenBy(emailStr);
            }
            else if(stateChar == ('D')) {
                task.setState(TaskState.DONE);
            }
        } else {
            System.out.println("Id not found.");
        }
    }

    private void printCurrentProjectMenu() {
        System.out.println("--- Manage " + currentProject.getTitle() + " ---");
        System.out.println("T - list tasks taken by ...");
        System.out.println("N - list tasks not done");
        System.out.println("H - list high priority tasks");
        System.out.println("A - add task");
        System.out.println("U - update task");
        System.out.println("R - remove task");
        System.out.println("X - exit project menu");
        System.out.println("----------");
    }

    private void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added");
        } else {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }
}
