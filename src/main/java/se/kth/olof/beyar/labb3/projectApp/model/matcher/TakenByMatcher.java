package se.kth.olof.beyar.labb3.projectApp.model.matcher;

import se.kth.olof.beyar.labb3.projectApp.model.Task;

public class TakenByMatcher implements ITaskMatcher {
    private String takenBy;

    public TakenByMatcher(String takenBy){
        this.takenBy = takenBy;
    }

    @Override
    public boolean match(Task task){
        //TODO implement
        return false;
    }
}
