package se.kth.olof.beyar.labb3.delb.model;

import se.kth.olof.beyar.labb3.delb.model.matchers.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Olof and Beyar
 * This class represents the logic and data of a project
 */

public class Project implements Comparable<Project>, Serializable {
    private final String title;
    private final int id;
    private final String description;
    private LocalDate created;
    private int nextTaskId;
    private final ArrayList<Task> tasks;

    /** Constructs a new project*/
    Project(String title, String description, int id) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.created = LocalDate.now();
        this.nextTaskId = 0;
        this.tasks = new ArrayList<>();
    }

    /** Returns a task based on id */
    public Task getTaskById(int id) throws IllegalArgumentException{
        if (id > nextTaskId || id < 0 )
            throw new IllegalArgumentException("ID is out of bound");

        return tasks.get(id);
    }

    /** Returns a list containing task matching the search requirement*/
    public List<Task> findTasks(ITaskMatcher matcher) {
        ArrayList<Task> matchedTasks = new ArrayList<>();

        for (Task task : tasks)
            if (matcher.match(task))
                matchedTasks.add(task);

        // Task implementerar Comparable så vi kan används Collections.sort
        // vilket kallar på compareTo() metoden
        Collections.sort(matchedTasks);

        return matchedTasks;
    }

    /** Adds a new task to the project */
    public Task addTask(String description, TaskPrio prio) {
        Task newTask = new Task(description, prio, nextTaskId);
        tasks.add(newTask);
        created = LocalDate.now();
        nextTaskId++;

        return newTask;
    }

    /** Removes a task from the project */
    public boolean removeTask(Task task) {
        created = LocalDate.now();
        return tasks.remove(task);
    }

    /**  Returns the state of the project */
    public ProjectState getState() {
        if (tasks.isEmpty())
            return ProjectState.EMPTY;

        for (Task task : tasks)
            if (task.getState() != TaskState.DONE)
                return ProjectState.ONGOING;

        return ProjectState.COMPLETED;
    }

    /**  Returns the last time a task updated in the project */
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
    /**  Returns the title of the project */
    public String getTitle()
    {
        return title;
    }
    /**  Returns the id of the project */
    public int getId()
    {
        return id;
    }
    /**  Returns a reference to the list of tasks */
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
