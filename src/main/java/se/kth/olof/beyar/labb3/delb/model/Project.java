package se.kth.olof.beyar.labb3.delb.model;

import se.kth.olof.beyar.labb3.delb.model.matchers.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project implements Comparable<Project>, Serializable {
    private final String title;
    private final int id;
    private final String description;
    private LocalDate created;
    private int nextTaskId;
    private final ArrayList<Task> tasks;

    /**
     * Constructs a new project
     *
     * @param title The title of the project
     * @param description The description of the project
     * @param id The id for the project
     */
    Project(String title, String description, int id) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.created = LocalDate.now();
        this.nextTaskId = 0;
        this.tasks = new ArrayList<>();
    }

    /**
     * Retrieves a task based on its ID
     *
     * @param id The ID of the task to retrieve
     * @return The Task object with the specified ID
     * @throws IllegalArgumentException if the ID is out of bound
     */
    public Task getTaskById(int id) throws IllegalArgumentException{
        if (id > nextTaskId || id < 0 )
            throw new IllegalArgumentException("ID is out of bound");

        return tasks.get(id);
    }

    /**
     * Finds tasks that match the given criteria
     *
     * @param matcher The matcher used to filter tasks
     * @return A sorted list of tasks that match the criteria
     */
    public List<Task> findTasks(ITaskMatcher matcher) {
        ArrayList<Task> matchedTasks = new ArrayList<>();

        for (Task task : tasks)
            if (matcher.match(task))
                matchedTasks.add(task);

        // Task implementerar Comparable så vi kan används Collections.sort vilket kallar på compareTo() metoden
        Collections.sort(matchedTasks);

        return matchedTasks;
    }

    /**
     * Adds a new task to the project
     *
     * @param description The description of the new task
     * @param prio The priority of the new task
     * @return The newly created Task object
     */
    public Task addTask(String description, TaskPrio prio) {
        Task newTask = new Task(description, prio, nextTaskId);
        tasks.add(newTask);
        created = LocalDate.now();
        nextTaskId++;

        return newTask;
    }

    /**
     * Removes a task from the project
     *
     * @param task The task to be removed
     * @return true if the task was successfully removed, false otherwise
     */
    public boolean removeTask(Task task) {
        created = LocalDate.now();
        nextTaskId--;
        return tasks.remove(task);
    }

    /**
     * Determines the current state of the project
     *
     * @return The ProjectState representing the current state of the project
     */
    public ProjectState getState() {
        if (tasks.isEmpty())
            return ProjectState.EMPTY;

        for (Task task : tasks)
            if (task.getState() != TaskState.DONE)
                return ProjectState.ONGOING;

        return ProjectState.COMPLETED;
    }

    /**
     * Retrieves the date of the last update to any task in the project
     *
     * @return The LocalDate of the most recent task update or project creation date if no tasks exist
     */
    public LocalDate getLastUpdated(){
        if (tasks.isEmpty())
            return created;

        LocalDate closestDate = created;
        for (Task task : tasks)
        {
            if (task.getLastUpdate().isAfter(closestDate))
                closestDate = task.getLastUpdate();
        }

        return closestDate;
    }

    /**
     * Gets the title of the project
     *
     * @return The title of the project
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the ID of the project
     *
     * @return The unique identifier of the project
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gets a copy of the list of tasks in the project
     *
     * @return An ArrayList containing all tasks in the project
     */
    public ArrayList<Task> getTasks()
    {
        return new ArrayList<>(tasks);
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other) return true;

        if (!(other instanceof Project project))
            return false;

        return title.equals(project.title);
    }

    /**
     * Compares this project to another project based on their titles
     *
     * @param other The project to compare to.
     * @return A negative integer, zero, or a positive integer as this project is less than, equal to, or greater than the specified project
     */
    public int compareTo(Project other){
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Project {" +
                "title: '" + title + '\'' +
                ", description: '" + description + '\'' +
                ", id: " + id +
                '}';
    }
}
