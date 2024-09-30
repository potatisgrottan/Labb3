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

    /**
     * Constructs a new task
     *
     * @param description The description of the task
     * @param prio The priority of the task
     * @param id The unique identifier for the task
     */
    Task(String description, TaskPrio prio, int id) {
        this.description = description;
        this.prio = prio;
        this.id = id;
        this.state = TaskState.TO_DO;
        this.takenBy = null;
        this.lastUpdate = LocalDate.now();
    }

    /**
     * Assigns the task to a person
     *
     * @param takenBy The name of the person taking the task
     * @throws IllegalArgumentException if the task is already assigned to someone
     */
    public void setTakenBy(String takenBy) {
        if (this.takenBy != null)
            throw new IllegalArgumentException("Task already taken by " + this.takenBy);

        this.takenBy = takenBy;
        lastUpdate = LocalDate.now();
    }

    /**
     * Updates the state of the task
     *
     * @param state The new state to set for the task
     */
    public void setState(TaskState state){
        this.state = state;
        lastUpdate = LocalDate.now();
    }

    /**
     * Sets the priority level of the task
     *
     * @param prio The new priority to set for the task
     */
    public void setPrio(TaskPrio prio){
        this.prio = prio;
        lastUpdate = LocalDate.now();
    }

    /**
     * Gets the current state of the task
     *
     * @return The current TaskState of the task
     */
    public TaskState getState()
    {
        return state;
    }

    /**
     * Gets the date of the last update to the task
     *
     * @return The LocalDate when the task was last updated
     */
    public LocalDate getLastUpdate()
    {
        return lastUpdate;
    }

    /**
     * Gets the priority level of the task according to the TaskPrio enum
     *
     * @return The TaskPrio of the task
     */
    public TaskPrio getPrio()
    {
        return prio;
    }

    /**
     * Gets the name of the person assigned to the task
     *
     * @return The name of the person assigned to the task, or null if unassigned
     */
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

    /**
     * Compares this task to another task based on priority and description,
     * if priority is equal, then we compare the description
     *
     * @param other The task to compare to
     * @return A negative number, zero, or a positive number as this task is less than, equal to, or greater than the specified task
     */
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
