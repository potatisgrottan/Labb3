package se.kth.olof.beyar.labb3.projectApp.model;

public class TitleNotUniqueException extends RuntimeException {

    public TitleNotUniqueException(){}
    public TitleNotUniqueException(String message) {
        super(message);
    }

}
