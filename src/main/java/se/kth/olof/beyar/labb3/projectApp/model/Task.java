package se.kth.olof.beyar.labb3.projectApp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable {
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    Task(String description, TaskPrio prio, int id) {
        this.description = description;
        this.prio = prio;
        this.id = id;
        this.lastUpdate = LocalDate.now();
    }

    public void setTakenBy(String takenBy) {
        if (takenBy != null)
            throw new IllegalArgumentException("Activity already taken");

        this.takenBy = takenBy;
        lastUpdate = LocalDate.now();
    }

    public void setState(TaskState state){
        this.state = state;
        lastUpdate = LocalDate.now();
    }

    public void setPrio(TaskPrio prio){
        this.prio = prio;
        lastUpdate = LocalDate.now();
    }

    public TaskState getState()
    {
        return state;
    }

    public LocalDate getLastUpdate()
    {
        return lastUpdate;
    }

    public TaskPrio getPrio()
    {
        return prio;
    }

    public String getTakenBy()
    {
        return takenBy;
    }

    @Override
    public int compareTo(Task other)
    {
        int prioCompare = this.prio.compareTo(other.prio);

        if (prioCompare != 0)
            return prioCompare;
        else
            return this.description.compareTo(other.description);
    }
}
