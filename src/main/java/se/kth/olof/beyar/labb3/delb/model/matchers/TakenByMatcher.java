package se.kth.olof.beyar.labb3.delb.model.matchers;

import se.kth.olof.beyar.labb3.delb.model.Task;

public class TakenByMatcher implements ITaskMatcher
{
    private final String takenBy;

    public TakenByMatcher(String takenBy){
        this.takenBy = takenBy;
    }

    @Override
    public boolean match(Task task){
        if (task.getTakenBy() == null) return false;
        return task.getTakenBy().equals(takenBy);
    }
}
