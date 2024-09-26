package se.kth.olof.beyar.labb3.projectApp.model;

import java.time.LocalDate;

public class Task implements Comparable {
    private String description;
    private String takenBy;
    private int id;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;

    //Ska va package private men kommer ej ihåg hur man gör
    private Task(String descr, Prio prio, int id){
        this.description=descr;
        this.prio=prio;
        this.id=id;
    }

    public void setTakenBy(String takenBy) {
        // this.takenBy = takenBy;
        //TODO implement

    }

    public void setState(TaskState state){
        //TODO implement
    }

    public void setPrio(Prio prio){
        //TODO implement
    }

    @Override
    public int compareTo(Object o) {
        //TODO implement
        return 0;
    }
}
