package se.kth.olof.beyar.labb3.delb.model.matchers;

import se.kth.olof.beyar.labb3.delb.model.Task;
import se.kth.olof.beyar.labb3.delb.model.TaskPrio;

public class PrioMatcher implements ITaskMatcher
{
    private final TaskPrio prio;

    public PrioMatcher(TaskPrio prio) {
        this.prio = prio;
    }

    public boolean match(Task task) {
        return this.prio.equals(task.getPrio());
    }
}
