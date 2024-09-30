package se.kth.olof.beyar.labb3.delb.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Olof and Beyar
 * This class represents the data and logic of a task
 */
public class Task implements Comparable<Task>, Serializable {
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private TaskPrio prio;

    /** Constructs a new task*/
    Task(String description, TaskPrio prio, int id) {
        this.description = description;
        this.prio = prio;
        this.id = id;
        this.state = TaskState.TO_DO;
        this.takenBy=null;
        this.lastUpdate = LocalDate.now();
    }

    /** Sets a name on who is assaigned to the task*/
    public void setTakenBy(String takenBy) {
        if (this.takenBy != null)
            throw new IllegalArgumentException("Task already taken by " + this.takenBy);

        this.takenBy = takenBy;
        lastUpdate = LocalDate.now();
    }

    /**Sets a new state to the task  */
    public void setState(TaskState state){
        this.state = state;
        lastUpdate = LocalDate.now();
    }

    /** Sets the tasks priority level*/
    public void setPrio(TaskPrio prio){
        this.prio = prio;
        lastUpdate = LocalDate.now();
    }

    /** Returns the state that the task is in */
    public TaskState getState()
    {
        return state;
    }

    /** Returns the last time that the task was updated */
    public LocalDate getLastUpdate()
    {
        return lastUpdate;
    }

    /** Returns the tasks priority level */
    public TaskPrio getPrio()
    {
        return prio;
    }

    /** Returns who has taken the task */
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
        return "\tTask {" +
                "description: '" + description + '\'' +
                ", id: " + id +
                ", takenBy: '" + takenBy + '\'' +
                ", state: " + state +
                ", lastUpdate: " + lastUpdate +
                ", prio: " + prio +
                '}';
    }
}
