package se.kth.olof.beyar.labb3.projectApp.model.matchers;

import se.kth.olof.beyar.labb3.projectApp.model.Task;

public class TakenByMatcher implements ITaskMatcher
{
    private final String takenBy;

    public TakenByMatcher(String takenBy){
        this.takenBy = takenBy;
    }

    @Override
    public boolean match(Task task){
        return task.getTakenBy().equals(takenBy);
    }
}
