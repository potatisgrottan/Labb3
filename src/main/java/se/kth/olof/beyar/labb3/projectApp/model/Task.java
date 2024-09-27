package se.kth.olof.beyar.labb3.projectApp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable {
    private String description;
    private int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    //Ska va package private men kommer ej ihåg hur man gör
    // Vad menas? // Beyar
    private Task(String descr, TaskPrio prio, int id) {
        this.description = descr;
        this.prio = prio;
        this.id = id;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }

    public void setState(TaskState state){
        this.state = state;
    }

    public void setPrio(TaskPrio prio){
        this.prio = prio;
    }

    /*@Override
    public int compareTo(Object o) {
        //TODO implement
        return 0;
    }*/

    @Override
    public int compareTo(Task o)
    {
        //TODO implement
        return 0;
    }
}
