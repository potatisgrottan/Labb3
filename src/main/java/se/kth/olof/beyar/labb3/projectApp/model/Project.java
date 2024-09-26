package se.kth.olof.beyar.labb3.projectApp.model;

import se.kth.olof.beyar.labb3.projectApp.model.matcher.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Project implements Comparable<Project>, Serializable {
    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;

    //TODO Ska va package private men kommer ej ihåg hur man gör
    // Vad menas? // Beyar
    private Project(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.created = LocalDate.now();
    }

    public Task getTaskById(int id) {
        //TODO implement
    }

    public List<Task> findTasks(ITaskMatcher matcher) {
        //TODO implement
    }

    public Task addTask(String description, TaskPrio prio) {
        //TODO implement
    }

    public boolean removeTask(Task task) {
        //TODO implement
        return false;
    }

    public ProjectState getState() {
        //TODO implement
    }

    public LocalDate getLastUpdated(){
        return created;
    }

    public int compareTo(Project other){
        //TODO implement
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", created=" + created +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        //TODO implement
        return 0;
    }
}
