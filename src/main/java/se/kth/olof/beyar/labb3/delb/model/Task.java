package se.kth.olof.beyar.labb3.delb.model;

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
        this.state = TaskState.TO_DO;
        this.lastUpdate = LocalDate.now();
    }

    public void setTakenBy(String takenBy) {
        if (this.takenBy != null)
            throw new IllegalArgumentException("Task already taken by " + this.takenBy);

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
    public boolean equals(Object other)
    {
        if (this == other) return true;
        if (!(other instanceof Task task)) return false;
        return description.equals(task.description) && prio.equals(task.prio);
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

    @Override
    public String toString()
    {
        return "Task {" +
                "description: '" + description + '\'' +
                ", id: " + id +
                ", takenBy: '" + takenBy + '\'' +
                ", state: " + state +
                ", lastUpdate: " + lastUpdate +
                ", prio: " + prio +
                '}';
    }
}
