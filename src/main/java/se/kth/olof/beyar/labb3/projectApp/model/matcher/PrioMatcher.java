package se.kth.olof.beyar.labb3.projectApp.model.matcher;

import se.kth.olof.beyar.labb3.projectApp.model.Task;
import se.kth.olof.beyar.labb3.projectApp.model.TaskPrio;

public class PrioMatcher implements ITaskMatcher  {
    private TaskPrio prio;

    public PrioMatcher(TaskPrio prio) {
        this.prio = prio;
    }

    public boolean match(Task task) {
        //TODO implement
        return false;
    }
}
