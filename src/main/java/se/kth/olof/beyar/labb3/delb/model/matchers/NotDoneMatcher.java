package se.kth.olof.beyar.labb3.delb.model.matchers;

import se.kth.olof.beyar.labb3.delb.model.Task;
import se.kth.olof.beyar.labb3.delb.model.TaskState;

public class NotDoneMatcher implements ITaskMatcher
{
    public boolean match(Task task) {
        // We match against TaskState.IN_PROGRESS & TaskState.TO_DO
        return !task.getState().equals(TaskState.DONE);
    }
}
