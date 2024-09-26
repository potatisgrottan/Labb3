package se.kth.olof.beyar.labb3.projectApp.model;

import se.kth.olof.beyar.labb3.projectApp.model.matcher.ITaskMatcher;

import java.time.LocalDate;
import java.util.List;

public class Project implements Comparable {
    private String title;
    private String description;
    private int id;
    private LocalDate created;

    //Ska va package private men kommer ej ihåg hur man gör
    private Project(String title, String description, int id){
        this.title=title;
        this.description=description;
        this.id=id;
        this.created=LocalDate.now();
    }

    public Task getTaskById(int id){
        //TODO implement
    }

    public List<Task> findTasks(ITaskMatcher matcher){
        //TODO implement
    }

    public Task addTask(String description, Prio prio){

    }

    public boolean removeTask(Task task){
        //TODO implement
        return false;
    }

    public ProjectState getState(){

    }

    public LocalDate getLastUpdated(){
        //TODO implement
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
