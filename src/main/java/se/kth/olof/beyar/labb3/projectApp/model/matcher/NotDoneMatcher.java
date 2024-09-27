package se.kth.olof.beyar.labb3.projectApp.model.matcher;

import se.kth.olof.beyar.labb3.projectApp.model.Task;
import se.kth.olof.beyar.labb3.projectApp.model.TaskState;

public class NotDoneMatcher implements ITaskMatcher {
    public boolean match(Task task) {
        // We match against TaskState.IN_PROGRESS & TaskState.TO_DO
        return !task.getState().equals(TaskState.DONE);
    }
}
